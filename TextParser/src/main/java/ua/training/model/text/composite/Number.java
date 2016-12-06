package ua.training.model.text.composite;

import ua.training.model.text.IComponent;
import ua.training.model.text.symbol.Symbol;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Number extends AbstractCompositeElement {

    private String digitExp = "\\d";
    private String punctuationExp = "\\.";
    private String regExp = digitExp + "|" + punctuationExp;

    public Number(String number) {
        super(number);
    }

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
        for (IComponent component : components) {
            System.out.println("\t\t" + component);
            component.parse();        }
    }

    private void addDigit(String digit) {
        components.add(new Symbol(digit, Symbol.Type.DIGIT));
    }

    private void addPunctuationMark(String mark) {
        components.add(new Symbol(mark, Symbol.Type.PUNCTUATION_MARK));
    }
}
