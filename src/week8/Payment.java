package week8;

import java.util.*;

abstract class Payment {
    double amount;
    Payment(double amt) { this.amount = amt; }
    abstract double adjustedAmount();
}

class CardPayment extends Payment {
    CardPayment(double amt) { super(amt); }
    double adjustedAmount() { return amount * 1.02; }
}

class WalletPayment extends Payment {
    WalletPayment(double amt) { super(amt); }
    double adjustedAmount() { return amount * 1.01; }
}

class BankTransferPayment extends Payment {
    BankTransferPayment(double amt) { super(amt); }
    double adjustedAmount() { return amount; }
}

class PaymentSystemDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double total = 0;
        for (int i = 0; i < N; i++) {
            String type = sc.next();
            double amt = sc.nextDouble();
            Payment p;
            switch (type) {
                case "CARD": p = new CardPayment(amt); break;
                case "WALLET": p = new WalletPayment(amt); break;
                default: p = new BankTransferPayment(amt);
            }
            double adj = p.adjustedAmount();
            System.out.printf("%s: %.2f%n", type, adj);
            total += adj;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
