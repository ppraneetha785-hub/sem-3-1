package week8;

import java.util.*;

abstract class Transport {
    double distance;
    Transport(double d) { distance = d; }
    abstract double fare();
}

class Bus extends Transport {
    Bus(double d) { super(d); }
    double fare() {
        double f = 2 + 0.1 * distance;
        return Math.min(f, 10); // Max fare capped at 10
    }
}

class Train extends Transport {
    Train(double d) { super(d); }
    double fare() { return 3 + 0.15 * distance; }
}

class Metro extends Transport {
    double factor;
    Metro(double d, double f) { super(d); factor = f; }
    double fare() { return (1.5 + 0.2 * distance) * factor; }
}

class TransportFareDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double total = 0;

        for (int i = 0; i < N; i++) {
            String type = sc.next();
            if (type.equals("BUS")) {
                double d = sc.nextDouble();
                Transport t = new Bus(d);
                double f = t.fare();
                System.out.printf("BUS: %.2f%n", f);
                total += f;
            } else if (type.equals("TRAIN")) {
                double d = sc.nextDouble();
                Transport t = new Train(d);
                double f = t.fare();
                System.out.printf("TRAIN: %.2f%n", f);
                total += f;
            } else if (type.equals("METRO")) {
                double d = sc.nextDouble();
                double factor = sc.nextDouble();
                Transport t = new Metro(d, factor);
                double f = t.fare();
                System.out.printf("METRO: %.2f%n", f);
                total += f;
            }
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
