package ua.training.model.text.composite;

import ua.training.model.text.symbol.Symbol;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class describes sentence, parses it on words, numbers and punctuation marks.
 * Extends {@link AbstractCompositeElement}.
 *
 * @author Ivan Yakukhno
 */
public class Sentence extends AbstractCompositeElement {

    /**
     * Regular expression to find word.
     */
    private String wordExp = "^[а-яА-яЁёA-Za-z\\-']+$";

    /**
     * Regular expression to find number.
     */
    private String numberExp = "^\\d+(\\.*\\d+)?$";

    /**
     * Regular expression to find punctuation mark.
     */
    private String punctuationExp = "[.,?!\\[\\]—\\-()«»'\":;]";

    /**
     * Regular expression to find word, number or punctuation mark.
     */
    private String regExp = "[а-яА-яЁё\\w\\-.']+(?=\\s|" + punctuationExp +
            ")|" + punctuationExp;

    /**
     * Constructor.
     * @param sentence string presentation of sentence
     */
    public Sentence(String sentence) {
        super(sentence);
    }

    /**
     * Parses sentence on words, numbers and punctuation marks.
     * Invokes parse methods on components.
     */
    public void parse() {
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(element);
        while (matcher.find()) {
            String element = matcher.group();
            if (element.matches(wordExp)) {
                addWord(element);
            } else if (element.matches(numberExp)) {
                addNumber(element);
            } else if (element.matches(punctuationExp)) {
                addPunctuationMark(element);
            } else {
                System.err.print("Error - " + element);
            }
        }
        parseComponents();
    }

    /**
     * Create object of {@link Word} and adds it to list of components.
     * @param word string presentation of word.
     */
    void addWord(String word) {
        components.add(new Word(word));
    }

    /**
     * Create object of punctuation {@link Symbol} and adds it to list of components.
     * @param mark string presentation of punctuation mark.
     */
    void addPunctuationMark(String mark) {
        components.add(new Symbol(mark, Symbol.Type.PUNCTUATION_MARK));
    }

    /**
     * Create object of {@link Number} and adds it to list of components.
     * @param number string presentation of number.
     */
    void addNumber(String number) {
        components.add(new Number(number));
    }
}
