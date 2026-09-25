package week6;

public class StudentDemo {
    static class Student {
        String name;
        int attendance;
        static String collegeName = "SRM Institute of Science and Technology";
        static int studentCount = 0;

        Student(String name, int attendance) {
            this.name = name;
            this.attendance = attendance;
            studentCount++;   // increment whenever a new student is created
        }

        void printStudentInfo() {
            System.out.println("Name: " + name + ", Attendance: " + attendance + "%");
        }

        static void printCollegeInfo() {
            System.out.println("College: " + collegeName);
            System.out.println("Total Students created: " + studentCount);
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("Ravi", 90);
        Student s2 = new Student("Anitha", 85);

        s1.printStudentInfo();
        s2.printStudentInfo();

        // Static method call
        Student.printCollegeInfo();
    }
}
