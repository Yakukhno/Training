package ua.training.models.ammunition;

public class Shield extends AbstractAmmunition {

    private String material;
    private Shape shape;

    public enum Shape {
        ROUND, OVAL, SQUARE
    }

    public Shield(int price, int weight, String material, Shape shape) {
        super(price, weight);
        this.material = material;
        this.shape = shape;
    }
}
