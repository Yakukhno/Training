package ua.training.model.text.element;

import ua.training.model.text.IComponent;

import java.util.List;

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

    public String getString() {
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
