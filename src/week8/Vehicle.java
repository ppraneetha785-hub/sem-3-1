package week8;

import java.util.*;

abstract class Vehicle {
    int hours;
    Vehicle(int hours) { this.hours = hours; }
    abstract double charge();
}

class Bike extends Vehicle {
    Bike(int h) { super(h); }
    double charge() { return hours * 10; }
}

class Car extends Vehicle {
    Car(int h) { super(h); }
    double charge() { return 30 + (hours - 1) * 20; }
}

class Truck extends Vehicle {
    Truck(int h) { super(h); }
    double charge() { return Math.max(100, hours * 50); }
}

class ParkingChargeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double total = 0;
        for (int i = 0; i < N; i++) {
            String type = sc.next();
            int hrs = sc.nextInt();
            Vehicle v;
            switch (type) {
                case "BIKE": v = new Bike(hrs); break;
                case "CAR": v = new Car(hrs); break;
                default: v = new Truck(hrs);
            }
            double ch = v.charge();
            System.out.printf("%s: %.2f%n", type, ch);
            total += ch;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
