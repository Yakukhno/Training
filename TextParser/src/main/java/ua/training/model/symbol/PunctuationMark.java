package ua.training.model.symbol;

import ua.training.model.IComponent;

import java.util.List;

public class PunctuationMark implements ISymbol {

    private String mark;

    public PunctuationMark(String mark) {
        this.mark = mark;
    }

    public void parse() {}

    @Override
    public List<IComponent> getComponents() {
        return null;
    }

    @Override
    public String toString() {
        return "PunctuationMark{" +
                "mark='" + mark + '\'' +
                '}';
    }
}
