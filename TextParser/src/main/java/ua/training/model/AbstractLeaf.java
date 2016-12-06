package ua.training.model;

import java.util.List;

public abstract class AbstractLeaf implements IComponent {

    protected String element;

    public AbstractLeaf(String element) {
        this.element = element;
    }

    @Override
    public void parse() {}

    @Override
    public List<IComponent> getComponents() {
        return null;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + element + '}';
    }
}
