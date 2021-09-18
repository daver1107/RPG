public class Governor extends Character{
    public Governor() {
        super("Governor", 100, 0, 0, 1000000000, 0);
    }

    void zombiesKilledReward(Player player){
        if (player.getZombiesKilled() == 0) {
            System.out.println("Убейте Зомби, чтобы вернуться за наградой");
        }
        else
        while(player.getZombiesKilled() > 0)
        {
            player.setZombiesKilled(player.getZombiesKilled()-1);
            player.setGold(player.getGold()+1000);
            System.out.println("Награда за зомби получена. +1000 золота ");

        }
        }

    void skelletonKilledReward(Player player){
        if (player.getSkeletonsKilled() == 0) {
            System.out.println("Убейте Скелета, чтобы вернуться за наградой");
        }
        else
        while(player.getSkeletonsKilled() > 0)
        {
            player.setSkeletonsKilled(player.getSkeletonsKilled()-1);
            player.setGold(player.getGold()+500);
            System.out.println("Награда за скелета получена. +500 золота ");

        }
    }
    }

