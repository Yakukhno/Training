package ua.training.controller;

import ua.training.model.text.IComponent;
import ua.training.model.text.parser.IWordsParser;
import ua.training.model.text.parser.TextProcessor;
import ua.training.model.io.reader.IStringReader;
import ua.training.view.IView;

/**
 * Class describes controller between parser and view.
 * Implements {@link IController} interface.
 *
 * @author Ivan Yakukhno
 */
public class TextController implements IController {

    /**
     * View.
     */
    private IView view;

    /**
     * Words parser.
     */
    private IWordsParser parser;

    /**
     * Constructor. Creates {@link TextProcessor} object.
     * @param view view
     * @param textReader reader of text
     * @param wordsReader reader of words
     */
    public TextController(IView view, IStringReader textReader,
                          IStringReader wordsReader) {
        this.view = view;
        parser = new TextProcessor(textReader.getString(),
                wordsReader.getString());
    }

    /**
     * Invokes parse methods on parser.
     * Transmit results of parsing in view.
     */
    public void execute() {
        parser.parse();

        view.showMessage(componentToString(parser.getText(), ""));

        view.showMessage(parser.getWordsOccurrencesInEachSentence().toString());
        view.showMessage(parser.sortWords(parser.wordsByOccurrencesComparator()
                .reversed()).toString());
    }

    /**
     * Creates string presentation of component.
     * @param component component to string presentation
     * @param tabulation tabulation
     * @return string presentation of component
     */
    String componentToString(IComponent component, String tabulation) {
        String string = "\n" + tabulation + component.toString();
        if (component.getComponents() != null) {
            for (IComponent loopComponent : component.getComponents()) {
                string += componentToString(loopComponent, tabulation + "\t");
            }
        }
        return string;
    }

    void setParser(IWordsParser parser) {
        this.parser = parser;
    }
}
