package ua.training.model.text;

import java.util.List;

public interface IComponent {

    void parse();

    List<IComponent> getComponents();

}
