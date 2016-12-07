package ua.training.model.text.parser;

import ua.training.model.text.IComponent;
import ua.training.model.text.composite.Sentence;
import ua.training.model.text.composite.Text;

import java.util.*;

/**
 * Class describes words parser. Counts words occurrences in sentences from text.
 * Implements {@link IWordsParser} interface.
 *
 * @author Ivan Yakukhno
 */
public class WordsParserImpl implements IWordsParser {

    /**
     * Text to parse.
     */
    private IComponent text;

    /**
     * Map, which contains words and their occurrences in each sentence.
     */
    private Map<IComponent, List<Integer>> wordsOccurrencesInEachSentence
            = new HashMap<>();

    /**
     * Map, which contains words and their occurrences in all sentences.
     */
    private Map<IComponent, Integer> wordsOccurrencesInAllSentences
            = new HashMap<>();

    /**
     * Constructor. Creates {@link Text} object from string text.
     * Invokes method for parsing required words.
     * @param text string presentation of text in which required words searches.
     * @param requiredWords string presentation of required words to search
     */
    public WordsParserImpl(String text, String requiredWords) {
        this.text = new Text(text);
        parseRequiredWords(requiredWords);
    }

    /**
     * Parses text and count words occurrences in sentences.
     */
    @Override
    public void parse() {
        text.parse();
        countWordsInEachSentence();
        countWordsInAllSentences();
    }

    /**
     * Counts words occurrences in each sentence from text and
     * put them in wordsOccurrencesInEachSentence map.
     */
    void countWordsInEachSentence() {
        List<IComponent> sentences = text.getComponents();
        for (IComponent wordFromList : wordsOccurrencesInEachSentence.keySet()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < sentences.size(); i++) {
                IComponent sentence = sentences.get(i);
                list.add(i, 0);
                for (IComponent word : sentence.getComponents()) {
                    if (word.equals(wordFromList)) {
                        list.set(i, list.get(i) + 1);
                    }
                }
            }
            wordsOccurrencesInEachSentence.put(wordFromList, list);
        }
    }

    /**
     * Counts words occurrences in all sentences from text
     * using wordsOccurrencesInEachSentence map.
     */
    void countWordsInAllSentences() {
        Set<Map.Entry<IComponent, List<Integer>>> entrySet
                = wordsOccurrencesInEachSentence.entrySet();
        for (Map.Entry<IComponent, List<Integer>> entry : entrySet) {
            wordsOccurrencesInAllSentences.put(entry.getKey(), entry.getValue()
                    .stream()
                    .reduce((s1, s2) -> (s1 + s2))
                    .orElse(0));
        }
    }

    /**
     * Parses required words and put them in wordsOccurrencesInEachSentence map.
     * @param requiredWords string presentation of required words to search
     */
    void parseRequiredWords(String requiredWords) {
        IComponent sentence = new Sentence(requiredWords + " ");
        sentence.parse();
        for (IComponent component : sentence.getComponents()) {
            wordsOccurrencesInEachSentence.put(component, null);
        }
    }

    /**
     * Sorts words using comparator.
     * @return sorted map of words and their occurrences
     */
    public TreeMap<IComponent, Integer> sortWords(Comparator<IComponent>
                                                          comparator) {
        TreeMap<IComponent, Integer> sortedMap = new TreeMap<>(comparator);
        sortedMap.putAll(wordsOccurrencesInAllSentences);
        return sortedMap;
    }

    /**
     * Returns comparator, which compare words by occurrences.
     * @return comparator, which compare words by occurrences
     */
    public Comparator<IComponent> wordsByOccurrencesComparator() {
        return Comparator.comparing(o -> wordsOccurrencesInAllSentences.get(o));
    }

    public Map<IComponent, List<Integer>> getWordsOccurrencesInEachSentence() {
        return wordsOccurrencesInEachSentence;
    }

    public Map<IComponent, Integer> getWordsOccurrencesInAllSentences() {
        return wordsOccurrencesInAllSentences;
    }

    void setText(IComponent text) {
        this.text = text;
    }

    void setWordsOccurrencesInEachSentence(Map<IComponent,
            List<Integer>> wordsOccurrencesInEachSentence) {
        this.wordsOccurrencesInEachSentence = wordsOccurrencesInEachSentence;
    }

    void setWordsOccurrencesInAllSentences(Map<IComponent,
            Integer> wordsOccurrencesInAllSentences) {
        this.wordsOccurrencesInAllSentences = wordsOccurrencesInAllSentences;
    }
}
