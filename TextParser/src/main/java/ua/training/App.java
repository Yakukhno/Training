package ua.training;

import ua.training.controller.TextController;
import ua.training.model.io.reader.FileReader;
import ua.training.model.io.reader.IStringReader;
import ua.training.view.ConsoleView;
import ua.training.view.IView;

import java.io.File;

public class App {

    public static void main(String[] args) {
        IStringReader textReader = new FileReader(
                new File("resources/text.txt"));
        IStringReader wordReader = new FileReader(
                new File("resources/words.txt"));
        IView view = new ConsoleView();
        TextController controller = new TextController(view, textReader,
                wordReader);
        controller.execute();
    }
}
