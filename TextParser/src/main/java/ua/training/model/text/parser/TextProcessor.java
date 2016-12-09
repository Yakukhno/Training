package ua.training.model.text.parser;

import ua.training.model.text.IComponent;
import ua.training.model.text.composite.ICompositeElement;

import java.util.*;

/**
 * Class describes text processor. Counts words occurrences in sentences from text.
 * Implements {@link ITextProcessor} interface.
 *
 * @author Ivan Yakukhno
 */
public class TextProcessor implements ITextProcessor {

    /**
     * Text to parse.
     */
    private ICompositeElement text;

    /**
     * Parser to parse string values.
     */
    private IParser parser = new CompositeElementParser();

    /**
     * Returns map of words and their occurrences in each sentence.
     * @param requiredWords words to search in text
     * @return map of words and their occurrences
     */
    public Map<IComponent, List<Integer>> getWordsOccurrencesInEachSentence(String requiredWords) {
        Map<IComponent, List<Integer>> wordsOccurrencesInEachSentence = parseRequiredWords(requiredWords);
        List<IComponent> sentences = text.getComponents();
        for (IComponent wordFromList : wordsOccurrencesInEachSentence.keySet()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < sentences.size(); i++) {
                IComponent sentence = sentences.get(i);
                list.add(i, 0);
                if (sentence instanceof ICompositeElement) {
                    for (IComponent word
                            : ((ICompositeElement)sentence).getComponents()) {
                        if (word.equals(wordFromList)) {
                            list.set(i, list.get(i) + 1);
                        }
                    }
                }
            }
            wordsOccurrencesInEachSentence.put(wordFromList, list);
        }
        return wordsOccurrencesInEachSentence;
    }

    /**
     * Returns map of words and their occurrences in all sentences.
     * @param requiredWords words to search in text
     * @return map of words and their occurrences
     */
    public Map<IComponent, Integer> getWordsOccurrencesInAllSentences(String requiredWords) {
        Set<Map.Entry<IComponent, List<Integer>>> entrySet
                = getWordsOccurrencesInEachSentence(requiredWords).entrySet();
        Map<IComponent, Integer> wordsOccurrencesInAllSentences = new HashMap<>();
        for (Map.Entry<IComponent, List<Integer>> entry : entrySet) {
            wordsOccurrencesInAllSentences.put(entry.getKey(), entry.getValue()
                    .stream()
                    .reduce((s1, s2) -> (s1 + s2))
                    .orElse(0));
        }
        return wordsOccurrencesInAllSentences;
    }

    /**
     * Sorts map using comparator.
     * @param wordsToSort map to sort
     * @param comparator sorting comparator
     * @return sorted map
     */
    public TreeMap<IComponent, Integer> sortWords(
            Map<IComponent, Integer> wordsToSort,
            Comparator<IComponent> comparator) {
        TreeMap<IComponent, Integer> sortedMap = new TreeMap<>(comparator);
        sortedMap.putAll(wordsToSort);
        return sortedMap;
    }

    /**
     * Returns comparator, which compare {@link IComponent} objects by values.
     * @return comparator, which compare {@link IComponent} objects by values
     */
    public Comparator<IComponent> wordsByOccurrencesComparator(Map<IComponent, Integer> map) {
        return Comparator.comparing(map::get);
    }

    /**
     * Parses required words and put them in wordsOccurrencesInEachSentence map.
     * @param requiredWords string presentation of required words to search
     */
    Map<IComponent, List<Integer>> parseRequiredWords(String requiredWords) {
        Map<IComponent, List<Integer>> wordsOccurrencesInEachSentence
                = new HashMap<>();
        ICompositeElement sentence = parser.parseSentence(requiredWords + " ");
        for (IComponent component : sentence.getComponents()) {
            wordsOccurrencesInEachSentence.put(component, null);
        }
        return wordsOccurrencesInEachSentence;
    }

    //getters & setters

    public ICompositeElement getText() {
        return text;
    }

    public void setText(String text) {
        this.text = parser.parseText(text);
    }

    @Override
    public void setText(ICompositeElement text) {
        this.text = text;
    }

    public IParser getParser() {
        return parser;
    }

    public void setParser(IParser parser) {
        this.parser = parser;
    }

}
