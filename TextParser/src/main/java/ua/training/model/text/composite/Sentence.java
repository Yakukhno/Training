package ua.training.model.text.composite;

import ua.training.model.text.IComponent;
import ua.training.model.text.symbol.Symbol;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence extends AbstractCompositeElement {

    private String wordExp = "^[а-яА-яЁёA-Za-z\\-']+$";
    private String numberExp = "^\\d+(\\.*\\d+)?$";
    private String punctuationExp = "[.,?!\\[\\]—\\-()«»'\":;]";
    private String regExp = "[а-яА-яЁё\\w\\-.']+(?=\\s|" + punctuationExp +
            ")|" + punctuationExp;

    public Sentence(String sentence) {
        super(sentence);
    }

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
        for (IComponent component : components) {
            System.out.println("\t" + component);
            component.parse();
        }
    }

    private void addWord(String word) {
        components.add(new Word(word));
    }

    private void addPunctuationMark(String mark) {
        components.add(new Symbol(mark, Symbol.Type.PUNCTUATION_MARK));
    }

    private void addNumber(String number) {
        components.add(new Number(number));
    }
}
