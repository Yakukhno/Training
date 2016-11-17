package ua.training.model.knight.ammunition;

public class ChainArmor extends AbstractAmmunition {

    private ChainArmorMaterial material;

    public enum ChainArmorMaterial {
        ALUMINUM, COPPER, STEAL, LEATHER
    }

    public ChainArmor(int price, int weight, ChainArmorMaterial material) {
        super(price, weight);
        this.material = material;
    }

    public ChainArmorMaterial getMaterial() {
        return material;
    }

    public void setMaterial(ChainArmorMaterial material) {
        this.material = material;
    }

}
