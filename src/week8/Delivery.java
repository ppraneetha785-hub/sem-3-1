package week8;

import java.util.*;

abstract class Delivery {
    double weight, distance;
    Delivery(double w, double d) { weight = w; distance = d; }
    abstract double fee();
}

class StandardDelivery extends Delivery {
    StandardDelivery(double w, double d) { super(w, d); }
    double fee() { return 5 + 0.5 * weight + 0.1 * distance; }
}

class ExpressDelivery extends Delivery {
    ExpressDelivery(double w, double d) { super(w, d); }
    double fee() { return 15 + 1.0 * weight + 0.2 * distance; }
}

class InternationalDelivery extends Delivery {
    double customsFee;
    InternationalDelivery(double w, double d, double c) { super(w, d); customsFee = c; }
    double fee() { return 25 + 2.0 * weight + 0.5 * distance + customsFee; }
}

class DeliveryFeeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double total = 0;
        for (int i = 0; i < N; i++) {
            String type = sc.next();
            if (type.equals("STANDARD")) {
                double w = sc.nextDouble(), d = sc.nextDouble();
                Delivery dly = new StandardDelivery(w, d);
                double f = dly.fee();
                System.out.printf("STANDARD: %.2f%n", f);
                total += f;
            } else if (type.equals("EXPRESS")) {
                double w = sc.nextDouble(), d = sc.nextDouble();
                Delivery dly = new ExpressDelivery(w, d);
                double f = dly.fee();
                System.out.printf("EXPRESS: %.2f%n", f);
                total += f;
            } else {
                double w = sc.nextDouble(), d = sc.nextDouble(), c = sc.nextDouble();
                Delivery dly = new InternationalDelivery(w, d, c);
                double f = dly.fee();
                System.out.printf("INTERNATIONAL: %.2f%n", f);
                total += f;
            }
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
