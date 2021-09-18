public class Merchant extends Character {
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getHealth() {
        return super.getHealth();
    }

    @Override
    public int getSkill() {
        return super.getSkill();
    }

    @Override
    public int getStrength() {
        return super.getStrength();
    }

    @Override
    public void setHealth(int health) {
        super.setHealth(health);
    }

    @Override
    public void setSkill(int skill) {
        super.setSkill(skill);
    }

    @Override
    public void setStrength(int strength) {
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
        super(name, health, skill, strength, gold);
    }

    public void heal(Player player, int size) {
        if (player.getHealth() == 100)
            System.out.println("У вас максимальное здоровье: " + player.getHealth());
        else if (size == 1) {
            player.renewHealth(50);
            player.spendMoney(50);
            this.setGold(this.getGold() + 50);
        }
        if (size == 2) {
            player.renewHealth(100);
            player.spendMoney(100);
            this.setGold(this.getGold() + 100);
        }

    }

}

