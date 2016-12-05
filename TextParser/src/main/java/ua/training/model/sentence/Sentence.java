package ua.training.model.sentence;

import ua.training.model.IComponent;
import ua.training.model.word.Number;
import ua.training.model.word.Word;
import ua.training.model.symbol.PunctuationMark;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence implements ISentence {

    private String sentence;
    private List<IComponent> components = new ArrayList<>();

    private String regExp = "[а-яА-яЁё\\w\\-.']+(?=\\s|[.,?!\\[\\]—()«»'\":;])|[.,?!\\[\\]—()«»'\":;]";
    private String wordExp = "^[а-яА-яЁёA-Za-z\\-']+$";
    private String numberExp = "^\\d+(\\.*\\d+)?$";
    private String punctuationExp = "[.,?!\\[\\]—\\-()«»'\":;]";

    public Sentence(String sentence) {
        this.sentence = sentence;
    }

    public void parse() {
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(sentence);
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
//            System.out.println("\t" + component);
            component.parse();
        }
    }

    private void addWord(String word) {
        components.add(new Word(word));
    }

    private void addPunctuationMark(String mark) {
        components.add(new PunctuationMark(mark));
    }

    private void addNumber(String number) {
        components.add(new Number(number));
    }

    public List<IComponent> getComponents() {
        return components;
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "sentence='" + sentence + '\'' +
                '}';
    }
}
