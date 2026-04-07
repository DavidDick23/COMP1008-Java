import java.util.Random;
class Game {
    public static void main(String[] args) {
        Fighter fighter = new Fighter("Batman", 100, 15, 50);
        Boss boss = new Boss("Superman", 150, 20, 60);

        Random rand = new Random();
        int round = 1;

        while (fighter.isAlive() && boss.isAlive()) {
            System.out.println("---- Round " + round + " ----");

            // Fighter decision: block or attack
            if (rand.nextInt(100) < 30) {
                fighter.block();
            } else {
                fighter.performAttack(boss);
            }

            boss.performAttack(fighter);

            // End of round updates
            fighter.resetBlock();
            fighter.regenStamina();
            boss.regenStamina();

            System.out.println(fighter.getStatus());
            System.out.println(boss.getStatus());

            round++;
        }

        System.out.println("\nGame Over!");
         System.out.println((fighter.isAlive() ? fighter.name : boss.name) + " Wins!");
    }
}
