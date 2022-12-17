public class Weapon extends Item{

    private String weaponName;
    private int weaponStrength;

    public Weapon(int itemId, String weaponName, int weaponStrength) {
        super(itemId);
        this.weaponName = weaponName;
        this.weaponStrength = weaponStrength;
    }
}
