public class Hunter extends Hero {
    protected int arrowNb;

    public Hunter() {
        super(160, "hunter", 10, 20);
        this.arrowNb = 10;
    }

    public static Enemy attack(Hunter hunter, Enemy enemy) {
        System.out.print("ATTACK  | strength: " + hunter.strength + " | hp: " + enemy.hpNow);
        if (hunter.arrowNb <= 0) System.out.print("Not enough arrows !");
        else enemy.hpNow -= hunter.strength;
        System.out.print(" | hp: " + enemy.hpNow);
        return enemy;
    }

    public static Hunter defend(Hunter hunter) {
        System.out.println("DEFEND  | armor: " + hunter.armor);
        hunter.defense = true;
        return hunter;
    }

    public static Hunter eat(Hunter hunter) {
        if (hunter.foodNb == 0) {
            System.out.println("Not enough food");
            return hunter;
        }
        hunter.hpNow += 30;
        hunter.foodNb--;
        if (hunter.hpNow > hunter.hpMax) hunter.hpNow = hunter.hpMax;
        return hunter;
    }

    public static Hunter attacked(Hunter hunter, Enemy enemy) {
        int damage = enemy.getStrength();
        if (hunter.defense) damage -= hunter.armor;
        if (damage < 0) damage = 0;
        System.out.print("ENEMY   | strength: " + enemy.strength + " | hp: " + hunter.hpNow);
        hunter.hpNow -= damage;
        System.out.println(" | hp: " + hunter.hpNow);
        return hunter;
    }
}