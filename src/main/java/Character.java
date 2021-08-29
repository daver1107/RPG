public abstract class Character {

    private String name;
    private double health;
    private int skill;
    private double strength;
    private int gold;
    private int experience;
    boolean isAlive = true;

    public void setHealth(double health) {
        this.health = health;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Character(String name, double health, int skill, double strength, int gold, int experience) {
        this.name = name;
        this.health = health;
        this.skill = skill;
        this.strength = strength;
        this.gold = gold;
        this.experience = experience;
    }
    public Character(String name, int health, int skill, int strength,int experience) {
        this.name = name;
        this.health = health;
        this.skill = skill;
        this.strength = strength;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public int getSkill() {
        return skill;
    }

    public double getStrength() {
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

