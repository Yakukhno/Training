package ua.training.model.knight.ammunition;

public class Helmet extends AbstractAmmunition  {

    private boolean isProtectedFace;

    public Helmet(int price, int weight, boolean isProtectedFace) {
        super(price, weight);
        this.isProtectedFace = isProtectedFace;
    }

    public boolean isProtectedFace() {
        return isProtectedFace;
    }

    public void setProtectedFace(boolean protectedFace) {
        isProtectedFace = protectedFace;
    }
}
