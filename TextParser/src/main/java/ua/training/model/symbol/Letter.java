package ua.training.model.symbol;

import ua.training.model.symbol.ISymbol;

public class Letter implements ISymbol {

    private String letter;

    public Letter(String letter) {
        this.letter = letter;
    }

    @Override
    public void parse() {

    }

    @Override
    public String toString() {
        return "Letter{" +
                "letter='" + letter + '\'' +
                '}';
    }
}
