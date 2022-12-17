public class Healer extends SpellCaster {
    public Healer() { super(100, "healer", 10, 10); }

    public static Enemy attack(Healer healer, Enemy enemy) {
        System.out.print("ATTACK  | strength: " + healer.strength + " | hp: " + enemy.hpNow);
        enemy.hpNow -= healer.strength;
        System.out.println(" | hp: " + enemy.hpNow);
        return enemy;
    }
    
    public static Healer defend(Healer healer) {
        System.out.println("DEFEND  | armor: " + healer.armor);
        healer.defense = true;
        return healer;
    }

    public static Healer eat(Healer healer) {
        if (healer.foodNb == 0) {
            System.out.println("Not enough food");
            return healer;
        }
        healer.hpNow += 30;
        healer.foodNb--;
        if (healer.hpNow > healer.hpMax) healer.hpNow = healer.hpMax;
        return healer;
    }

    public static Healer drink(Healer healer) {
        if (healer.potionNb == 0) {
            System.out.println("Not enough potion");
            return healer;
        }
        System.out.print("DRINK   | mana: " + healer.manaNow);
        healer.manaNow += 30;
        System.out.println(" | mana after: " + healer.manaNow + " | potion nb: " + healer.potionNb);
        if (healer.manaNow > healer.manaMax) healer.manaNow = healer.manaMax;
        healer.potionNb--;
        return healer;
    }

    public static Healer attacked(Healer healer, Enemy enemy) {
        int damage = enemy.getStrength();
        if (healer.defense) damage -= healer.armor;
        if (damage < 0) damage = 0;
        System.out.print("ENEMY   | strength: " + enemy.strength + " | hp: " + healer.hpNow);
        healer.hpNow -= damage;
        System.out.println(" | hp: " + healer.hpNow);
        return healer;
    }
}


