package ua.training.model.text.parser;

import ua.training.model.text.composite.ICompositeElement;

/**
 * Interface describes parser with parse method.
 *
 * @author Ivan Yakukhno
 */
public interface IParser {

    /**
     * Parses string text and returns its {@link ICompositeElement} presentation.
     */
    ICompositeElement parseText(String string);

    /**
     * Parses string sentence and returns its {@link ICompositeElement} presentation.
     */
    ICompositeElement parseSentence(String string);

    /**
     * Parses string word and returns its {@link ICompositeElement} presentation.
     */
    ICompositeElement parseWord(String string);

    /**
     * Parses string number and returns its {@link ICompositeElement} presentation.
     */
    ICompositeElement parseNumber(String string);
}
