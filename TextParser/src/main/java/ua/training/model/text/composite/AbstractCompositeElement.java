package ua.training.model.text.composite;

import ua.training.model.text.IComponent;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCompositeElement implements IComponent {

    protected String element;
    protected List<IComponent> components = new ArrayList<>();

    public AbstractCompositeElement(String element) {
        this.element = element;
    }

    @Override
    public abstract void parse();

    @Override
    public List<IComponent> getComponents() {
        return components;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractCompositeElement)) return false;

        AbstractCompositeElement that = (AbstractCompositeElement) o;

        return element != null ? element.equals(that.element) : that.element == null;
    }

    @Override
    public int hashCode() {
        return element != null ? element.hashCode() : 0;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + element + '}';
    }
}
