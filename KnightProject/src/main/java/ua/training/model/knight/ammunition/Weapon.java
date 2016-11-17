package ua.training.model.knight.ammunition;

public class Weapon extends AbstractAmmunition {

    private WeaponType type;

    public enum WeaponType {
        SWORD, SPEAR, CROSSBOW, MACE
    }

    public Weapon(int price, int weight, WeaponType type) {
        super(price, weight);
        this.type = type;
    }

    public WeaponType getDamage() {
        return type;
    }

    public void setDamage(WeaponType damage) {
        this.type = damage;
    }
}
