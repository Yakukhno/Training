package ua.training.model.text.composite;

import ua.training.model.text.IComponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text extends AbstractCompositeElement {

    private String regExp = ".*?(\\?!|[.?!](\\.\\.)?)(?!\\d)";

    public Text(String text) {
        super(text);
    }

    public void parse() {
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(element);
        while (matcher.find()) {
            addSentence(matcher.group().trim());
        }
        for (IComponent component : components) {
//            System.out.println(component);
            component.parse();
        }
    }

    private void addSentence(String sentence) {
        components.add(new Sentence(sentence));
    }

}
