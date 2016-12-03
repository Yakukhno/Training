package ua.training.controller;

import ua.training.model.IText;
import ua.training.view.IView;

public class TextController {

    private IText text;
    private IView view;

    public TextController(IText text, IView view) {
        this.text = text;
        this.view = view;
    }

    public void execute() {

    }
}
