package ua.training;

import ua.training.controllers.KnightController;
import ua.training.models.ammunition.ChainArmor;
import ua.training.models.ammunition.Helmet;
import ua.training.models.ammunition.Shield;
import ua.training.models.ammunition.Weapon;
import ua.training.models.knight.IKnight;
import ua.training.models.knight.Knight;
import ua.training.views.View;

public class Main {

    public static void main(String[] args) {
        IKnight knight = new Knight();
        View view = new View();

        KnightController controller = new KnightController(knight, view);
        controller.execute();
    }

}
