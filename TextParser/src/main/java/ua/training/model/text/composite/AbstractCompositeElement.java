package ua.training.model.text.composite;

import ua.training.model.text.IComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * Class describes element, which can parse its string element and
 * invokes parse method on its components.
 * Implements {@link IComponent} interface.
 *
 * @author Ivan Yakukhno
 */
public abstract class AbstractCompositeElement implements IComponent {

    /**
     * String presentation of element.
     */
    protected String element;

    /**
     * List of components of element.
     */
    protected List<IComponent> components = new ArrayList<>();

    /**
     * Constructor.
     * @param element string presentation of element.
     */
    public AbstractCompositeElement(String element) {
        this.element = element;
    }

    @Override
    public abstract void parse();

    /**
     * Invokes parse methods on components.
     */
    protected void parseComponents() {
        for (IComponent component : components) {
            component.parse();
        }
    }

    @Override
    public List<IComponent> getComponents() {
        return components;
    }

    public String getString() {
        String str = "";
        for (IComponent component : components) {
            str += component.getString();
        }
        return str + " ";
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
