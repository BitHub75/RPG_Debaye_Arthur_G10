public class SpellCaster extends Hero {
    public int manaMax;
    public int manaNow;
    public int potionNb;

    public SpellCaster(int hpMax, String classId, int armor, int strength) {
        super(hpMax, classId, armor, strength);
        this.potionNb = 5;
        this.manaMax = 100;
        this.manaNow = 100;
    }
/*
    public static SpellCaster defend(SpellCaster spellCaster) {
        System.out.println("DEFEND | armor: " + spellCaster.armor);
        spellCaster.defense = true;
        return spellCaster;
    }
*/
    public int getManaMax() { return manaMax; }
    public void setManaMax(int manaMax) { this.manaMax = manaMax; }
    public int getManaNow() { return manaNow; }
    public void setManaNow(int manaNow) { this.manaNow = manaNow; }
}
