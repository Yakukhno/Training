package ua.training.models.ammunition;

public class Shield extends AbstractAmmunition {

    private ShieldMaterial material;
    private Shape shape;

    public enum ShieldMaterial {
        COPPER, STEAL, WOOD
    }

    public enum Shape {
        ROUND, OVAL, SQUARE
    }

    public Shield(int price, int weight, ShieldMaterial material, Shape shape) {
        super(price, weight);
        this.material = material;
        this.shape = shape;
    }

    public ShieldMaterial getMaterial() {
        return material;
    }

    public void setMaterial(ShieldMaterial material) {
        this.material = material;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}
