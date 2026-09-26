package week8;

import java.util.*;

abstract class Room {
    int units;
    Room(int u) { units = u; }
    abstract double bill();
}

class SingleRoom extends Room {
    SingleRoom(int u) { super(u); }
    double bill() { return units * 8; }
}

class SharedRoom extends Room {
    int occupants;
    SharedRoom(int u, int occ) { super(u); occupants = occ; }
    double bill() { return (units * 6.0) / occupants; }
}

class AcRoom extends Room {
    AcRoom(int u) { super(u); }
    double bill() { return units * 10 + 200; }
}
class HostelBillDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double total = 0;
        for (int i = 0; i < N; i++) {
            String type = sc.next();
            if (type.equals("SINGLE")) {
                int u = sc.nextInt();
                Room r = new SingleRoom(u);
                double b = r.bill();
                System.out.printf("SINGLE: %.2f%n", b);
                total += b;
            } else if (type.equals("SHARED")) {
                int u = sc.nextInt();
                int occ = sc.nextInt();
                Room r = new SharedRoom(u, occ);
                double b = r.bill();
                System.out.printf("SHARED: %.2f%n", b);
                total += b;
            } else {
                int u = sc.nextInt();
                Room r = new AcRoom(u);
                double b = r.bill();
                System.out.printf("AC: %.2f%n", b);
                total += b;
            }
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
