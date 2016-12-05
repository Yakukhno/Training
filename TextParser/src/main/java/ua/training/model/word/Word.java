package ua.training.model.word;

import ua.training.model.IComponent;
import ua.training.model.symbol.Letter;
import ua.training.model.symbol.PunctuationMark;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word implements IWord {

    private String word;
    private List<IComponent> components = new ArrayList<>();

    private String letterExp = "[а-яА-яЁёA-Za-z]";
    private String punctuationExp = "['\\-]";
    private String regExp = letterExp + "|" + punctuationExp;

    public Word(String word) {
        this.word = word;
    }

    public void parse() {
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(word);
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

    @Override
    public List<IComponent> getComponents() {
        return components;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word1 = (Word) o;

        return word != null ? word.equals(word1.word) : word1.word == null;
    }

    @Override
    public int hashCode() {
        return word != null ? word.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                '}';
    }
}
