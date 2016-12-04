package ua.training.model.symbol;

import ua.training.model.symbol.ISymbol;

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
