package ua.training.models.ammunition;

public class ChainArmor extends AbstractAmmunition {

    private String material;

    public ChainArmor(int price, int weight, String material) {
        super(price, weight);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

}
