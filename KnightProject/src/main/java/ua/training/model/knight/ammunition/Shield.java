package ua.training.model.knight.ammunition;

/**
 * Implementation of <tt>AbstractAmmunition</tt> abstract class.
 * Describes shield.
 */
public class Shield extends AbstractAmmunition {

    /**
     * Material of shield.
     */
    private ShieldMaterial material;

    /**
     * Shape of shield.
     */
    private Shape shape;

    /**
     * Enumeration of shield materials.
     */
    public enum ShieldMaterial {
        COPPER, STEAL, WOOD
    }

    /**
     * Enumeration of shield shape.
     */
    public enum Shape {
        ROUND, OVAL, SQUARE
    }

    /**
     * Constructor of shield with price, weight, material, shape params.
     * @param price int value of price of shield
     * @param weight int value of weight of shield
     * @param material ShieldMaterial value of material of shield
     * @param shape Shape value of material of shield
     */
    public Shield(int price, int weight, ShieldMaterial material, Shape shape) {
        super(price, weight);
        this.material = material;
        this.shape = shape;
    }

    //getters & setters

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
