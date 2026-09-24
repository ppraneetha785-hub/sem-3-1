public class Program1 {
    private int health;
    private final int maxHealth;

    public Program1(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        health -= amount;
        if (health < 0) health = 0;
    }

    public void heal(int amount) {
        health += amount;
        if (health > maxHealth) health = maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public static void main(String[] args) {
        Program1 c = new Program1(100);
        c.takeDamage(30);
        System.out.println("Health = " + c.getHealth()); // 70
        c.heal(50);
        System.out.println("Health = " + c.getHealth()); // 100
        c.takeDamage(150);
        System.out.println("Health = " + c.getHealth()); // 0
    }
}
