package ua.training;

import ua.training.controller.TextController;
import ua.training.model.IText;
import ua.training.model.Text;
import ua.training.view.ConsoleView;
import ua.training.view.IView;

public class App {

    public static void main(String[] args) {
        IText text = new Text();
        IView view = new ConsoleView();
        TextController controller = new TextController(text, view);
        controller.execute();
    }
}
