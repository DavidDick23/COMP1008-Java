import java.util.Random;
// Abstract Player
abstract class Player {
    protected String name;
    protected int health;
    protected int power;
    protected int stamina;
    protected int maxStamina;
    protected int comboCounter;
    protected Random rand;

    public Player(String name, int health, int power, int stamina) {
        this.name = name;
        this.health = health;
        this.power = power;
        this.stamina = stamina;
        this.maxStamina = stamina;
        this.comboCounter = 0;
        this.rand = new Random();
    }

    public abstract void performAttack(Player opponent);

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }

    public boolean isAlive() {
        return health > 0;
    }

    protected boolean canAttack() {
        return rand.nextInt(100) < 70;
    }

    protected int applyCombo(int baseDamage) {
        int scaled = (int)(baseDamage * (1 + comboCounter * 0.1));
        comboCounter++;
        return scaled;
    }

    protected void resetCombo() {
        comboCounter = 0;
    }

    protected void regenStamina() {
        stamina += 10;
        if (stamina > maxStamina) stamina = maxStamina;
    }

    protected boolean consumeStamina(int cost) {
        if (stamina >= cost) {
            stamina -= cost;
            return true;
        }
        return false;
    }

    public String getStatus() {
        return name + " | HP: " + health + " | STA: " + stamina + " | Combo: " + comboCounter;
    }
}
