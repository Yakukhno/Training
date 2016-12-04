package ua.training.controller;

import ua.training.model.reader.IStringReader;
import ua.training.model.text.IText;
import ua.training.model.text.Text;
import ua.training.view.IView;

public class TextController {

    private IText text;
    private IView view;
    private IStringReader reader;

    public TextController(IStringReader reader, IView view) {
        this.reader = reader;
        this.view = view;
    }

    public void execute() {
        text = new Text(reader.getString());
        text.parse();
    }
}
