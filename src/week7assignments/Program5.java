public class Program5 {
    private double[] prices;
    private int count;
    private final String cartId;

    public Program5(String cartId, int maxItems) {
        this.cartId = cartId;
        prices = new double[maxItems];
        count = 0;
    }

    public void addItem(double price) {
        if (count < prices.length) {
            prices[count] = price;
            count++;
        }
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return count;
    }

    public String getCartId() {
        return cartId;
    }

    public static void main(String[] args) {
        Program5 cart = new Program5("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total = " + cart.getTotal()); // 500
        System.out.println("Item count = " + cart.getItemCount()); // 3
    }
}
