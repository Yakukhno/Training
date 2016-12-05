package ua.training.model.symbol;

import ua.training.model.IComponent;

import java.util.List;

public class Letter implements ISymbol {

    private String letter;

    public Letter(String letter) {
        this.letter = letter;
    }

    @Override
    public void parse() {}

    @Override
    public List<IComponent> getComponents() {
        return null;
    }

    @Override
    public String toString() {
        return "Letter{" +
                "letter='" + letter + '\'' +
                '}';
    }
}
