// Fighter
class Fighter extends Player implements Shield, Weapon {
    private boolean blocking;
    private int blocksUsed;
    private final int MAX_BLOCKS = 2;

    public Fighter(String name, int health, int power, int stamina) {
        super(name, health, power, stamina);
        this.blocking = false;
        this.blocksUsed = 0;
    }

    @Override
    public int attack() {
        return power;
    }

    @Override
    public boolean block() {
        if (blocksUsed >= MAX_BLOCKS || stamina < 10) return false;

        consumeStamina(10);
        blocking = true;
        blocksUsed++;
        return true;
    }

    @Override
    public void resetBlock() {
        blocking = false;
    }

    @Override
    public void takeDamage(int damage) {
        if (blocking) {
            damage *= 0.5;
        }
        super.takeDamage(damage);
    }

    @Override
    public void performAttack(Player opponent) {
        if (!consumeStamina(15)) return;

        if (canAttack()) {
            int damage = applyCombo(attack());
            opponent.takeDamage(damage);
        } else {
            resetCombo();
        }
    }
}
