package ua.training.model.text.composite;

import ua.training.model.text.IComponent;
import ua.training.model.text.symbol.Symbol;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word extends AbstractCompositeElement {

    private String letterExp = "[а-яА-яЁёA-Za-z]";
    private String punctuationExp = "['\\-]";
    private String regExp = letterExp + "|" + punctuationExp;

    public Word(String word) {
        super(word);
    }

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
        for (IComponent component : components) {
            System.out.println("\t\t" + component);
            component.parse();
        }
    }

    private void addLetter(String letter) {
        components.add(new Symbol(letter, Symbol.Type.LETTER));
    }

    private void addPunctuationMark(String mark) {
        components.add(new Symbol(mark, Symbol.Type.PUNCTUATION_MARK));
    }
}
