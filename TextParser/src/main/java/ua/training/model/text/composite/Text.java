package ua.training.model.text.composite;

import ua.training.model.text.element.Code;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class describes text, parses it on sentences.
 * Extends {@link AbstractCompositeElement}.
 *
 * @author Ivan Yakukhno
 */
public class Text extends AbstractCompositeElement {

    private String codeExp = "(((package|import(\\s+static)?)\\s+\\w+" +
            "(\\s*\\.\\s*\\w+)*\\s*;)" +
            "|(public\\s+)?((abstract|final)\\s+)?" +
            "class\\s+\\w+((\\s+extends\\s+\\w+(\\s*,\\s*\\w*)*)?" +
            "(\\s+implements\\s+\\w+(\\s*,\\s*\\w*)*)?)" +
            "\\s*\\{).*?}(\\w+\\s+\\w+\\s+)";

    private String sentenceExp = ".*?(\\?!|[.?!](\\.\\.)?)(?!\\d)";

    /**
     * Regular expression to find sentence.
     */
    private String regExp = codeExp + "|" + sentenceExp;

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
        Matcher matcher = pattern.matcher(element.replaceAll("\n", " "));
        while (matcher.find()) {
            String element = matcher.group();
            if (element.matches(codeExp)) {
                addCode(element);
            } else if (element.matches(sentenceExp)) {
                addSentence(matcher.group().trim());
            }
        }
        parseComponents();
    }

    /**
     * Creates object of {@link Sentence} and adds it to list of components.
     * @param sentence string presentation of sentence.
     */
    void addSentence(String sentence) {
        components.add(new Sentence(sentence));
    }

    /**
     * Creates object of {@link Code} and adds it to list of components.
     * @param code string presentation of sentence.
     */
    void addCode(String code) {
        components.add(new Code(code));
    }
}
