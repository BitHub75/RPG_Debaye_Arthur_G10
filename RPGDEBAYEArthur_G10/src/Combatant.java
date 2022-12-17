public class Combatant {
    public int hpMax;
    public int hpNow;
    public int armor;
    public int strength;

    public Combatant(int hpMax, int armor, int strength) {
        this.hpMax = hpMax;
        this.hpNow = hpMax;
        this.armor = armor;
        this.strength = strength;
    }

    public int getStrength() { return strength; }
    public void setStrength(int strength) { this.strength = strength; }
    public int getHpMax() { return hpMax; }
    public void setHpMax(int hpMax) { this.hpMax = hpMax; }
    public int getHpNow() { return hpNow; }
    public void setHpNow(int hpNow) { this.hpNow = hpNow; }
    public int getArmor() { return armor; }
    public void setArmor(int armor) { this.armor = armor; }
}
