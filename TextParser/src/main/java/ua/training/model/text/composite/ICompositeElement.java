package ua.training.model.text.composite;

import ua.training.model.text.IComponent;

import java.util.List;

/**
 * Interface describes composite element, which can return its components
 * and add values to these components. Extends {@link IComponent} interface.
 *
 * @author Ivan Yakukhno
 */
public interface ICompositeElement extends IComponent {

    /**
     * Returns components of composite.
     * @return components of composite
     */
    List<IComponent> getComponents();

    /**
     * Adds {@link IComponent} object to components of composite.
     * @param component object to add to components of composite
     */
    void addComponent(IComponent component);

}
