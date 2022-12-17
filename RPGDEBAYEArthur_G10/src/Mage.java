public class Mage extends SpellCaster {
    public Mage() {
        super(130, "mage", 10, 40);
    }

    public static Enemy attack(Mage mage, Enemy enemy) {
        System.out.print("ATTACK  | mana: " + mage.manaNow);
        if (mage.manaNow <= 0) {
            System.out.print(" | No more mana !");
            return enemy;
        }
        else mage.manaNow -= 20;
        System.out.print(" | mana after: " + mage.manaNow + " | strength: " + mage.strength + " | hp: " + enemy.hpNow);
        enemy.hpNow -= mage.strength;
        System.out.println(" | hp after: " + enemy.hpNow);
        return enemy;
    }

    
    public static Mage defend(Mage mage) {
        System.out.println("DEFEND  | armor: " + mage.armor);
        mage.defense = true;
        return mage;
    }
    
    public static Mage eat(Mage mage) {
        if (mage.foodNb == 0) {
            System.out.println("Not enough food");
            return mage;
        }
        mage.hpNow += 30;
        mage.foodNb--;
        if (mage.hpNow > mage.hpMax) mage.hpNow = mage.hpMax;
        return mage;
    }

    public static Mage drink(Mage mage) {
        if (mage.potionNb == 0) {
            System.out.println("Not enough potion");
            return mage;
        }
        System.out.print("DRINK   | mana: " + mage.manaNow);
        mage.manaNow += 30;
        if (mage.manaNow > mage.manaMax) mage.manaNow = mage.manaMax;
        mage.potionNb--;
        System.out.println(" | mana after: " + mage.manaNow + " | potion nb: " + mage.potionNb);
        return mage;
    }

    public static Mage attacked(Mage mage, Enemy enemy) {
        int damage = enemy.getStrength();
        if (mage.defense) damage -= mage.armor;
        if (damage < 0) damage = 0;
        System.out.print("ENEMY   | strength: " + enemy.strength + " | hp: " + mage.hpNow);
        mage.hpNow -= damage;
        System.out.println(" | hp: " + mage.hpNow);
        return mage;
    }
}
