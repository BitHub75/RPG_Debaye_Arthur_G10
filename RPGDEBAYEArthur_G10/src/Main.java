import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Enemy> creation_enemies(int enemyNb, int enemy_hpMax, int enemy_strength) {
        ArrayList<Enemy> enemies = new ArrayList<Enemy>();
        for (int i = 0; i < enemyNb; i++) enemies.add(new Enemy(enemy_hpMax, enemy_strength));
        enemy_hpMax += 25;
        enemy_strength += 10;
        return enemies;
    }

    public static Enemy attack(String hero, Enemy enemy, Warrior warrior, Hunter hunter, Mage mage, Healer healer) {
        if (hero.equals("Warrior")) enemy = Warrior.attack(warrior, enemy);
        else if (hero.equals("Hunter")) {
            enemy = Hunter.attack(hunter, enemy);
            hunter.arrowNb--;
            System.out.println(" | arrowNb: " + hunter.arrowNb);
        }
        else if (hero.equals("Mage")) enemy = Mage.attack(mage, enemy);
        else enemy = Healer.attack(healer, enemy);
        return enemy;
    }

    public static ArrayList<String> hero_removal(ArrayList<String> heroes, Warrior warrior, Hunter hunter, Mage mage, Healer healer) {
        
        return heroes;
    }

    public static void main(String[] args) {
        // Hero Choice
        Scanner scanner = new Scanner(System.in);
          /*
        System.out.print("Choose your number of warrior: ");
        int warriorNb = scanner.nextInt();
        System.out.print("Choose your number of healer: ");
        int healerNb = scanner.nextInt();
        System.out.print("Choose your number of mage: ");
        int mageNb = scanner.nextInt();
        System.out.print("Choose your number of hunter: ");
        int hunterNb = scanner.nextInt();
          */
        boolean warriorBool = true;
        boolean hunterBool = true;
        boolean mageBool = true;
        boolean healerBool = true;

        Warrior warrior = new Warrior();
        Hunter hunter = new Hunter();
        Mage mage = new Mage();
        Healer healer = new Healer();

        // Error case

        // Initialize hero list
        ArrayList<String> heroes = new ArrayList<String>();
        if (warriorBool) heroes.add("Warrior");
        if (hunterBool) heroes.add("Hunter");
        if (mageBool) heroes.add("Mage");
        if (healerBool) heroes.add("Healer");

        // Heroes list print
        System.out.print("|  ");
        for (String hero : heroes) System.out.print(hero + "  |  ");
        System.out.println("");
        int enemyNb = heroes.size();

        // Rounds
        int round = 1;
        int enemy_hpMax = 100;
        int enemy_strength = 10;
        while (heroes.size() > 0 && round < 6) {
            // Enemies creation
            ArrayList<Enemy> enemies = creation_enemies(enemyNb, enemy_hpMax, enemy_strength);
            // Turns
            int pos_hero = 0;
            int pos_enemy = 0;
            while (heroes.size() > 0 && enemies.size() > 0) {
                // Hero reset
                String hero = heroes.get(pos_hero);
                Enemy enemy = enemies.get(pos_enemy);

                System.out.print(hero + "  |  (1) Attack  |  (2) Defend  |  (3) Consume  ");
                if (hero.equals("Healer")) System.out.print("|  (4) Heal  ");
                System.out.print(": ");
                int choice = scanner.nextInt();

                // Choices
                // Attack
                if (choice == 1) {
                    enemy = attack(hero, enemy, warrior, hunter, mage, healer);
                    if (enemy.hpNow <= 0) enemies.remove(pos_enemy);
                    if (enemies.size() == 0) System.out.println("No more enemies, you won round " + round + " !");
                }

                // Defend
                else if (choice == 2) {
                    if (hero.equals("Warrior")) warrior = Warrior.defend(warrior);
                    else if (hero.equals("Hunter")) hunter = Hunter.defend(hunter);
                    else if (hero.equals("Mage")) mage = Mage.defend(mage);
                    else healer = Healer.defend(healer);
                }

                // Consume
                else if (choice == 3) {
                    System.out.print("(1) Food / (2) Potion : ");
                    int consume_choice = scanner.nextInt();
                    if (consume_choice == 1) {
                        if (hero.equals("Warrior")) warrior = Warrior.eat(warrior);
                        else if (hero.equals("Hunter")) hunter = Hunter.eat(hunter);
                        else if (hero.equals("Mage")) mage = Mage.eat(mage);
                        else healer = Healer.eat(healer);
                    }
                    else if (consume_choice == 2) {
                        if (hero.equals("Healer")) healer = Healer.drink(healer);
                        else if (hero.equals("Mage")) mage = Mage.drink(mage);
                    }
                }

                // Heal
                else if (choice == 4) {
                    System.out.print("HEAL    |  (1) Warrior  |  (2) Hunter  |  (3) Mage  |  (4) Healer  : ");
                    int heal_choice = scanner.nextInt();
                    System.out.print("HEAL    | mana: " + healer.manaNow);
                    if (healer.manaNow - 20 > 0) healer.manaNow -= 20;
                    else System.out.println("Not enough mana !");
                    System.out.print(" | mana after: " + healer.manaNow + " | ");
                    
                    if (heal_choice == 1) {
                        System.out.print(" | hp: " + warrior.hpNow);
                        warrior.hpNow += 20;
                        if (warrior.hpNow > warrior.hpMax) warrior.hpNow = warrior.hpMax;
                        System.out.println(" | hp after: " + warrior.hpNow);
                    }
                    else if (heal_choice == 2) {
                        System.out.print(" | hp: " + hunter.hpNow);
                        hunter.hpNow += 20;
                        if (hunter.hpNow > hunter.hpMax) hunter.hpNow = hunter.hpMax;
                        System.out.println("hunter hp: " + hunter.hpNow);
                    }
                    else if (heal_choice == 3) {
                        System.out.print(" | hp: " + mage.hpNow);
                        mage.hpNow += 20;
                        if (mage.hpNow > mage.hpMax) mage.hpNow = mage.hpMax;
                        System.out.println("mage hp: " + mage.hpNow);
                    }
                    else if (heal_choice == 4) {
                        System.out.print(" | hp: " + healer.hpNow);
                        healer.hpNow += 20;
                        if (healer.hpNow > healer.hpMax) healer.hpNow = healer.hpMax;
                        System.out.println("healer hp: " + healer.hpNow);
                    }
                    else ;
                }

                // Enemy play
                // Attack
                if (enemies.size() > 0) { 
                    if (hero.equals("Warrior")) warrior = Warrior.attacked(warrior, enemy);
                    else if (hero.equals("Hunter")) hunter = Hunter.attacked(hunter, enemy);
                    else if (hero.equals("Mage")) mage = Mage.attacked(mage, enemy);
                    else healer = Healer.attacked(healer, enemy);
                    pos_enemy++;
                }

                // Hero removal
                int tmp_pos_hero = 0;
                for (String hero_tmp : heroes) {
                    if ((hero_tmp.equals("Warrior") && warrior.hpNow <= 0)
                    ||(hero_tmp.equals("Hunter") && hunter.hpNow <= 0)
                    ||(hero_tmp.equals("Mage") && mage.hpNow <= 0)
                    ||(hero_tmp.equals("Healer") && healer.hpNow <= 0)) {
                        heroes.remove(tmp_pos_hero);
                        tmp_pos_hero--;
                    }
                    tmp_pos_hero++;
                }

                if (heroes.size() == 0) System.out.println("No more heroes, you lost !");
                pos_hero++;

                if (pos_hero >= heroes.size()) pos_hero = 0;
                if (pos_enemy >= enemies.size()) pos_enemy = 0;
            }
        
            System.out.print("\n" + " (1) Armor up / (2) Attack up / (3) Consumable up : ");
            int choice = scanner.nextInt();
        
            // Boosts
            int armorUp = 0;
            int strengthUp = 0;
            int foodPotionUp = 0;
            if (choice == 1) armorUp += 20;
            else if (choice == 2) strengthUp += 10;
            else if (choice == 3) foodPotionUp += 1;
            // Function
            for (String hero_tmp : heroes) {
                if (hero_tmp.equals("Warrior")) {
                    warrior.armor += armorUp;
                    warrior.strength += strengthUp;
                    warrior.foodPotionNb += foodPotionUp;
                    warrior.foodNb = warrior.foodPotionNb;
                    warrior.potionNb = warrior.foodPotionNb;
                }
                else if (hero_tmp.equals("Hunter")) {
                    hunter.armor += armorUp;
                    hunter.strength += strengthUp;
                    hunter.foodPotionNb += foodPotionUp;
                    hunter.foodNb = hunter.foodPotionNb;
                    hunter.potionNb = hunter.foodPotionNb;
                }
                else if (hero_tmp.equals("Mage")) {
                    mage.armor += armorUp;
                    mage.strength += strengthUp;
                    mage.foodPotionNb += foodPotionUp;
                    mage.foodNb = mage.foodPotionNb;
                    mage.potionNb = mage.foodPotionNb;
                }
                else if (hero_tmp.equals("Healer")) {
                    healer.armor += armorUp;
                    healer.strength += strengthUp;
                    healer.foodPotionNb += foodPotionUp;
                    healer.foodNb = healer.foodPotionNb;
                    healer.potionNb = healer.foodPotionNb;
                }
            }
        
            System.out.println("Current round : " + round);

            // Enemy upgrade
            enemy_hpMax += 20;
            enemy_strength += 10;

            round++;
        }
        scanner.close();
    }
}