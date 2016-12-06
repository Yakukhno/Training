package ua.training.model.text.symbol;

import ua.training.model.text.IComponent;

import java.util.List;

public abstract class AbstractBasicComponent implements IComponent {

    protected String element;

    public AbstractBasicComponent(String element) {
        this.element = element;
    }

    @Override
    public void parse() {}

    @Override
    public List<IComponent> getComponents() {
        return null;
    }
}
