package week9assignments;

import java.util.*;

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateFee();
}

class DayScholar extends Student {

    DayScholar(String name) {
        super(name);
    }

    @Override
    double calculateFee() {
        return 40000 + 12000;
    }
}

class Hosteller extends Student {

    Hosteller(String name) {
        super(name);
    }

    @Override
    double calculateFee() {
        return 40000 + 60000;
    }
}

class ScholarStudent extends Student {

    ScholarStudent(String name) {
        super(name);
    }

    @Override
    double calculateFee() {
        return 20000 + 12000;
    }
}

public class CollegeFeeCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();

            if (type.equals("DAY_SCHOLAR")) {
                students.add(new DayScholar(name));
            }
            else if (type.equals("HOSTELLER")) {
                students.add(new Hosteller(name));
            }
            else if (type.equals("SCHOLAR")) {
                students.add(new ScholarStudent(name));
            }
        }

        double totalCollected = 0;

        for (Student s : students) {

            double fee = s.calculateFee();
            totalCollected += fee;

            System.out.printf("%s: %.2f%n", s.name, fee);
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);

        sc.close();
    }
}