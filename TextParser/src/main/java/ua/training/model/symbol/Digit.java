package ua.training.model.symbol;

public class Digit implements ISymbol {

    private String digit;

    public Digit(String digit) {
        this.digit = digit;
    }

    @Override
    public void parse() {

    }

    @Override
    public String toString() {
        return "Digit{" +
                "digit='" + digit + '\'' +
                '}';
    }
}
