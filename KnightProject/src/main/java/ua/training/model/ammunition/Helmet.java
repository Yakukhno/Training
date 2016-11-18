package ua.training.model.ammunition;

import ua.training.model.product.AbstractProduct;

/**
 * Implementation of <tt>AbstractProduct</tt> abstract class.
 * Describes helmet.
 */
public class Helmet extends AbstractProduct {

    /**
     * Boolean value whether is protected helmet or not.
     */
    private boolean isProtectedFace;

    /**
     * Constructor of helmet with price, weight, isProtectedFace params.
     * @param price int value of price of helmet
     * @param weight int value of weight of helmet
     * @param isProtectedFace boolean value whether is protected helmet or not
     */
    public Helmet(int price, int weight, boolean isProtectedFace) {
        super(price, weight);
        this.isProtectedFace = isProtectedFace;
    }

    //getters & setters

    public boolean isProtectedFace() {
        return isProtectedFace;
    }

    public void setProtectedFace(boolean protectedFace) {
        isProtectedFace = protectedFace;
    }
}
