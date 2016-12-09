package ua.training;

import ua.training.controller.IController;
import ua.training.controller.TextController;
import ua.training.model.io.reader.FileReader;
import ua.training.model.io.reader.IStringReader;
import ua.training.model.text.parser.ITextProcessor;
import ua.training.model.text.parser.TextProcessor;
import ua.training.view.ConsoleView;
import ua.training.view.FileView;
import ua.training.view.IView;

import java.io.File;

/**
 * Entry point in the program
 */
public class Main {

    /**
     * Entry method in the program. Creates objects of {@link TextProcessor},
     * {@link java.io.FileReader}, {@link ConsoleView},
     * {@link TextController} classes and invokes execute method of
     * {@link TextController}.
     * @param args start arguments
     */
    public static void main(String[] args) {
        ITextProcessor textProcessor = new TextProcessor();
        IStringReader textReader = new FileReader(
                new File("resources/text.txt"));
        IStringReader wordReader = new FileReader(
                new File("resources/words.txt"));
        IView view = new FileView(new File("resources/output.txt"));
//        IView view = new ConsoleView();
        IController controller = new TextController(view, textProcessor,
                textReader, wordReader);
        controller.execute();
    }
}
