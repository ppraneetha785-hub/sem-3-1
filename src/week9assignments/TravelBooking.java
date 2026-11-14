package week9assignments;

import java.util.*;

abstract class Booking {

    static final double BOOKING_FEE = 50;
    double distance;

    Booking(double distance) {
        this.distance = distance;
    }

    abstract double fare();

    double totalFare() {
        return fare() + BOOKING_FEE;
    }
}

class Bus extends Booking {

    Bus(double distance) {
        super(distance);
    }

    @Override
    double fare() {
        return distance * 2;
    }
}

class Train extends Booking {

    Train(double distance) {
        super(distance);
    }

    @Override
    double fare() {
        return distance * 1.5;
    }
}

class Flight extends Booking {

    Flight(double distance) {
        super(distance);
    }

    @Override
    double fare() {
        return 2500 + (distance * 4);
    }
}

public class TravelBooking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Booking> bookings = new ArrayList<>();
        ArrayList<String> modes = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String mode = sc.next();
            double distance = sc.nextDouble();

            modes.add(mode);

            if (mode.equals("BUS")) {

                bookings.add(new Bus(distance));

            } else if (mode.equals("TRAIN")) {

                bookings.add(new Train(distance));

            } else if (mode.equals("FLIGHT")) {

                bookings.add(new Flight(distance));
            }
        }

        for (int i = 0; i < bookings.size(); i++) {

            System.out.printf("%s: %.2f%n",
                    modes.get(i),
                    bookings.get(i).totalFare());
        }

        sc.close();
    }
}