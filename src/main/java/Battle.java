public class Battle {
    Player player;
    Monster monster;

    public Battle(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
    }

    public void startBattle() {
        if (experienceCheck() > 0) {
            while (player.isAlive() && monster.isAlive()) {
                player.fight(monster);
                monster.fight(player);
            }
        } else {
            while (player.isAlive() && monster.isAlive()) {
                monster.fight(player);
                player.fight(monster);
            }
        }
        if (!monster.isAlive())
            player.playerWins(monster);
        if (!player.isAlive())
            System.out.println("Игрок уничтожен");
    }

    //По опыту персонажей определяем, кто бьет первым
    private int experienceCheck() {
        if (player.getExperience() > monster.getExperience())
            return 1;
        else return 0;
    }

}
