package ua.training.model.text.symbol;

import ua.training.model.text.IComponent;

import java.util.List;

/**
 * Class describes symbol. Implements interface {@link IComponent}.
 *
 * @see ua.training.model.text.IComponent
 */
public class Symbol implements IComponent {

    /**
     * Symbol.
     */
    private String element;

    /**
     * Type of symbol.
     */
    private Type type;

    /**
     * Constructor.
     * @param element symbol
     * @param type type of symbol
     */
    public Symbol(String element, Type type) {
        this.element = element;
        this.type = type;
    }

    /**
     * Stub method, do nothing.
     */
    @Override
    public void parse() {}

    /**
     * Stub method. Returns null.
     * @return null
     */
    @Override
    public List<IComponent> getComponents() {
        return null;
    }

    /**
     * Equals objects of {@link Symbol} type using element and type fields.
     * @param o object to equality.
     * @return is objects equal.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Symbol)) return false;

        Symbol symbol = (Symbol) o;

        return (element != null
                ? element.equals(symbol.element)
                : symbol.element == null) && type == symbol.type;
    }

    /**
     * Returns hash code of object.
     * @return hash code of object
     */
    @Override
    public int hashCode() {
        int result = element != null ? element.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    /**
     * Return string presentation of {@link Symbol} object.
     * @return string presentation of {@link Symbol} object
     */
    @Override
    public String toString() {
        return type + "{" + element + '}';
    }

    /**
     * Enum contains types of symbol.
     */
    public enum Type {
        LETTER, DIGIT, PUNCTUATION_MARK;

        @Override
        public String toString() {
            return name().substring(0, 1) + name().substring(1).toLowerCase();
        }
    }
}
