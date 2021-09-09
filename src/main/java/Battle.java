public class Battle {
    Player player;
    Monster monster;

    public Battle(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
    }

    public void startBattle() {
        while (player.isAlive() && monster.isAlive()) {
            if (experienceCheck() > 0) {
                player.fight(monster);
                monster.fight(player);
            } else {
                monster.fight(player);
                player.fight(monster);
            }
            if (!monster.isAlive())
                player.playerWins(monster);
            if (!player.isAlive())
               return;

        }
    }

    //По опыту персонажей определяем, кто бьет первым
    private int experienceCheck() {
        if (player.getExperience() > monster.getExperience())
            return 1;
        else return 0;
    }

}
