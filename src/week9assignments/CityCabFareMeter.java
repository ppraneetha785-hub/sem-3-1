package week9assignments;

import java.util.Scanner;

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    double calculateFare() {
        double fare = km * getRate();

        if (fare < 100) {
            fare = 100;
        }

        return fare;
    }
}

class Mini extends Cab {

    Mini(double km) {
        super(km);
    }

    @Override
    double getRate() {
        return 10;
    }
}

class Sedan extends Cab {

    Sedan(double km) {
        super(km);
    }

    @Override
    double getRate() {
        return 14;
    }
}

class SUV extends Cab {

    SUV(double km) {
        super(km);
    }

    @Override
    double getRate() {
        return 18;
    }
}

public class CityCabFareMeter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String cabType = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            if (cabType.equals("MINI") && time.equals("NIGHT")) {
                System.out.println("MINI: night service not available");
                continue;
            }

            Cab cab;

            if (cabType.equals("MINI")) {
                cab = new Mini(km);
            } else if (cabType.equals("SEDAN")) {
                cab = new Sedan(km);
            } else {
                cab = new SUV(km);
            }

            double fare = cab.calculateFare();

            if (time.equals("NIGHT")) {
                fare = fare * 1.20;
            }

            total += fare;

            System.out.printf("%s: %.2f%n", cabType, fare);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}