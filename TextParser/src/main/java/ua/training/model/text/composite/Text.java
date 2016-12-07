package ua.training.model.text.composite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class describes text, parses it on sentences.
 * Extends {@link AbstractCompositeElement}.
 *
 * @author Ivan Yakukhno
 */
public class Text extends AbstractCompositeElement {

    /**
     * Regular expression to find sentence.
     */
    private String regExp = ".*?(\\?!|[.?!](\\.\\.)?)(?!\\d)";

    /**
     * Constructor.
     * @param text string presentation of text
     */
    public Text(String text) {
        super(text);
    }

    /**
     * Parses sentence on sentences.
     * Invokes parse methods on components.
     */
    public void parse() {
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(element);
        while (matcher.find()) {
            addSentence(matcher.group().trim());
        }
        parseComponents();
    }

    /**
     * Create object of {@link Sentence} and adds it to list of components.
     * @param sentence string presentation of sentence.
     */
    void addSentence(String sentence) {
        components.add(new Sentence(sentence));
    }

}
