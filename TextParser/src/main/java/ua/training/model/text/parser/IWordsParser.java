package ua.training.model.text.parser;

import ua.training.model.text.IComponent;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Interface describes parser, which parses words in text.
 * Extends {@link IParser} interface.
 *
 * @author Ivan Yakukhno
 */
public interface IWordsParser extends IParser {

    /**
     * Returns words occurrences in each sentence in text.
     * @return words occurrences in each sentence in text
     */
    Map<IComponent, List<Integer>> getWordsOccurrencesInEachSentence();

    /**
     * Returns words occurrences in all sentences in text.
     * @return words occurrences in all sentences in text
     */
    Map<IComponent, Integer> getWordsOccurrencesInAllSentences();

    IComponent getText();

    /**
     * Sorts words using comparator.
     * @return sorted map of words
     */
    TreeMap<IComponent, Integer> sortWords(Comparator<IComponent> comparator);

    /**
     * Returns comparator, which compare words by occurrences.
     * @return comparator, which compare words by occurrences
     */
    Comparator<IComponent> wordsByOccurrencesComparator();

}
