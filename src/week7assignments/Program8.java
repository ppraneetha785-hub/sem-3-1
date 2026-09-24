public class Program8 {
    private final String firstName;
    private final String lastName;

    public Program8(String fullName) {
        String[] parts = fullName.split(" ");
        this.firstName = parts[0];
        this.lastName = parts[1];
    }

    public String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }

    public static void main(String[] args) {
        Program8 tag = new Program8("Maria Gomez");
        System.out.println("Nickname = " + tag.getNickname()); // Maria G.
    }
}
