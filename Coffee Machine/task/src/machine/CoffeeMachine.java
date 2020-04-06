package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static int WATER = 400;
    public static int MILK = 540;
    public static int BEANS = 120;
    public static int CUPS = 9;
    public static int MONEY = 550;
    public static void main(String[] args) {
        printCoffee();
    }
    public static void printCoffee() {
        System.out.println("\nWrite action (buy, fill, take, remaining, exit): ");

        Scanner sc = new Scanner(System.in);
        if(sc.hasNextLine()) doAction(sc.nextLine());
    }
    public static void initCoffee() {
        String str = String.format("The coffee machine has:\n" +
                "%d of water\n" +
                "%d of milk\n" +
                "%d of coffee beans\n" +
                "%d of disposable cups\n" +
                "$%d of money\n" , WATER, MILK, BEANS, CUPS, MONEY);
        System.out.println(str);
        printCoffee();
    }
    public static void doAction(String action) {
        Scanner sc = new Scanner(System.in);
        if(action.equals("buy")) {
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
            if(sc.hasNextInt()) buyCoffee(sc.nextInt());
            if(sc.hasNextLine() && sc.nextLine().equals("back")) printCoffee();
        }
        if(action.equals("fill")) {
            int water,milk,beans,cups;
            System.out.println("Write how many ml of water do you want to add:");
            water = sc.nextInt();
            System.out.println("Write how many ml of milk do you want to add: ");
            milk = sc.nextInt();
            System.out.println("Write how many grams of coffee beans do you want to add: ");
            beans = sc.nextInt();
            System.out.println("Write how many disposable cups of coffee do you want to add: ");
            cups = sc.nextInt();
            WATER += water;
            MILK += milk;
            BEANS += beans;
            CUPS += cups;
            printCoffee();
        }
        if(action.equals("take")) {
            System.out.println("I gave you $"+ MONEY);
            MONEY = 0;
            printCoffee();
        }
        if(action.equals("remaining")) initCoffee();
        if(action.equals("exit")) System.exit(0);
    }
    public static void buyCoffee(int val) {
        if(val == 1) {
            if(WATER < 250) System.out.println("Sorry, not enough water!");
            if(BEANS < 16) System.out.println("Sorry, not enough coffee beans!");
            if(BEANS > 16 && WATER > 250) {
                System.out.println("I have enough resources, making you a coffee!");
                WATER -= 250;
                BEANS -= 16;
                MONEY += 4;
                CUPS--;
            }
        }
        else if (val == 2) {
            if(WATER < 350) System.out.println("Sorry, not enough water!");
            if(BEANS < 20) System.out.println("Sorry, not enough coffee beans!");
            if(MILK < 75) System.out.println("Sorry, not enough milk!");
            if(BEANS > 20 && WATER > 350 && MILK > 75) {
                System.out.println("I have enough resources, making you a coffee!");
                WATER -= 350;
                MILK -= 75;
                BEANS -= 20;
                MONEY += 7;
                CUPS--;
            }
        }
        else if(val == 3) {
            if(WATER < 200) System.out.println("Sorry, not enough water!");
            if(BEANS < 12) System.out.println("Sorry, not enough coffee beans!");
            if(MILK < 100) System.out.println("Sorry, not enough milk!");
            if(BEANS > 12 && WATER > 200 && MILK > 100) {
                System.out.println("I have enough resources, making you a coffee!");
                WATER -= 200;
                MILK -= 100;
                BEANS -= 12;
                MONEY += 6;
                CUPS--;

            }
        }
        printCoffee();
    }
}