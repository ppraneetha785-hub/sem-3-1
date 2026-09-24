public class Program6 {
    private int savings;
    private final String id;

    public Program6(String id) {
        this.id = id;
        this.savings = 0; // starts at 0
    }

    public void deposit(int amount) {
        savings += amount;
    }

    public void withdraw(int amount) {
        if (amount <= savings) {
            savings -= amount;
        } else {
            System.out.println("Withdrawal rejected! Not enough savings.");
        }
    }

    public int getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        Program6 pb = new Program6("PB-1");
        pb.deposit(100);
        System.out.println("Savings = " + pb.getSavings()); // 100
        pb.withdraw(30);
        System.out.println("Savings = " + pb.getSavings()); // 70
        pb.withdraw(500); // rejected
        System.out.println("Savings = " + pb.getSavings()); // 70
    }
}
