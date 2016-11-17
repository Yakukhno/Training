package ua.training.model.knight.ammunition;


/**
 * This class provides a skeletal implementation of the {@link IAmmunition}
 * interface to minimize the effort required to implement this interface.
 *
 * @see IAmmunition
 * @author Ivan Yakukhno
 */
public abstract class AbstractAmmunition implements IAmmunition {

    /**
     * Price of ammunition.
     */
    protected int price;

    /**
     * Weight of ammunition.
     */
    protected int weight;

    /**
     * Constructor, which receive price and weight.
     * @param price int value of price of a ammunition
     * @param weight int value of weight of a ammunition
     */
    protected AbstractAmmunition(int price, int weight) {
        this.price = price;
        this.weight = weight;
    }

    //getters & setters

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "( price=" + price +
                ", weight=" + weight +
                " )";
    }
}
