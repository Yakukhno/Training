package ua.training.model.text.element;

import ua.training.model.text.IComponent;

/**
 * Class describes element. Implements interface {@link IComponent}.
 *
 * @see ua.training.model.text.IComponent
 * @author Ivan Yakukhno
 */
public class Symbol implements IComponent {

    /**
     * Symbol.
     */
    private final char element;

    /**
     * Type of element.
     */
    private Type type;

    /**
     * Constructor.
     * @param element element
     * @param type type of element
     */
    public Symbol(char element, Type type) {
        this.element = element;
        this.type = type;
    }

    @Override
    public String getElement() {
        return Character.toString(element);
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

        if (element != symbol.element) return false;
        return type == symbol.type;
    }

    /**
     * Returns hash code of object.
     * @return hash code of object
     */
    @Override
    public int hashCode() {
        int result = (int) element;
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
     * Enum contains types of element.
     */
    public enum Type {
        LETTER, DIGIT, PUNCTUATION_MARK;

        @Override
        public String toString() {
            return name().substring(0, 1) + name().substring(1).toLowerCase();
        }
    }
}
