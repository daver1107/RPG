public abstract class Character {

    private String name;
    private int health;
    private int skill;
    private int strength;
    private int gold;
    private int experience;
    boolean isAlive = true;

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Character(String name, int health, int skill, int strength, int gold, int experience) {
        this.name = name;
        this.health = health;
        this.skill = skill;
        this.strength = strength;
        this.gold = gold;
        this.experience = experience;
    }
    public Character(String name, int health, int skill, int strength, int experience) {
        this.name = name;
        this.health = health;
        this.skill = skill;
        this.strength = strength;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getSkill() {
        return skill;
    }

    public int getStrength() {
        return strength;
    }

    public int getGold() {
        return gold;
    }

    public int getExperience() {
        return experience;
    }

    boolean isAlive(){
        if(health <= 0)
            isAlive = false;
            return isAlive;
    }
}

