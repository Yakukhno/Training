package ua.training.model.text;

import ua.training.model.IComponent;
import ua.training.model.sentence.Sentence;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text implements IText {

    private String text;
    private List<IComponent> components = new ArrayList<>();

    private String regExp = ".*?[.!?](?!\\d)";

    public Text(String text) {
        this.text = text;
    }

    public void parse() {
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            addSentence(matcher.group().trim());
        }
        for (IComponent component : components) {
            System.out.println(component);
            component.parse();
        }
    }

    private void addSentence(String sentence) {
        components.add(new Sentence(sentence));
    }


}
