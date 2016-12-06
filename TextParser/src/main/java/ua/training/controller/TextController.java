package ua.training.controller;

import ua.training.model.parser.IWordsParser;
import ua.training.model.parser.WordsParserImpl;
import ua.training.model.io.reader.IStringReader;
import ua.training.view.IView;

public class TextController {

    private IView view;
    private IStringReader textReader;
    private IStringReader wordsReader;
    private IWordsParser parser;

    public TextController(IView view, IStringReader textReader,
                          IStringReader wordsReader) {
        this.view = view;
        this.textReader = textReader;
        this.wordsReader = wordsReader;
    }

    public void execute() {
        parser = new WordsParserImpl(textReader.getString(), wordsReader.getString());
        parser.parse();
        System.out.println(parser.getWordsOccurrencesInAllSentences());
        System.out.println(parser.getWordsOccurrencesInEachSentence());
        System.out.println(parser.sortWords(parser.wordsByOccurrencesComparator()
                .reversed()));
    }
}
