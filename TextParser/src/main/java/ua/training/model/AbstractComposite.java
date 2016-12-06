package ua.training.model;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractComposite implements IComponent {

    protected String element;
    protected List<IComponent> components = new ArrayList<>();

    public AbstractComposite(String element) {
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
        if (!(o instanceof AbstractComposite)) return false;

        AbstractComposite that = (AbstractComposite) o;

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
