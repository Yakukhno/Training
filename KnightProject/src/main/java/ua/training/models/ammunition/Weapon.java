package ua.training.models.ammunition;

public class Weapon extends AbstractAmmunition {

    private int damage;

    public Weapon(int price, int weight) {
        super(price, weight);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
