public class Battle {
    Player player;
    Monster monster;

    public Battle(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
    }

    public void startBattle() {
        if (skillCheck() > 0) {
            while (player.isAlive() && monster.isAlive()) {
                player.fight(monster);
                chanceOfSecondStrike();
                monster.fight(player);
            }
        } else {
            while (player.isAlive() && monster.isAlive()) {
                monster.fight(player);
                player.fight(monster);
                chanceOfSecondStrike();

            }
        }
        if (!monster.isAlive())
            player.playerWins(monster);
        if (!player.isAlive())
            System.out.println("Игрок уничтожен");
    }

    private int skillCheck() {
        if (player.getSkill() > monster.getSkill())
            return 1;
        else return 0;
    }

    private void chanceOfSecondStrike() {
        int chance = (int) (Math.random() * 20);
        if ((player.getMoral() >= 10 && chance > 15) || (player.getMoral() >= 20 && chance > 10) || (player.getMoral() >= 30 && chance > 5))
            System.out.println("Moral is high! you have a second strike!");
        player.fight(monster);

    }
}
