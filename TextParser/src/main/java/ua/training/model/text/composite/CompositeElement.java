package ua.training.model.text.composite;

import ua.training.model.text.IComponent;

import java.util.ArrayList;
import java.util.List;

public class CompositeElement implements ICompositeElement {

    /**
     * Type of composite element.
     */
    private Type type;

    /**
     * List of components of element.
     */
    private List<IComponent> components = new ArrayList<>();

    public CompositeElement(Type type) {
        this.type = type;
    }

    public String getElement() {
        String str = "";
        for (IComponent component : components) {
            str += component.getElement();
        }
        return str + " ";
    }

    public void addComponent(IComponent component) {
        components.add(component);
    }

    public Type getType() {
        return type;
    }

    @Override
    public List<IComponent> getComponents() {
        return components;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompositeElement)) return false;

        CompositeElement that = (CompositeElement) o;

        if (type != that.type) return false;
        return components != null ? components.equals(that.components) : that.components == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (components != null ? components.hashCode() : 0);
        return result;
    }

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
