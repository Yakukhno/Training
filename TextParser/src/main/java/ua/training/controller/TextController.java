package ua.training.controller;

import ua.training.model.parser.WordsParser;
import ua.training.model.reader.IStringReader;
import ua.training.view.IView;

public class TextController {

    private IView view;
    private IStringReader textReader;
    private IStringReader wordsReader;
    private WordsParser parser;

    public TextController(IView view, IStringReader textReader,
                          IStringReader wordsReader) {
        this.view = view;
        this.textReader = textReader;
        this.wordsReader = wordsReader;
    }

    public void execute() {
        parser = new WordsParser(textReader.getString(), wordsReader.getString());
        parser.parse();
        System.out.println(parser.getWordsOccurrencesInAllSentences());
        System.out.println(parser.getWordsOccurrencesInEachSentence());
        System.out.println(parser.sortWords(parser.wordsByOccurrencesComparator()
                .reversed()));
    }
}
