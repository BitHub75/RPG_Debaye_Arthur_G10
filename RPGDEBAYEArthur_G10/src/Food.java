public class Food extends Consumable {
    private int foodHeal;

    //foodNbMax = 5 en début de partie
    public Food(int itemId){
        super(itemId);
        this.foodHeal = 30;
    }
    /*
    public Hero Eat(Hero hero) {
        if (foodNb == 0) return hero;
        int hpNow = hero.getHpNow();
        int hpMax = hero.getHpMax();
        hpNow += foodHeal;
        if (hpNow > hpMax) hero.setHpNow(hpMax);
        return hero;
    }

 */
}
