import java.util.Scanner;

public class World {
    Player player;
    Monster monster;
    Scanner sc;

    public World() {
        this.sc = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Введите имя персонажа: ");
        String name = sc.nextLine();
        this.player = new Player(name, 100, 15, 10, 1000, 0);
        System.out.println("Создан игрок: " + name);
        village();
    }

    void village() {
        while (true) {
            System.out.println("Мы находимся в деревне. " +
                    "\nВаши действия: " +
                    "\n1. Параметры персонажа" +
                    "\n2. Пойдти к торговцу" +
                    "\n3. Пойти в темный лес " +
                    "\n4. Выйти из игры");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> player.getInfo();
                case 2 -> merchant();
                case 3 -> darkForrest();
                case 4 -> {
                    System.out.println("Выход из игры");
                    return;
                }
                default -> System.out.println("Такого действия не существует");
            }
        }
    }
    void merchant() {
        Merchant merchant = new Merchant("Торговец", 100, 50, 50, 100000, 50);
        System.out.println("Мы в лавке торговца " +
                "\nВ кошельке " + player.getGold() +
                "\nЧто вы хотели купить у торговца?" +
                "\n1. +50 здоровья (50 золота) " +
                "\n2. +100 здоровья (100 золота)" +
                "\n3. Выйти из лавки");
        int merchChoice = sc.nextInt();
        switch (merchChoice) {
            case 1 -> merchant.sellHealth(player, 1);
            case 2 -> merchant.sellHealth(player, 2);
            case 3 -> village();
        }
    }

    void darkForrest() {
        int dice = (int)(Math.random()*2);
        if (dice > 0)
            monster = new Monster("Zombie");
        else
            monster = new Monster("Skelleton");
        System.out.println("В лесу вы встретили мостра: \n" +
                monster.getInfo() +
                "\nВаши действия: " +
                "\n1. Атаковать" +
                "\n2. Вернуться в деревню");
        int battleChoice = sc.nextInt();
        switch (battleChoice) {
            case 1 -> {
                Battle battle = new Battle();
                battle.startBattle(player, monster);
            }
            case 2 -> village();
        }
    }
}