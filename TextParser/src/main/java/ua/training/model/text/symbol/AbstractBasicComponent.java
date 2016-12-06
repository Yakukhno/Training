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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractBasicComponent)) return false;

        AbstractBasicComponent that = (AbstractBasicComponent) o;

        return element != null ? element.equals(that.element) : that.element == null;
    }

    @Override
    public int hashCode() {
        return element != null ? element.hashCode() : 0;
    }

    @Override
    public List<IComponent> getComponents() {
        return null;
    }
}
