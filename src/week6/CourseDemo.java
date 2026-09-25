package week6;

public class CourseDemo {
    static class Course {
        String code, title;
        int credits, labCredits;

        // Constructor for theory + lab courses
        public Course(String code, String title, int credits, int labCredits) {
            this.code = code;
            this.title = title;
            this.credits = credits;
            this.labCredits = labCredits;
        }

        // Constructor for theory-only courses (chains to the above)
        public Course(String code, String title, int credits) {
            this(code, title, credits, 0); // labCredits set to 0
        }

        int totalCredits() {
            return credits + labCredits;
        }
    }

    public static void main(String[] args) {
        Course theoryCourse = new Course("21CSC201J", "Data Structures", 4);
        Course labCourse = new Course("21CSC205L", "DSA Lab", 3, 1);

        System.out.println(theoryCourse.code + " total credits: " + theoryCourse.totalCredits());
        System.out.println(labCourse.code + " total credits: " + labCourse.totalCredits());
    }
}

