package ua.training.model.parser;

import ua.training.model.IComponent;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public interface IWordsParser extends IParser {

    Map<IComponent, List<Integer>> getWordsOccurrencesInEachSentence();
    Map<IComponent, Integer> getWordsOccurrencesInAllSentences();
    TreeMap<IComponent, Integer> sortWords(Comparator<IComponent> comparator);
    Comparator<IComponent> wordsByOccurrencesComparator();

}
