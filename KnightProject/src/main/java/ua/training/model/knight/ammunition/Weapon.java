package ua.training.model.knight.ammunition;

/**
 * Implementation of <tt>AbstractAmmunition</tt> abstract class.
 * Describes weapon.
 */
public class Weapon extends AbstractAmmunition {

    /**
     * Weapon type.
     */
    private WeaponType type;

    /**
     * Enumeration of weapon type.
     */
    public enum WeaponType {
        SWORD, SPEAR, CROSSBOW, MACE
    }

    /**
     * Constructor of weapon with price, weight, type params.
     * @param price int value of price of weapon
     * @param weight int value of weight of weapon
     * @param type WeaponType value of weapon type
     */
    public Weapon(int price, int weight, WeaponType type) {
        super(price, weight);
        this.type = type;
    }

    //getters & setters

    public WeaponType getType() {
        return type;
    }

    public void setType(WeaponType damage) {
        this.type = damage;
    }
}
