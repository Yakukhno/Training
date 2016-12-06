package ua.training.model.text.symbol;

public class Symbol extends AbstractBasicComponent {

    private Type type;

    public Symbol(String element, Type type) {
        super(element);
        this.type = type;
    }

    public enum Type {
        LETTER, DIGIT, PUNCTUATION_MARK;

        @Override
        public String toString() {
            return name().substring(0, 1) + name().substring(1).toLowerCase();
        }
    }

    @Override
    public String toString() {
        return type + "{" + element + '}';
    }
}
