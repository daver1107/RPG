public class Monster extends Character {
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

    public Monster(String name, int health, int skill, int strength, int experience) {
        super(name, health, skill, strength, experience);
    }

    public Monster(String name) {
        super(name, 100, (int) (Math.random() * 50), (int) (Math.random() * 20), (int) (Math.random() * 50));
    }


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
    public int getGold() {
        return super.getGold();
    }

    @Override
    public int getExperience() {
        return super.getExperience();
    }

    public void fight(Player player) {

            System.out.println("Monster strikes");
            player.setHealth(player.getHealth() - this.getStrength());
    }

    public String getInfo() {
        return   "Имя: " + getName() +
                "\nЗдоровье: " + getHealth() +
                "\nЛовкость: " + getSkill() +
                "\nСила: " + getStrength() +
                "\nОпыт: " + getExperience();
    }

}
