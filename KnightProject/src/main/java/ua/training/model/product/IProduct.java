package ua.training.model.product;

/**
 * Interface describes behaviour of some entity,
 * which operate with price and weight.
 *
 * @author Ivan Yakuknno
 * @see AbstractProduct
 */
public interface IProduct {

    /**
     * Returns price.
     * @return price
     */
    int getPrice();

    /**
     * Sets price.
     * @param price int value of price to set
     */
    void setPrice(int price);

    /**
     * Returns weight.
     * @return weight
     */
    int getWeight();

    /**
     * Sets price.
     * @param weight int value of weight to set
     */
    void setWeight(int weight);

}
