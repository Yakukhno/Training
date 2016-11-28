package ua.training.model.ammunition;

import ua.training.model.product.AbstractProduct;

/**
 * Implementation of <tt>AbstractProduct</tt> abstract class.
 * Describes chain armor.
 */
public class ChainArmor extends AbstractProduct {

    /**
     * Material of chain armor.
     */
    private ChainArmorMaterial material;

    /**
     * Constructor of chain armor with price, weight, material params.
     * @param price int value of price of chain armor
     * @param weight int value of weight of chain armor
     * @param material ChainArmorMaterial value of material of chain armor
     */
    public ChainArmor(int price, int weight, ChainArmorMaterial material) {
        super(price, weight);
        this.material = material;
    }

    //getters & setters

    public ChainArmorMaterial getMaterial() {
        return material;
    }

    public void setMaterial(ChainArmorMaterial material) {
        this.material = material;
    }

    /**
     * Enumeration of chain armor materials.
     */
    public enum ChainArmorMaterial {
        ALUMINUM(1), COPPER(2), STEAL(3), LEATHER(4);

        private int index;

        ChainArmorMaterial(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }

}
