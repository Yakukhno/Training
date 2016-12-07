package ua.training.model.text.parser;

import ua.training.model.text.IComponent;
import ua.training.model.text.composite.Sentence;
import ua.training.model.text.composite.Text;

import java.util.*;

public class WordsParserImpl implements IWordsParser {

    private IComponent text;

    private Map<IComponent, List<Integer>> wordsOccurrencesInEachSentence
            = new HashMap<>();
    private Map<IComponent, Integer> wordsOccurrencesInAllSentences
            = new HashMap<>();

    public WordsParserImpl(String text, String requiredWords) {
        this.text = new Text(text);
        parseRequiredWords(requiredWords);
    }

    @Override
    public void parse() {
        text.parse();
        countWordsInEachSentence();
        countWordsInAllSentences();
    }

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

    void parseRequiredWords(String requiredWords) {
        IComponent sentence = new Sentence(requiredWords + " ");
        sentence.parse();
        for (IComponent component : sentence.getComponents()) {
            wordsOccurrencesInEachSentence.put(component, null);
        }
    }

    public TreeMap<IComponent, Integer> sortWords(Comparator<IComponent>
                                                          comparator) {
        TreeMap<IComponent, Integer> sortedMap = new TreeMap<>(comparator);
        sortedMap.putAll(wordsOccurrencesInAllSentences);
        return sortedMap;
    }

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
