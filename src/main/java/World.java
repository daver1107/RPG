import java.util.Scanner;

public class World {
    Player player;
    Monster monster;
    Scanner sc;
    Governor governor;
    Merchant merchant;

    public World() {
        this.sc = new Scanner(System.in);
        this.merchant = new Merchant("Торговец", 100, 50, 50, 100000, 50);
        this.governor = new Governor();

    }

    public void start() {
        System.out.println("Введите имя персонажа: ");
        String name = sc.nextLine();
        this.player = new Player(name, 100, 10, 10, 1000, 10);
        System.out.println("Создан игрок: " + name);
        village();
        System.exit(0);
    }

    private void village() {
        System.out.println("Мы находимся в деревне. " +
                "\nВаши действия: " +
                "\n1. Параметры персонажа" +
                "\n2. Пойти к торговцу" +
                "\n3. К Губернатору за наградой " +
                "\n4. Пойти в темный лес " +
                "\n5. Выйти из игры");

        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> {
                player.getInfo();
                village();
            }
            case 2 -> merchant();
            case 3 -> {
                System.out.println("Награда Губернатора: " +
                        "\n500 золотых за каждого скелета " +
                        "\n1000 золотых за каждого Зомби");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                governor.zombiesKilledReward(player);
                governor.skelletonKilledReward(player);
                village();
            }
            case 4 -> darkForrest();
            case 5 -> {
                System.out.println("Выход из игры");

            }
            default -> {
                System.out.println("Такого действия не существует");
                village();
            }
        }
    }

    private void merchant() {
        System.out.println("Мы в лавке торговца " +
                "\nВ кошельке " + player.getGold() +
                "\nЧто вы хотели купить у торговца?" +
                "\n1. Пополнить здоровье на 50 = 100 золота " +
                "\n2. Пополнить здоровье 100 = 200 золота" +
                "\n3. Купить лекарство на 50 единиц с собой = 200 золота" +
                "\n4. Купить лекарство на 100 единиц с собой = 300 золота" +
                "\n5. Выйти из лавки");

        int merchChoice = sc.nextInt();
        switch (merchChoice) {
            case 1 -> {
                merchant.heal(player, 1);
                merchant();
            }
            case 2 -> {
                merchant.heal(player, 2);
                merchant();
            }
            case 3 -> {
                player.buyMeds(200, "Health 50");
                merchant();
            }
            case 4 -> {
                player.buyMeds(300, "Health 100");
                merchant();
            }
            case 5 -> village();
            default -> {
                System.out.println("Такого действия не существует");
                merchant();
            }
        }
    }

    private void darkForrest() {
        //Из леса по результату лотореи выходит рандомный монстр
        int dice = (int) (Math.random() * 2);
        if (dice > 0)
            monster = new Zombie();
        else
            monster = new Skeleton();
        System.out.println("В лесу вы встретили мостра: \n" +
                monster.getInfo() +
                "\nВаши действия: " +
                "\n1. Атаковать" +
                "\n2. Вернуться в деревню");
        int battleChoice = sc.nextInt();
        switch (battleChoice) {
            case 1 -> {
                while (player.isAlive()) {
                    Battle battle = new Battle(player, monster);
                    battle.startBattle();
                    if (player.isAlive())
                        darkForrest();
                    else
                        System.out.println("Игрок уничтожен. \nGame over");
                }
            }
            case 2 -> village();
            default -> {
                System.out.println("Такого действия не существует");
                darkForrest();
            }
        }

    }
    private void exitGame(){
        System.out.println("Exiting");
    }
}