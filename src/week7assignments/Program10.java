public class Program10 {
    private String[] students;
    private int count;

    public Program10(int maxSize) {
        students = new String[maxSize];
        count = 0;
    }

    public void markPresent(String name) {
        if (!isPresent(name)) {
            if (count < students.length) {
                students[count] = name;
                count++;
            }
        }
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (students[i].equals(name)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Program10 sheet = new Program10(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana"); // duplicate ignored

        System.out.println("Present count = " + sheet.getPresentCount()); // 2
        System.out.println("Is Ben present? " + sheet.isPresent("Ben")); // true
        System.out.println("Is Chen present? " + sheet.isPresent("Chen")); // false
    }
}
