package ua.training.model.text.composite;

import ua.training.model.text.symbol.Symbol;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class describes number, parses it on digits.
 * Extends {@link AbstractCompositeElement}.
 *
 * @author Ivan Yakukhno
 */
public class Number extends AbstractCompositeElement {

    /**
     * Regular expression to find digit.
     */
    private String digitExp = "\\d";

    /**
     * Regular expression to find dot.
     */
    private String punctuationExp = "\\.";

    /**
     * Regular expression to find digit or dot.
     */
    private String regExp = digitExp + "|" + punctuationExp;

    /**
     * Constructor.
     * @param number string presentation of number
     */
    public Number(String number) {
        super(number);
    }

    /**
     * Parses number on digits and dot. Invokes parse methods on components.
     */
    @Override
    public void parse() {
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(element);
        while (matcher.find()) {
            String element = matcher.group();
            if (element.matches(digitExp)) {
                addDigit(element);
            } else if (element.matches(punctuationExp)) {
                addPunctuationMark(element);
            }
        }
        parseComponents();
    }

    /**
     * Create object of digit {@link Symbol} and adds it to list of components.
     * @param digit string presentation of digit.
     */
    void addDigit(String digit) {
        components.add(new Symbol(digit, Symbol.Type.DIGIT));
    }

    /**
     * Create object of punctuation {@link Symbol} and adds it to list of components.
     * @param mark string presentation of punctuation mark.
     */
    void addPunctuationMark(String mark) {
        components.add(new Symbol(mark, Symbol.Type.PUNCTUATION_MARK));
    }
}
