import java.util.Scanner;
/**
 * Write a description of class Game here.
 * 
 * @author Tyler Garrett 
 * @version 5/28/2014
 */
public class Game
{
    public String name;
    public Game() {
        int[] cha = new int[7];
        cha[0] = 0;     //Gold
        cha[1] = 1;     //Floor
        cha[2] = 0;     //Battles won on current floor
        cha[3] = 10;    //Strength
        cha[4] = 10;    //Dexterity
        cha[5] = 100;   //Endurance
        cha[6] = 100;   //Max Health

        Item[] equip = new Item[6];
        Armor helmet = new Armor();
        Armor chest = new Armor();
        Armor shoulders = new Armor();
        Armor hands = new Armor();
        Armor bottoms = new Armor();
        Weapon weapon = new Weapon();

        equip[0] = helmet;   //Helmet
        equip[1] = chest;   //Chest
        equip[2] = shoulders;   //Shoulders
        equip[3] = hands;   //Hands
        equip[4] = bottoms;   //Bottoms
        equip[5] = weapon;   //Weapon
        for (int i = 0; i < 6; i++) {
            equip[i].setLvl(1);
        }
        
        Scanner sc = new Scanner(System.in);
        System.out.println("The Text Adventure");
        sc.nextLine();
        System.out.println("What is your name?");
        name = sc.nextLine();
        if (name.equals("Lancelot")) {
            System.out.println("Let us not go to Camelot, tis a silly place.");
            equip[5].setLvl(90);
        }
        if (name.equals("Vegeta")) {
            System.out.println("IT'S OVER 9000!!!");
            equip[5].setLvl(901);
        }
        if (name.equals("Stark")) {
            System.out.println("Winter is coming...");
            equip[0].setLvl(30);
        }
        if (name.equals("Lannister")) {
            System.out.println("A Lannister always pays his debts.");
            cha[0] = 999999999;
        }
        System.out.println(name + " you say? Strange name if you ask me.");
        System.out.println("That doesn't mattter now. You've been tasked with clearing out a tower of monsters.");
        System.out.println("Win five rounds on each of the three floors to get to the boss on the fourth floor.");
        System.out.println("Return to town inbetween battles to sell items and buy gear");
        System.out.println("I wish you luck adventurer");
        town(cha, equip);
    }

    public void town(int[] z, Item[] a) {
        z[3] = a[5].getLvl() * 10;
        z[6] = (a[0].getLvl() * 20) + (a[1].getLvl() * 20) + (a[2].getLvl() * 20) + (a[3].getLvl() * 20) + (a[4].getLvl() * 20);
        System.out.println("You are now in town. What would you like to do?");
        System.out.println("(b)Buy      (s)Sell");
        System.out.println("(h)Heal     (c)Continue");
        System.out.println("(q)Quit");
        Scanner sc = new Scanner(System.in);
        String b = sc.next();
        if (b.equals("b")) {
            buy(z, a);
        }
        else if (b.equals("s")) {
            sell(z, a);
        }
        else if (b.equals("h")) {
            System.out.println("You have been healed to " + z[6] + " health.");
            z[5] = z[6];
            town(z, a);
        }
        else if (b.equals("c")) {
            first(z, a);
        }
        else if (b.equals("q")) {
            exit();
        }
        else {
            System.out.println("That's not an option.");
            town(z, a);
        }
    }

