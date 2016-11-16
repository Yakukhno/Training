package ua.training.database;

public enum Price {

    ALUMINUM_CHAIN_ARMOR(120, 4), COPPER_CHAIN_ARMOR(150, 7),
    STEAL_CHAIN_ARMOR(200, 10), LEATHER_CHAIN_ARMOR(70, 2),
    PROTECTED_HELMET(30, 2), UNPROTECTED_HELMET(10, 1),
    SWORD(240, 3), SPEAR(90, 1), CROSSBOW(80, 1), MACE(120, 2),
    ROUND_SHIELD(4, 0), OVAL_SHIELD(4, 0), SQUARE_SHIELD(7, 0),
    COPPER_SHIELD(25, 2), STEAL_SHIELD(40, 3), WOOD_SHIELD(15, 1);
    
    private int price;
    private int weight;

    Price(int price, int weight) {
        this.price = price;
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }
}
