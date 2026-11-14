package week9assignments;

import java.util.*;

abstract class Plot {
    String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double area();
}

class Circle extends Plot {
    double radius;

    Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Plot {
    double length, width;

    Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}

class Triangle extends Plot {
    double base, height;

    Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    @Override
    double area() {
        return 0.5 * base * height;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Plot> plots = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String shape = sc.next();

            if (shape.equalsIgnoreCase("CIRCLE")) {

                String owner = sc.next();
                double radius = sc.nextDouble();

                plots.add(new Circle(owner, radius));

            } else if (shape.equalsIgnoreCase("RECTANGLE")) {

                String owner = sc.next();
                double length = sc.nextDouble();
                double width = sc.nextDouble();

                plots.add(new Rectangle(owner, length, width));

            } else if (shape.equalsIgnoreCase("TRIANGLE")) {

                String owner = sc.next();
                double base = sc.nextDouble();
                double height = sc.nextDouble();

                plots.add(new Triangle(owner, base, height));
            }
        }

        double total = 0;

        for (Plot p : plots) {

            double a = p.area();
            total += a;

            System.out.printf("%s (%s): %.2f%n",
                    p.owner,
                    p.getClass().getSimpleName().toUpperCase(),
                    a);
        }

        System.out.printf("Total Area: %.2f%n", total);

        sc.close();
    }
}