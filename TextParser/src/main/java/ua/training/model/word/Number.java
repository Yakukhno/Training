package ua.training.model.word;

import ua.training.model.IComponent;
import ua.training.model.symbol.Digit;
import ua.training.model.symbol.PunctuationMark;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Number implements IWord {

    private String number;
    private List<IComponent> components = new ArrayList<>();

    private String digitExp = "\\d";
    private String punctuationExp = "\\.";
    private String regExp = digitExp + "|" + punctuationExp;

    public Number(String number) {
        this.number = number;
    }

    @Override
    public void parse() {
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(number);
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
            component.parse();
        }
    }

    private void addDigit(String letter) {
        components.add(new Digit(letter));
    }

    private void addPunctuationMark(String mark) {
        components.add(new PunctuationMark(mark));
    }

    @Override
    public String toString() {
        return "Number{" +
                "number='" + number + '\'' +
                '}';
    }
}
