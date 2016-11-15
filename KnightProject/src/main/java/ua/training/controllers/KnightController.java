package ua.training.controllers;

import ua.training.models.knight.IKnight;
import ua.training.views.View;

public class KnightController {

    private IKnight knight;
    private View view;

    public KnightController(IKnight knight, View view) {
        this.knight = knight;
        this.view = view;
    }

    public void execute() {}

}
