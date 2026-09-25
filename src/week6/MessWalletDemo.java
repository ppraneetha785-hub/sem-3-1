package week6;

public class MessWalletDemo {
    static class MessWallet {
        private double balance;

        MessWallet(double opening) {
            if (opening < 0) {
                balance = 0;
                System.out.println("Warning: Negative opening balance, set to 0");
            } else {
                balance = opening;
            }
        }

        void topUp(double amount) {
            if (amount <= 0) {
                System.out.println("Top-up rejected: invalid amount");
            } else {
                balance += amount;
                System.out.println("Balance after top-up: " + balance);
            }
        }

        void deduct(double amount) {
            if (amount > balance) {
                System.out.println("Deduct rejected: insufficient balance");
            } else {
                balance -= amount;
                System.out.println("Balance after deduct: " + balance);
            }
        }

        double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);   // opening balance
        wallet.topUp(200);                         // add money
        wallet.deduct(1000);                       // try to deduct more than balance
        System.out.println("Final balance: " + wallet.getBalance());
    }
}
