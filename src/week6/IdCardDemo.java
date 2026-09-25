package week6;

public class IdCardDemo {
    static class IdCard {
        String name;
        int booksIssued;

        IdCard(String name, int booksIssued) {
            this.name = name;
            this.booksIssued = booksIssued;
        }
    }

    public static void main(String[] args) {
        // Create one IdCard object for Ravi
        IdCard ravi = new IdCard("Ravi", 0);

        // Assign a second variable to point at the same object
        IdCard duplicate = ravi;
        duplicate.booksIssued = 3;  // change via duplicate

        // Create a third, separate IdCard object with identical values
        IdCard separate = new IdCard("Ravi", 3);

        // Print results
        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}
