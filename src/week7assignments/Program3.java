public class Program3 {
    private final String password;

    public Program3(String password) {
        this.password = password;
    }

    public String getStrength() {
        int len = password.length();
        if (len < 6) return "Weak";
        else if (len <= 9) return "Medium";
        else return "Strong";
    }

    public static void main(String[] args) {
        Program3 pc1 = new Program3("abcd");
        System.out.println(pc1.getStrength()); // Weak

        Program3 pc2 = new Program3("abcdefgh");
        System.out.println(pc2.getStrength()); // Medium

        Program3 pc3 = new Program3("abcdefghij123");
        System.out.println(pc3.getStrength()); // Strong
    }
}
