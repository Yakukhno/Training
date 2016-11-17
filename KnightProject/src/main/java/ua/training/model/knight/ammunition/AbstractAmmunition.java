package ua.training.model.knight.ammunition;

public abstract class AbstractAmmunition implements IAmmunition {

    protected int price;
    protected int weight;

    protected AbstractAmmunition(int price, int weight) {
        this.price = price;
        this.weight = weight;
    }

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
