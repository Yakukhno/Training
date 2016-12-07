package ua.training.controller;

import ua.training.model.text.parser.IWordsParser;
import ua.training.model.text.parser.WordsParserImpl;
import ua.training.model.io.reader.IStringReader;
import ua.training.view.IView;

public class TextController implements IController {

    private IView view;
    private IStringReader textReader;
    private IStringReader wordsReader;
    private IWordsParser parser;

    public TextController(IView view, IStringReader textReader,
                          IStringReader wordsReader) {
        this.view = view;
        this.textReader = textReader;
        this.wordsReader = wordsReader;
        parser = new WordsParserImpl(textReader.getString(),
                wordsReader.getString());
    }

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
