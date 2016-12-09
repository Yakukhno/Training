package ua.training.model.text.parser;

import org.junit.Before;
import org.junit.Test;
import ua.training.model.text.IComponent;
import ua.training.model.text.composite.ICompositeElement;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TextProcessorTest {

    private TextProcessor textProcessor;
    private IParser parser = new CompositeElementParser();

    @Before
    public void before() {
        textProcessor = new TextProcessor();
    }

    @Test
    public void testGetWordsInSentences() {
        ICompositeElement text = mock(ICompositeElement.class);
        List<IComponent> list = new ArrayList<>(Arrays.asList(
                parser.parseSentence("Нас двое в комнате: собака моя и я."),
                parser.parseSentence("На дворе воет страшная, неистовая буря."),
                parser.parseSentence("Собака сидит передо мною — " +
                        "и смотрит мне прямо в глаза."),
                parser.parseSentence("И я тоже гляжу ей в глаза.")
        ));
        when(text.getComponents()).thenReturn(list);
        textProcessor.setText(text);

        Map<IComponent, List<Integer>> map = new HashMap<>();
        map.put(parser.parseWord("в"),
                new ArrayList<>(Arrays.asList(1, 0, 1, 1)));
        map.put(parser.parseWord("буря"),
                new ArrayList<>(Arrays.asList(0, 1, 0, 0)));
        map.put(parser.parseWord("она"),
                new ArrayList<>(Arrays.asList(0, 0, 0, 0)));

        Map<IComponent, List<Integer>> wordsOccurrencesInEachSentence = textProcessor
                .getWordsOccurrencesInEachSentence("в буря она");

        assertEquals(map, wordsOccurrencesInEachSentence);

        Map<IComponent, Integer> wordsOccurrencesInAllSentences = new HashMap<>();
        wordsOccurrencesInAllSentences.put(parser.parseWord("в"), 3);
        wordsOccurrencesInAllSentences.put(parser.parseWord("буря"), 1);
        wordsOccurrencesInAllSentences.put(parser.parseWord("она"), 0);

        assertEquals(wordsOccurrencesInAllSentences,
                textProcessor.getWordsOccurrencesInAllSentences("в буря она"));
    }

    @Test
    public void testSortWords() {
        Map<IComponent, Integer> wordsOccurrencesInAllSentences
                = new HashMap<>();
        IComponent mock1 = mock(IComponent.class);
        IComponent mock2 = mock(IComponent.class);
        IComponent mock3 = mock(IComponent.class);
        IComponent mock4 = mock(IComponent.class);
        wordsOccurrencesInAllSentences.put(mock1, 4);
        wordsOccurrencesInAllSentences.put(mock2, 1);
        wordsOccurrencesInAllSentences.put(mock3, 7);
        wordsOccurrencesInAllSentences.put(mock4, 0);

        TreeMap<IComponent, Integer> sortedMap =
                textProcessor.sortWords(wordsOccurrencesInAllSentences,
                        textProcessor.wordsByOccurrencesComparator(
                                wordsOccurrencesInAllSentences));
        boolean isSorted = true;
        Iterator<Integer> iterator = sortedMap.values().iterator();
        while (iterator.hasNext()) {
            int prev = iterator.next();
            if (iterator.hasNext()) {
                int next = iterator.next();
                if (prev > next) {
                    isSorted = false;
                }
            }
        }
        assertTrue(isSorted);
    }

    @Test
    public void testParseRequiredWords() {
        assertEquals(new HashSet<IComponent>(
                Arrays.asList(
                        parser.parseWord("bank"),
                        parser.parseWord("account"),
                        parser.parseWord("is"))),
                textProcessor.parseRequiredWords("bank  account    is").keySet());
    }

}
