import java.text.DecimalFormat;

public class Player extends Character {
    private int monstersKilled;

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getHealth() {
        return super.getHealth();
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

    public Player(String name, double health, int skill, double strength, int gold, int experience) {
        super(name, health, skill, strength, gold, experience);
        this.monstersKilled = 0;
    }


            public void getInfo () {
                System.out.println("Имя: " + getName() +
                        "\nЗдоровье: " + getHealth() +
                        "\nЛовкость: " + getSkill() +
                        "\nСила: " + getStrength() +
                        "\nЗолото: " + getGold() +
                        "\nОпыт: " + getExperience() +
                        "\nУбито монстров: " + monstersKilled);
            }

            public void fight (Monster monster){
            DecimalFormat f = new DecimalFormat("0.00");
            double power = 0;
            if (getSkill() < 10) {
                power = getStrength() * (Math.random() * 0.9);
                if (power == 0)
                    System.out.println("ПРОМАХ");
            }
            if (getSkill() >=10)
                power = getStrength();
            if (getSkill() >= 20)
                power = getStrength() * 1.5;
                    System.out.println("Player strikes with strength = " + (f.format(power)));
                    monster.setHealth(monster.getHealth() - power);
                }


            public void monsterKilled () {
                monstersKilled++;
                System.out.println("Монстр уничтожен! Остаток здоровья: " + getHealth());

            }
        }

