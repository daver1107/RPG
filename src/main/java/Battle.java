public class Battle {

    public void startBattle(Player player, Monster monster) {
        if (skillCheck(player, monster) > 0) {
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
            player.monsterKilled(monster);
        if (!player.isAlive())
            System.out.println("Игрок уничтожен");
    }

    private int skillCheck(Player player, Monster monster) {
        if (player.getSkill() > monster.getSkill())
            return 1;
        else return 0;
    }

}
