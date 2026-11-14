package week9;

import java.util.*;

abstract class Appliance {

    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    double calculateUnits() {
        return (getPower() * hours) / 1000.0;
    }

    double calculateCost(double units) {
        return units * 8;
    }
}

class Fridge extends Appliance {

    Fridge(double hours) {
        super(hours);
    }

    @Override
    double getPower() {
        return 150;
    }
}

class AC extends Appliance {

    AC(double hours) {
        super(hours);
    }

    @Override
    double getPower() {
        return 1500;
    }
}

class TV extends Appliance {

    TV(double hours) {
        super(hours);
    }

    @Override
    double getPower() {
        return 100;
    }
}

class Washer extends Appliance {

    Washer(double hours) {
        super(hours);
    }

    @Override
    double getPower() {
        return 500;
    }
}

public class HomeApplianceEnergyReport {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double totalCost = 0;

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();
            String[] data = line.split(" ");

            String type = data[0];
            double hours = Double.parseDouble(data[1]);

            boolean saver = false;

            if (data.length == 3 && data[2].equals("SAVER")) {
                saver = true;
            }

            if ((type.equals("FRIDGE") || type.equals("TV")) && saver) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            Appliance appliance;

            if (type.equals("FRIDGE")) {
                appliance = new Fridge(hours);
            }
            else if (type.equals("AC")) {
                appliance = new AC(hours);
            }
            else if (type.equals("TV")) {
                appliance = new TV(hours);
            }
            else {
                appliance = new Washer(hours);
            }

            double units = appliance.calculateUnits();

            if (saver) {
                units = units * 0.75;
            }

            double cost = appliance.calculateCost(units);

            totalCost += cost;

            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    type, units, cost);
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);

        sc.close();
    }
}