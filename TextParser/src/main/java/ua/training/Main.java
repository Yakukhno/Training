package ua.training;

import ua.training.controller.IController;
import ua.training.controller.TextController;
import ua.training.model.io.reader.FileReader;
import ua.training.model.io.reader.IStringReader;
import ua.training.view.ConsoleView;
import ua.training.view.FileView;
import ua.training.view.IView;

import java.io.File;

/**
 * Entry point in the program
 */
public class Main {

    /**
     * Entry method in the program. Creates objects of {@link java.io.FileReader},
     * {@link ConsoleView}, {@link TextController} and invokes execute method of
     * {@link TextController}.
     * @param args start arguments
     */
    public static void main(String[] args) {
        IStringReader textReader = new FileReader(
                new File("resources/text.txt"));
        IStringReader wordReader = new FileReader(
                new File("resources/words.txt"));
//        IView view = new FileView(new File("resources/output.txt"));
        IView view = new ConsoleView();
        IController controller = new TextController(view, textReader,
                wordReader);
        controller.execute();
    }
}
