public class Warrior extends Hero {
    public Warrior() {
        super(200, "warrior", 20, 30);
    }

    public static Enemy attack(Warrior warrior, Enemy enemy) {
        System.out.print("ATTACK  | strength: " + warrior.strength + " | hp: " + enemy.hpNow);
        enemy.hpNow -= warrior.strength;
        System.out.println(" | hp: " + enemy.hpNow);
        return enemy;
    }

    public static Warrior defend(Warrior warrior) {
        System.out.println("DEFEND  | armor: " + warrior.armor);
        warrior.defense = true;
        return warrior;
    }

    public static Warrior eat(Warrior warrior) {
        if (warrior.foodNb == 0) {
            System.out.println("Not enough food");
            return warrior;
        }
        warrior.hpNow += 30;
        warrior.foodNb--;
        if (warrior.hpNow > warrior.hpMax) warrior.hpNow = warrior.hpMax;
        return warrior;
    }

    public static Warrior attacked(Warrior warrior, Enemy enemy) {
        int damage = enemy.getStrength();
        if (warrior.defense) damage -= warrior.armor;
        if (damage < 0) damage = 0;
        System.out.print("ENEMY   | strength: " + enemy.strength + " | hp: " + warrior.hpNow);
        warrior.hpNow -= damage;
        System.out.println(" | hp: " + warrior.hpNow);
        return warrior;
    }
}
