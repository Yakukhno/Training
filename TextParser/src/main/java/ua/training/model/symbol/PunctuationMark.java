package ua.training.model.symbol;

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
