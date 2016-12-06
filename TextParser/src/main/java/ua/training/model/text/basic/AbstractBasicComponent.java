package ua.training.model.text.basic;

import ua.training.model.text.IComponent;

import java.util.List;

public abstract class AbstractBasicComponent implements IComponent {

    private String element;

    public AbstractBasicComponent(String element) {
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
