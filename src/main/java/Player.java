import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.*;

public class Player extends Character {
    private int zombiesKilled;
    private int skeletonsKilled;
    private int moral;
    List<String> bag = new ArrayList<>();

    public int getMoral() {
        return moral;
    }

    public void setMoral(int moral) {
        this.moral = moral;
    }

    public int getZombiesKilled() {
        return zombiesKilled;
    }

    public void setZombiesKilled(int zombiesKilled) {
        this.zombiesKilled = zombiesKilled;
    }

    public int getSkeletonsKilled() {
        return skeletonsKilled;
    }

    public void setSkeletonsKilled(int skeletonsKilled) {
        this.skeletonsKilled = skeletonsKilled;
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
        moral = 10;
        moralState();

    }

    //Выводим информацию об игроке
    public void getInfo() {
        System.out.println("Имя: " + getName() +
                "\nЗдоровье: " + getHealth() +
                "\nЛовкость: " + getSkill() +
                "\nСила: " + getStrength() +
                "\nЗолото: " + getGold() +
                "\nОпыт: " + getExperience() +
                "\nУдача: " + getMoral() +
                "\nУбито монстров: " + (zombiesKilled + skeletonsKilled) +
                "\nАмуниция: " + bag +
                "\n Зомби: " + zombiesKilled +
                "\n Скелеты: " + skeletonsKilled);
    }

    //Сражение с монстром, игрок наносит удар
    public void fight(Monster monster) {
        int power = 0;
        //Если недостаточно единиц ловкости, игрок может промахнуться
        do {
            healInBattle();
            if (getSkill() < 10) {
                power = getStrength() * (int) (Math.random() * 0.9);
                if (power == 0)
                    System.out.println("ПРОМАХ");
            }
            //Игрок наносит обычный удар
            if (getSkill() >= 10)
                power = getStrength();
            //Прокаченный показатель ловкости прибавляет рандомный бонус до +5 к урону
            if (getSkill() >= 20)
                power = getStrength() + ((int) (Math.random() * 6));
            System.out.println("Player strikes with strength = " + power);
            monster.setHealth(monster.getHealth() - power);
        }
        while (chanceOfSecondStrike());
    }


    //Логика изменений параметров героя после выигранной битвы
    //Победа повышает мораль
    public void playerWins(Monster monster) {
        setMoral(getMoral() + 1);
        //Подсчитываем количество убитых монстров
        if (monster instanceof Skeleton)
            skeletonsKilled++;
        if (monster instanceof Zombie)
            zombiesKilled++;
        //Выводим остаток здоровья после выигранной битвы
        System.out.println("Монстр " + monster.getName() + " уничтожен! Остаток здоровья: " + getHealth());
        //Логика прокачки скиллов персонажа
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

    void renewHealth(int health) {
        setHealth(getHealth() + health);
        if (getHealth() > 100)
            setHealth(100);
        System.out.println("Здоровье увеличено на " + health + " единиц. Всего: " + getHealth());
    }

    //Показатель морали уменьшается
    void moralState() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (getMoral() > 0) {
                    setMoral(getMoral() - 1);
                    try {
                        sleep(15000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();

    }

    //Лекарство с собой может быть использовано во время битвы
    void buyMeds(int price, String name) {
        bag.add(name);
        spendMoney(price);
    }

    //При наличии лекарства, пополняем здоровье на критической отметке и продолжаем битву
    void healInBattle() {
        if (getHealth() < 50 && bag.contains("Health 50")) {
            setHealth(getHealth() + 50);
            System.out.println("Использовано лекарство из амуниции. Добавлено + 50 к здоровью");
            bag.remove("Health 50");
        }
        if (getHealth() < 30 && bag.contains("Health 100")) {
            setHealth(getHealth() + 50);
            System.out.println("Использовано лекарство из амуниции. Добавлено + 100 к здоровью");
            bag.remove("Health 100");
        }
    }

    boolean chanceOfSecondStrike() {
        int chance = (int) (Math.random() * 1000);
        if ((getMoral() >= 10 && chance > 800) || (getMoral() >= 20 && chance > 500) || (getMoral() >= 30 && chance > 100)) {
            System.out.println("Moral is high! you have a second strike!");
            return true;
        } else return false;

    }
    void spendMoney(int amount){
        if (getGold() - amount < 0)
            System.out.println("Not enough gold");
        else
            setGold(getGold() - amount);
    }
}
