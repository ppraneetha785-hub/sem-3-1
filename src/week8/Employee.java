package week8;

import java.util.*;

abstract class Employee {
    String name;
    double salary;
    Employee(String n, double s) { name = n; salary = s; }
    abstract double bonus();
}

class FullTime extends Employee {
    FullTime(String n, double s) { super(n, s); }
    double bonus() { return salary * 0.1; }
}

class PartTime extends Employee {
    PartTime(String n, double s) { super(n, s); }
    double bonus() { return salary * 0.05; }
}

class Intern extends Employee {
    Intern(String n, double s) { super(n, s); }
    double bonus() { return 2000; }
}

class BonusCalculatorDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double total = 0;
        for (int i = 0; i < N; i++) {
            String type = sc.next();
            String name = sc.next();
            double sal = sc.nextDouble();
            Employee e;
            switch (type) {
                case "FULLTIME": e = new FullTime(name, sal); break;
                case "PARTTIME": e = new PartTime(name, sal); break;
                default: e = new Intern(name, sal);
            }
            double b = e.bonus();
            System.out.printf("%s: %.2f%n", name, b);
            total += b;
        }
        System.out.printf("Total Bonus: %.2f%n", total);
    }
}
