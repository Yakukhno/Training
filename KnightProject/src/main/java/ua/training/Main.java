package ua.training;

import ua.training.controllers.KnightController;
import ua.training.models.IKnight;
import ua.training.views.View;

public class Main {

    public static void main(String[] args) {
        IKnight knight = new IKnight() {};
        View view = new View();

        KnightController controller = new KnightController(knight, view);
        controller.execute();
    }

}
