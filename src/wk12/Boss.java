class Boss extends Player implements Weapon, SpecialMove {
    private int cooldown;
    private int weaponBuffTurns;
    private int basePower;

    public Boss(String name, int health, int power, int stamina) {
        super(name, health, power, stamina);
        this.cooldown = 0;
        this.weaponBuffTurns = 0;
        this.basePower = power;
    }

    @Override
    public int attack() {
        return power;
    }

    @Override
    public int specialAttack() {
        return power * 3;
    }

    // Weapon buff: increases power temporarily
    public void useWeaponBuff() {
        if (weaponBuffTurns == 0 && consumeStamina(20)) {
            power = basePower + 10;
            weaponBuffTurns = 3;
        }
    }

    private void updateBuff() {
        if (weaponBuffTurns > 0) {
            weaponBuffTurns--;
            if (weaponBuffTurns == 0) {
                power = basePower;
            }
        }
    }

    @Override
    public void performAttack(Player opponent) {
        updateBuff();

        if (!consumeStamina(15)) return;

        if (!canAttack()) {
            resetCombo();
            return;
        }

        int damage;

        // 25% chance to activate weapon buff
        if (rand.nextInt(100) < 25) {
            useWeaponBuff();
        }

        // Special attack logic
        if (cooldown == 0 && rand.nextInt(100) < 30) {
            damage = applyCombo(specialAttack());
            cooldown = 2;
        } else {
            damage = applyCombo(attack());
            if (cooldown > 0) cooldown--;
        }

        opponent.takeDamage(damage);
    }
}

