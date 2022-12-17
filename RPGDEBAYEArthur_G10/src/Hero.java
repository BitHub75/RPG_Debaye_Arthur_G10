public class Hero extends Combatant {
    protected int foodNb;
    protected int potionNb;
    protected int foodPotionNb;
    protected boolean defense;

    public Hero(int hpMax, String classId, int armor, int strength) {
        super(hpMax, armor, strength);
        this.foodNb = 5;
        this.potionNb = 5;
        this.foodPotionNb = 5;
        this.defense = false;
    }
}
