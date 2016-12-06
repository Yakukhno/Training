package ua.training.model.word;

import ua.training.model.AbstractComposite;
import ua.training.model.IComponent;
import ua.training.model.symbol.Letter;
import ua.training.model.symbol.PunctuationMark;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word extends AbstractComposite implements IWord {

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
//            System.out.println("\t\t" + component);
            component.parse();
        }
    }

    private void addLetter(String letter) {
        components.add(new Letter(letter));
    }

    private void addPunctuationMark(String mark) {
        components.add(new PunctuationMark(mark));
    }
}