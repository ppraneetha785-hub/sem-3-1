package week8;

import java.util.*;
import java.time.*;

abstract class Plan {
    String name;
    LocalDate start;
    Plan(String n, LocalDate s) { name = n; start = s; }
    abstract LocalDate renewalDate();
}

class BasicPlan extends Plan {
    BasicPlan(String n, LocalDate s) { super(n, s); }
    LocalDate renewalDate() { return start.plusDays(30); }
}

class StandardPlan extends Plan {
    StandardPlan(String n, LocalDate s) { super(n, s); }
    LocalDate renewalDate() { return start.plusDays(90); }
}

class PremiumPlan extends Plan {
    PremiumPlan(String n, LocalDate s) { super(n, s); }
    LocalDate renewalDate() { return start.plusDays(365); }
}

class StreamingReminderDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate start = LocalDate.parse(sc.next());
            Plan p;
            switch (type) {
                case "BASIC": p = new BasicPlan(name, start); break;
                case "STANDARD": p = new StandardPlan(name, start); break;
                default: p = new PremiumPlan(name, start);
            }
            System.out.println(name + ": " + p.renewalDate());
        }
    }
}
