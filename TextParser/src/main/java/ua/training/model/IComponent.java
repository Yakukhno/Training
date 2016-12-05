package ua.training.model;

import java.util.List;

public interface IComponent {

    void parse();

    List<IComponent> getComponents();

}
