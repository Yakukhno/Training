package ua.training.model.text.composite;

import ua.training.model.text.symbol.Symbol;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class describes word, parses it on letters.
 * Extends {@link AbstractCompositeElement}.
 *
 * @author Ivan Yakukhno
 */
public class Word extends AbstractCompositeElement {

    /**
     * Regular expression to find letter.
     */
    private String letterExp = "[а-яА-яЁёA-Za-z]";

    /**
     * Regular expression to find punctuation mark.
     */
    private String punctuationExp = "['\\-]";

    /**
     * Regular expression to find letter or punctuation mark.
     */
    private String regExp = letterExp + "|" + punctuationExp;

    /**
     * Constructor.
     * @param word string presentation of word
     */
    public Word(String word) {
        super(word);
    }

    /**
     * Parses word on letters and punctuation marks.
     * Invokes parse methods on components.
     */
    @Override
    public void parse() {
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(element);
        while (matcher.find()) {
            String element = matcher.group();
            if (element.matches(letterExp)) {
                addLetter(element);
            } else if (element.matches(punctuationExp)) {
                addPunctuationMark(element);
            }
        }
        parseComponents();
    }

    /**
     * Create object of letter {@link Symbol} and adds it to list of components.
     * @param letter string presentation of letter.
     */
    void addLetter(String letter) {
        components.add(new Symbol(letter, Symbol.Type.LETTER));
    }

    /**
     * Create object of punctuation {@link Symbol} and adds it to list of components.
     * @param mark string presentation of punctuation mark.
     */
    void addPunctuationMark(String mark) {
        components.add(new Symbol(mark, Symbol.Type.PUNCTUATION_MARK));
    }
}