    public void buy(int[] z, Item[] a) {
        System.out.println("What would you like?");
        System.out.println("(h)Helmet       (ch)Chest");
        System.out.println("(s)Shoulders    (ha)Hands");
        System.out.println("(b)Bottoms      (w)Weapons");
        System.out.println("or (q)Quit");
        Scanner sc = new Scanner(System.in);
        String b = sc.next();
        if (b.equals("h")) {
            if (a[0].getLvl() > 10) {
                System.out.println("You cannot upgrade this any further.");
                buy(z, a);
            }
            else if (z[0] >= (100 + (10 * z[1]))) {
                a[0].setLvl(a[0].getLvl() + 1);
                z[0] = z[0] - (100 + (10 * a[0].getLvl()));
                buy(z, a);
            }
            else {
                System.out.println("You don't have enough gold for that.");
                buy(z, a);
            }
        }
        else if (b.equals("ch")) {
            if (a[1].getLvl() > 10) {
                System.out.println("You cannot upgrade this any further.");
                buy(z, a);
            }
            else if (z[0] >= (100 + (10 * z[1]))) {
                a[1].setLvl(a[1].getLvl() + 1);
                z[0] = z[0] - (100 + (10 * a[1].getLvl()));
                buy(z, a);
            }
            else {
                System.out.println("You don't have enough gold for that.");
                buy(z, a);
            }
        }
        else if (b.equals("s")) {
            if (a[2].getLvl() > 10) {
                System.out.println("You cannot upgrade this any further.");
                buy(z, a);
            }
            else if (z[0] >= (100 + (10 * z[1]))) {
                a[2].setLvl(a[2].getLvl() + 1);
                z[0] = z[0] - (100 + (10 * a[2].getLvl()));
                buy(z, a);
            }
            else {
                System.out.println("You don't have enough gold for that.");
                buy(z, a);
            }
        }
        else if (b.equals("ha")) {
            if (a[3].getLvl() > 10) {
                System.out.println("You cannot upgrade this any further.");
                buy(z, a);
            }
            else if (z[0] >= (100 + (10 * z[1]))) {
                a[3].setLvl(a[3].getLvl() + 1);
                z[0] = z[0] - (100 + (10 * a[3].getLvl()));
                buy(z, a);
            }
            else {
                System.out.println("You don't have enough gold for that.");
                buy(z, a);
            }
        }
        else if (b.equals("b")) {
            if (a[4].getLvl() > 10) {
                System.out.println("You cannot upgrade this any further.");
                buy(z, a);
            }
            else if (z[0] >= (100 + (10 * z[1]))) {
                a[4].setLvl(a[4].getLvl() + 1);
                z[0] = z[0] - (100 + (10 * a[4].getLvl()));
                buy(z, a);
            }
            else {
                System.out.println("You don't have enough gold for that.");
                buy(z, a);
            }
        }
        else if (b.equals("w")) {
            if (a[5].getLvl() > 10) {
                System.out.println("You cannot upgrade this any further.");
                buy(z, a);
            }
            else if (z[0] >= (100 + (10 * z[1]))) {
                a[5].setLvl(a[5].getLvl() + 1);
                z[0] = z[0] - (100 + (10 * a[5].getLvl()));
                buy(z, a);
            }
            else {
                System.out.println("You don't have enough gold for that.");
                buy(z, a);
            }
        }
        else if (b.equals("q")) {
            town(z, a);
        }
        else {
            System.out.println("That's not an option.");
            buy(z, a);
        }
    }

    public void sell(int[] z, Item[] a) {
        System.out.println("What would you like to sell?");
        System.out.println("(h)Helmet       (ch)Chest");
        System.out.println("(s)Shoulders    (ha)Hands");
        System.out.println("(b)Bottoms      (w)Weapons");
        System.out.println("or (q)Quit");
        Scanner sc = new Scanner(System.in);
        String b = sc.next();
        if (b.equals("h")) {
            if (a[0].getLvl() > 0) {
                a[0].setLvl(a[0].getLvl() - 1);
                z[0] = z[0] + (100 + (10 * a[0].getLvl()));
                sell(z, a);
            }
            else {
                System.out.println("You can't downgrade any further!");
                sell(z, a);
            }
        }
        else if (b.equals("ch")) {
            if (a[1].getLvl() > 0) {
                a[1].setLvl(a[1].getLvl() - 1);
                z[0] = z[0] + (100 + (10 * a[1].getLvl()));
                sell(z, a);
            }
            else {
                System.out.println("You can't downgrade any further!");
                sell(z, a);
            }
        }
        else if (b.equals("s")) {
            if (a[2].getLvl() > 0) {
                a[2].setLvl(a[2].getLvl() - 1);
                z[0] = z[0] + (100 + (10 * a[2].getLvl()));
                sell(z, a);
            }
            else {
                System.out.println("You can't downgrade any further!");
                sell(z, a);
            }
        }
        else if (b.equals("ha")) {
            if (a[3].getLvl() > 0) {
                a[3].setLvl(a[3].getLvl() - 1);
                z[0] = z[0] + (100 + (10 * a[3].getLvl()));
                sell(z, a);
            }
            else {
                System.out.println("You can't downgrade any further!");
                sell(z, a);
            }
        }
        else if (b.equals("b")) {
            if (a[4].getLvl() > 0) {
                a[4].setLvl(a[4].getLvl() - 1);
                z[0] = z[0] + (100 + (10 * a[4].getLvl()));
                sell(z, a);
            }
            else {
                System.out.println("You can't downgrade any further!");
                sell(z, a);
            }
        }
        else if (b.equals("w")) {
            if (a[5].getLvl() > 0) {
                a[5].setLvl(a[5].getLvl() - 1);
                z[0] = z[0] + (100 + (10 * a[5].getLvl()));
                sell(z, a);
            }
            else {
                System.out.println("You can't downgrade any further!");
                sell(z, a);
            }
        }
        else if (b.equals("q")) {
            town(z, a);
        }
        else {
            System.out.println("That's not an option.");
            sell(z, a);
        }
    }

