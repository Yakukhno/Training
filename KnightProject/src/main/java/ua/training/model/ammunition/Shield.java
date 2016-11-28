package ua.training.model.ammunition;

import ua.training.model.product.AbstractProduct;

/**
 * Implementation of <tt>AbstractProduct</tt> abstract class.
 * Describes shield.
 */
public class Shield extends AbstractProduct {

    /**
     * Material of shield.
     */
    private ShieldMaterial material;

    /**
     * Shape of shield.
     */
    private Shape shape;

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

    /**
     * Enumeration of shield materials.
     */
    public enum ShieldMaterial {
        COPPER(1), STEAL(2), WOOD(3);

        private int index;

        ShieldMaterial(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }

    /**
     * Enumeration of shield shape.
     */
    public enum Shape {
        ROUND(1), OVAL(2), SQUARE(3);

        private int index;

        Shape(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }
}
