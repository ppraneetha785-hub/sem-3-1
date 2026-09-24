public class Program4 {
    private String color;
    private final String id;

    public Program4(String id) {
        this.id = id;
        this.color = "RED";
    }

    public void next() {
        if (color.equals("RED")) color = "GREEN";
        else if (color.equals("GREEN")) color = "YELLOW";
        else color = "RED";
    }

    public String getColor() {
        return color;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        Program4 t = new Program4("TL-9");
        System.out.println(t.getColor()); // RED
        t.next();
        System.out.println(t.getColor()); // GREEN
        t.next();
        System.out.println(t.getColor()); // YELLOW
        t.next();
        System.out.println(t.getColor()); // RED
    }
}
