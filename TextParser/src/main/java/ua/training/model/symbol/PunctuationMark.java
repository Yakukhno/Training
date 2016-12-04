package ua.training.model.symbol;

import ua.training.model.symbol.ISymbol;

public class PunctuationMark implements ISymbol {

    private String mark;

    public PunctuationMark(String mark) {
        this.mark = mark;
    }

    public void parse() {

    }

    @Override
    public String toString() {
        return "PunctuationMark{" +
                "mark='" + mark + '\'' +
                '}';
    }
}
