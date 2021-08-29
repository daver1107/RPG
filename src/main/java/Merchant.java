public class Merchant extends Character{
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getHealth() {
        return super.getHealth();
    }

    @Override
    public int getSkill() {
        return super.getSkill();
    }

    @Override
    public double getStrength() {
        return super.getStrength();
    }

    @Override
    public void setHealth(double health) {
        super.setHealth(health);
    }

    @Override
    public void setSkill(int skill) {
        super.setSkill(skill);
    }

    @Override
    public void setStrength(double strength) {
        super.setStrength(strength);
    }

    @Override
    public void setGold(int gold) {
        super.setGold(gold);
    }

    @Override
    public void setExperience(int experience) {
        super.setExperience(experience);
    }

    @Override
    public int getGold() {
        return super.getGold();
    }

    @Override
    public int getExperience() {
        return super.getExperience();
    }

    public Merchant(String name, int health, int skill, int strength, int gold, int experience) {
        super(name, health, skill, strength, gold, experience);
    }

    public void sellHealth(Player player, int size){
        if (player.getHealth() == 100)
            System.out.println("У вас максимальное здоровье: " + player.getHealth());
        else
        if(size == 1) {
            player.setHealth(player.getHealth() + 50);
            if (player.getHealth() > 100)
                player.setHealth(100);
            player.setGold(player.getGold() - 50);
            this.setGold(this.getGold() + 50);
            System.out.println("Здоровье увеличен на 50 единиц. Всего: " + player.getHealth());
        }
        if(size == 2) {
            player.setHealth(player.getHealth() + 100);
            if (player.getHealth() > 100)
                player.setHealth(100);
            player.setGold(player.getGold() - 100);
            this.setGold(this.getGold() + 100);
            System.out.println("Здоровье пополнено. Всего: " + player.getHealth());
        }

    }
}