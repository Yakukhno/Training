package ua.training.model.text.composite;

import ua.training.model.text.IComponent;

import java.util.List;

public interface ICompositeElement extends IComponent {

    /**
     * Returns components of composite.
     * @return components of composite
     */
    List<IComponent> getComponents();

    void addComponent(IComponent component);

}
