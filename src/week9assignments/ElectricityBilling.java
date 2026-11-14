package week9assignments;

import java.util.*;

abstract class Connection {
    double units;

    Connection(double units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class Home extends Connection {

    Home(double units) {
        super(units);
    }

    @Override
    double calculateBill() {

        if (units <= 100)
            return units * 5;

        return (100 * 5) + ((units - 100) * 7);
    }
}

class Shop extends Connection {

    Shop(double units) {
        super(units);
    }

    @Override
    double calculateBill() {
        return (units * 8) + 100;
    }
}

class Factory extends Connection {

    Factory(double units) {
        super(units);
    }

    @Override
    double calculateBill() {

        double bill = units * 6;

        if (bill < 1000)
            return 1000;

        return bill;
    }
}

public class ElectricityBilling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Connection> list = new ArrayList<>();
        ArrayList<String> types = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double units = sc.nextDouble();

            types.add(type);

            if (type.equals("HOME")) {

                list.add(new Home(units));

            } else if (type.equals("SHOP")) {

                list.add(new Shop(units));

            } else if (type.equals("FACTORY")) {

                list.add(new Factory(units));
            }
        }

        double total = 0;

        for (int i = 0; i < list.size(); i++) {

            double bill = list.get(i).calculateBill();
            total += bill;

            System.out.printf("%s: %.2f%n",
                    types.get(i), bill);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}