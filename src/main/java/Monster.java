public abstract class Monster extends Character {
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

    public Monster(String name, int health, int skill, int strength, int experience) {
        super(name, health, skill, strength, experience);
    }

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
    public int getGold() {
        return super.getGold();
    }

    @Override
    public int getExperience() {
        return super.getExperience();
    }

    public void fight(Player player) {
        int power = 0;
        if (getSkill() < 10) {

            power = (int) (getStrength() * Math.random());
                    }
        if (getSkill() >= 10)
            power = getStrength();
        if (getSkill() >= 20)
            power = (int) (getStrength() * 1.5);
        System.out.println("Monster strikes with strength = " + power);
        if (power == 0)
        System.out.println("ПРОМАХ");
        player.setHealth(player.getHealth() - power);
        }

    public Monster() {
    }

    public String getInfo() {
        return "Имя: " + getName() +
                "\nЗдоровье: " + getHealth() +
                "\nЛовкость: " + getSkill() +
                "\nСила: " + getStrength() +
                "\nОпыт: " + getExperience();
    }

}
