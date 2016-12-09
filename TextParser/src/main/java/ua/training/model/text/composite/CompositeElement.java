package ua.training.model.text.composite;

import ua.training.model.text.IComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * Class describes composite element.
 * Implements interface {@link ICompositeElement}.
 *
 * @author Ivan Yakukhno
 */
public class CompositeElement implements ICompositeElement {

    /**
     * Type of composite element.
     */
    private Type type;

    /**
     * List of components of element.
     */
    private List<IComponent> components = new ArrayList<>();

    /**
     * Constructor.
     * @param type {@link Type} of composite element
     */
    public CompositeElement(Type type) {
        this.type = type;
    }

    /**
     * Returns string presentation of element.
     * @return string presentation of element
     */
    public String getElement() {
        String str = "";
        for (IComponent component : components) {
            str += component.getElement();
        }
        return str + " ";
    }

    /**
     * Adds {@link IComponent} object to components of composite.
     * @param component object to add to components of composite
     */
    public void addComponent(IComponent component) {
        components.add(component);
    }

    /**
     * Returns {@link Type} of composite element.
     * @return {@link Type} of composite element
     */
    public Type getType() {
        return type;
    }

    /**
     * Returns components of composite.
     * @return components of composite
     */
    @Override
    public List<IComponent> getComponents() {
        return components;
    }

    /**
     * Equals objects of {@link CompositeElement} type using components
     * and type fields.
     * @param o object to equality.
     * @return is objects equal.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompositeElement)) return false;

        CompositeElement that = (CompositeElement) o;

        if (type != that.type) return false;
        return components != null ? components.equals(that.components) : that.components == null;
    }

    /**
     * Returns hash code of object.
     * @return hash code of object
     */
    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (components != null ? components.hashCode() : 0);
        return result;
    }

    /**
     * Return string presentation of {@link CompositeElement} object.
     * @return string presentation of {@link CompositeElement} object
     */
    @Override
    public String toString() {
        return type + "{" + getElement() + '}';
    }

    /**
     * Enum contains types of composite elements.
     */
    public enum Type {
        NUMBER, WORD, SENTENCE, TEXT;

        @Override
        public String toString() {
            return name().substring(0, 1) + name().substring(1).toLowerCase();
        }
    }

}
