public class Program9 {
    private String code;
    private final int lockerNumber;

    public Program9(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.code = initialCode;
    }

    public void changeCode(String currentCode, String newCode) {
        if (this.code.equals(currentCode)) {
            this.code = newCode;
            System.out.println("Code changed successfully!");
        } else {
            System.out.println("Incorrect current code. Change rejected.");
        }
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {
        Program9 l = new Program9(101, "1234");
        l.changeCode("1234", "5678"); // success
        l.changeCode("0000", "9999"); // rejected
    }
}
