package ua.training.controller;

import ua.training.model.text.parser.IWordsParser;
import ua.training.model.text.parser.WordsParserImpl;
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
     * Constructor. Creates {@link WordsParserImpl} object.
     * @param view view
     * @param textReader reader of text
     * @param wordsReader reader of words
     */
    public TextController(IView view, IStringReader textReader,
                          IStringReader wordsReader) {
        this.view = view;
        parser = new WordsParserImpl(textReader.getString(),
                wordsReader.getString());
    }

    /**
     * Invokes parse methods on parser.
     * Transmit results of parsing in view.
     */
    public void execute() {
        parser.parse();

        view.showMessage(parser.getWordsOccurrencesInEachSentence().toString());
        view.showMessage(parser.sortWords(parser.wordsByOccurrencesComparator()
                .reversed()).toString());
    }

    void setParser(IWordsParser parser) {
        this.parser = parser;
    }
}
