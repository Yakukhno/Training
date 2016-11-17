package ua.training;

import ua.training.controller.KnightController;
import ua.training.model.knight.AbstractKnightBuilder;
import ua.training.model.knight.KnightBuilder;
import ua.training.view.View;

/**
 * Entry point in the program
 */
public class Main {

    /**
     * Entry method in the program
     * @param args start arguments
     */
    public static void main(String[] args) {
        AbstractKnightBuilder knight = new KnightBuilder();
        View view = new View();

        KnightController controller = new KnightController(knight, view);
        controller.execute();
    }

}
