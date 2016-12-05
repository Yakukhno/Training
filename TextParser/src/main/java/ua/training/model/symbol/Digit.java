package ua.training.model.symbol;

import ua.training.model.IComponent;

import java.util.List;

public class Digit implements ISymbol {

    private String digit;

    public Digit(String digit) {
        this.digit = digit;
    }

    @Override
    public void parse() {}

    @Override
    public List<IComponent> getComponents() {
        return null;
    }

    @Override
    public String toString() {
        return "Digit{" +
                "digit='" + digit + '\'' +
                '}';
    }
}
