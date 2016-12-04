package ua.training;

import ua.training.controller.TextController;
import ua.training.model.reader.FileReader;
import ua.training.model.reader.IStringReader;
import ua.training.view.ConsoleView;
import ua.training.view.IView;

import java.io.File;

public class App {

    public static void main(String[] args) {
        IStringReader reader = new FileReader(new File("resources/input_file.txt"));
        IView view = new ConsoleView();
        TextController controller = new TextController(reader, view);
        controller.execute();
    }
}
