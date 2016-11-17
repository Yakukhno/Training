package ua.training.model.knight.ammunition;

/**
 * Implementation of <tt>AbstractAmmunition</tt> abstract class.
 * Describes helmet.
 */
public class Helmet extends AbstractAmmunition {

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
