package ua.training.model.text;

import java.util.List;

/**
 * Interface describes some element, which can parse something.
 *
 * @author Ivan Yakukhno
 */
public interface IComponent {

    /**
     * Parses its components and invokes parse methods on these components.
     */
    void parse();

    /**
     * Returns components of composite.
     * @return components of composite
     */
    List<IComponent> getComponents();

}
