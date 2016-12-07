package ua.training.model.text.parser;

import org.junit.Before;
import org.junit.Test;
import ua.training.model.text.IComponent;
import ua.training.model.text.composite.Sentence;
import ua.training.model.text.composite.Text;
import ua.training.model.text.composite.Word;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestWordsParser {

    private WordsParserImpl wordsParser;

    @Before
    public void before() {
        wordsParser = new WordsParserImpl("", "");
    }

    @Test
    public void testParse() {
        IComponent text = mock(Text.class);
        wordsParser.setText(text);
        wordsParser.parse();
        verify(text).parse();
    }

    @Test
    public void testCountWordsInEachSentence() {
        IComponent text = mock(IComponent.class);
        List<IComponent> list = new ArrayList<>(Arrays.asList(
                new Sentence("Нас двое в комнате: собака моя и я."),
                new Sentence("На дворе воет страшная, неистовая буря."),
                new Sentence("Собака сидит передо мною — " +
                        "и смотрит мне прямо в глаза."),
                new Sentence("И я тоже гляжу ей в глаза.")
        ));
        list.forEach(IComponent::parse);
        when(text.getComponents()).thenReturn(list);
        wordsParser.setText(text);

        Map<IComponent, List<Integer>> wordsOccurrencesInEachSentence
                = mock(Map.class);

        IComponent word1 = new Word("в");
        IComponent word2 = new Word("буря");
        IComponent word3 = new Word("она");
        Set<IComponent> set = new HashSet<>(Arrays.asList(word1, word2, word3));
        when(wordsOccurrencesInEachSentence.keySet()).thenReturn(set);
        wordsParser.setWordsOccurrencesInEachSentence(
                wordsOccurrencesInEachSentence);

        wordsParser.countWordsInEachSentence();

        verify(wordsOccurrencesInEachSentence).put(word1,
                new ArrayList<>(Arrays.asList(1, 0, 1, 1)));
        verify(wordsOccurrencesInEachSentence).put(word2,
                new ArrayList<>(Arrays.asList(0, 1, 0, 0)));
        verify(wordsOccurrencesInEachSentence).put(word3,
                new ArrayList<>(Arrays.asList(0, 0, 0, 0)));
    }

    @Test
    public void testCountWordsInAllSentences() {
        Map<IComponent, List<Integer>> wordsOccurrencesInEachSentence =
                new HashMap<>();

        IComponent mock1 = mock(IComponent.class);
        IComponent mock2 = mock(IComponent.class);
        IComponent mock3 = mock(IComponent.class);

        wordsOccurrencesInEachSentence.put(mock1,
                new ArrayList<>(Arrays.asList(0,2,3,2)));
        wordsOccurrencesInEachSentence.put(mock2,
                new ArrayList<>(Arrays.asList(1,0,2,1)));
        wordsOccurrencesInEachSentence.put(mock3,
                new ArrayList<>(Arrays.asList(0,0,0,0)));
        wordsParser.setWordsOccurrencesInEachSentence(wordsOccurrencesInEachSentence);
        Map<IComponent, Integer> wordsOccurrencesInAllSentences
                = mock(Map.class);
        wordsParser.setWordsOccurrencesInAllSentences(wordsOccurrencesInAllSentences);

        wordsParser.countWordsInAllSentences();

        verify(wordsOccurrencesInAllSentences).put(mock1, 7);
        verify(wordsOccurrencesInAllSentences).put(mock2, 4);
        verify(wordsOccurrencesInAllSentences).put(mock3, 0);
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
        wordsParser.setWordsOccurrencesInAllSentences(wordsOccurrencesInAllSentences);

        TreeMap<IComponent, Integer> sortedMap =
                wordsParser.sortWords(wordsParser.wordsByOccurrencesComparator());
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
        wordsParser.parseRequiredWords("я тоже и");

        assertEquals(wordsParser.getWordsOccurrencesInEachSentence().keySet(),
                new HashSet<IComponent>(Arrays.asList(
                        new Word("я"),
                        new Word("тоже"),
                        new Word("и"))));
    }

}
