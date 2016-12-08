package ua.training.model.text.element;

import ua.training.model.text.IComponent;

/**
 * Class describes block of code. Implements interface {@link IComponent}.
 *
 * @see ua.training.model.text.IComponent
 * @author Ivan Yakukhno
 */
public class Code implements IComponent {

    /**
     * Code.
     */
    private String element;

    /**
     * Constructor.
     * @param element string presentation of code
     */
    public Code(String element) {
        this.element = element;
    }

    public String getElement() {
        return element;
    }

    /**
     * Equals objects of {@link Code} type using element field.
     * @param o object to equality.
     * @return is objects equal.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Code)) return false;

        Code code = (Code) o;

        return element != null ? element.equals(code.element) : code.element == null;
    }

    /**
     * Returns hash code of object.
     * @return hash code of object
     */
    @Override
    public int hashCode() {
        return element != null ? element.hashCode() : 0;
    }

    /**
     * Return string presentation of {@link Code} object.
     * @return string presentation of {@link Code} object
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + element + '}';
    }

}