    public void encounter(int[] z, int[] a, Item[] y) {
        int dmg = 0;
        int edmg = a[0];
        System.out.println("Fight!");
        while (a[1] > 0 && z[5] > 0) {
            dmg = z[3] + (int)(1 + Math.random() * 10);
            System.out.println("You did " + dmg + " points of damage.");
            a[1] = a[1] - dmg;
            System.out.println("You took " + edmg + " points of damage.");
            System.out.println("You now have " + (z[5] - edmg) + " HP left.");
            z[5] = z[5] - edmg;
        }
        if (z[5] > 0) {
            System.out.println("You won!");
            System.out.println("You recieved " + (50 * z[1]) + " gold!");
            z[0] = z[0] + (50 * z[1]);
        }
        else if (z[5] <= 0) {
            System.out.println("You lost the fight and have been returned to town!");
            z[2]--;
            town(z, y);
        }
    }

    public void first(int[] z, Item[] a) {
        if (z[1] > 1) {
            second(z, a);
        }
        while (z[2] < 5) {
            int x = (int)(1 + Math.random() * 3);
            int[] b = new int[2];
            if (x == 3) {
                System.out.println("You've encountered a Goblin!");
                b[0] = 6;
                b[1] = 25;
                encounter(z, b, a); 
                z[2]++;
            }
            else if (x == 2) {
                System.out.println("You've encountered a Bandit!");
                b[0] = 10;
                b[1] = 20;
                encounter(z, b, a);
                z[2]++;
            }
            else if (x == 1) {
                System.out.println("You've encountered a Cyclops!");
                b[0] = 10;
                b[1] = 30;
                encounter(z, b, a);
                z[2]++;
            }
            System.out.println("(t)town or (c)continue?");
            Scanner sc = new Scanner(System.in);
            String c = sc.next();
            if (c.equals("t")) {
                town(z, a);
            }
            else if (c.equals("c")) {
                first(z, a);
            }
            else {
                System.out.println("You didnt follow directions so you're getting in a fight!");
                first(z, a);
            }
        }
        if (z[2] == 5) {
            z[1]++;
            z[2] = 0;
        }
    }

    public void second(int[] z, Item[] a) {
        if (z[1] > 2) {
            third(z, a);
        }
        while (z[2] < 5) {
            int x = (int)(1 + Math.random() * 3);
            int[] b = new int[2];
            if (x == 3) {
                System.out.println("You've encountered a Super Goblin!");
                b[0] = 12;
                b[1] = 50;
                encounter(z, b, a); 
                z[2]++;
            }
            else if (x == 2) {
                System.out.println("You've encountered a Super Bandit!");
                b[0] = 20;
                b[1] = 40;
                encounter(z, b, a);
                z[2]++;
            }
            else if (x == 1) {
                System.out.println("You've encountered a Super Cyclops!");
                b[0] = 20;
                b[1] = 60;
                encounter(z, b, a);
                z[2]++;
            }
            System.out.println("(t)town or (c)continue?");
            Scanner sc = new Scanner(System.in);
            String c = sc.next();
            if (c.equals("t")) {
                town(z, a);
            }
            else if (c.equals("c")) {
                second(z, a);
            }
            else {
                System.out.println("You didnt follow directions so you're getting in a fight!");
                second(z, a);
            }
        }
        if (z[2] == 5) {
            z[1]++;
            z[2] = 0;
        }
    }

    public void third(int[] z, Item[] a) {
        if (z[1] > 3) {
            boss(z, a);
        }
        while (z[2] < 5) {
            int x = (int)(1 + Math.random() * 3);
            int[] b = new int[2];
            if (x == 3) {
                System.out.println("You've encountered a Uber Goblin!");
                b[0] = 18;
                b[1] = 75;
                encounter(z, b, a); 
                z[2]++;
            }
            else if (x == 2) {
                System.out.println("You've encountered a Uber Bandit!");
                b[0] = 30;
                b[1] = 60;
                encounter(z, b, a);
                z[2]++;
            }
            else if (x == 1) {
                System.out.println("You've encountered a Uber Cyclops!");
                b[0] = 30;
                b[1] = 90;
                encounter(z, b, a);
                z[2]++;
            }
            System.out.println("(t)town or (c)continue?");
            Scanner sc = new Scanner(System.in);
            String c = sc.next();
            if (c.equals("t")) {
                town(z, a);
            }
            else if (c.equals("c")) {
                third(z, a);
            }
            else {
                System.out.println("You didnt follow directions so you're getting in a fight!");
                third(z, a);
            }
        }
        if (z[2] == 5) {
            z[1]++;
            z[2] = 0;
        }
    }

    public void boss(int[] z, Item[] a) {
        int[] b = new int[2];
        System.out.println("HAHAHA. You've made it this far " + name + ", but now you face me BBEG, the Big Bad Evil guy.");
        b[0] = 200;
        b[1] = 1000;
        z[1] = 0;
        z[2] = 0;
        encounter(z, b, a);
        System.out.println("You beat BBEG!! Congratulations! You get to continue and kill monsters as you please!");
        town(z, a);
    }
    
    public void exit() {
        System.out.println("Bye!");
        ;
    }
}   