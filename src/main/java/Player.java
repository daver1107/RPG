public class Player extends Character {
    private int zombiesKilled;
    private int skeletons;

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getHealth() {
        return super.getHealth();
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

    public Player(String name, int health, int skill, int strength, int gold, int experience) {
        super(name, health, skill, strength, gold, experience);
    }


    public void getInfo() {
        System.out.println("Имя: " + getName() +
                "\nЗдоровье: " + getHealth() +
                "\nЛовкость: " + getSkill() +
                "\nСила: " + getStrength() +
                "\nЗолото: " + getGold() +
                "\nОпыт: " + getExperience() +
                "\nУбито монстров: " +
                "\n Зомби: " + zombiesKilled +
                "\n Скелеты: " + skeletons);
    }

    public void fight(Monster monster) {
        int power = 0;
        if (getSkill() < 10) {
            power = getStrength() * (int) (Math.random() * 0.9);
            if (power == 0)
                System.out.println("ПРОМАХ");
        }
        if (getSkill() >= 10)
            power = getStrength();
        if (getSkill() >= 20)
            power = (int) (getStrength() * 1.5);
        System.out.println("Player strikes with strength = " + power);
        monster.setHealth(monster.getHealth() - power);
    }

    public void monsterKilled(Monster monster) {
        if (monster instanceof Skeleton)
            skeletons++;
        if (monster instanceof Zombie)
            zombiesKilled++;
        System.out.println("Монстр " + monster.getName() + " уничтожен! Остаток здоровья: " + getHealth());
        if (monster.getExperience() < 10) {
            this.setExperience(getExperience() + 1);
            this.setSkill(getSkill() + 1);
        }
        if (monster.getExperience() >= 10) {
            this.setExperience(getExperience() + 3);
            this.setSkill(getSkill() + 2);
        }
        if (monster.getExperience() >= 20) {
            this.setExperience(getExperience() + 5);
            this.setSkill(getSkill() + 4);
        }
    }
}