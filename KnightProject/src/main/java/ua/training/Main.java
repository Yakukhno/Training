package ua.training;

import ua.training.controller.KnightController;
import ua.training.model.knight.AbstractKnightBuilder;
import ua.training.model.knight.KnightBuilder;
import ua.training.view.View;

public class Main {

    public static void main(String[] args) {
        AbstractKnightBuilder knight = new KnightBuilder();
        View view = new View();

        KnightController controller = new KnightController(knight, view);
        controller.execute();
    }

}
