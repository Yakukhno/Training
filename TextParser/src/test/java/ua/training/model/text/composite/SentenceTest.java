package ua.training.model.text.composite;

import org.junit.Before;
import org.junit.Test;
import ua.training.model.text.IComponent;
import ua.training.model.text.element.Symbol;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SentenceTest {

    private Sentence sentence;

    @Before
    public void before() {
        sentence = new Sentence("И я тоже, гляжу ей в глаза!..");
    }

    @Test
    public void testParse() {
        sentence.parse();

        List<IComponent> list = new ArrayList<>();
        list.add(new Word("И"));
        list.add(new Word("я"));
        list.add(new Word("тоже"));
        list.add(new Symbol(',', Symbol.Type.PUNCTUATION_MARK));
        list.add(new Word("гляжу"));
        list.add(new Word("ей"));
        list.add(new Word("в"));
        list.add(new Word("глаза"));
        list.add(new Symbol('!', Symbol.Type.PUNCTUATION_MARK));
        list.add(new Symbol('.', Symbol.Type.PUNCTUATION_MARK));
        list.add(new Symbol('.', Symbol.Type.PUNCTUATION_MARK));

        assertEquals(list, sentence.getComponents());
    }

    @Test
    public void testParseComponents() {
        sentence = new Sentence("");

        sentence.components.add(mock(IComponent.class));
        sentence.components.add(mock(IComponent.class));
        sentence.components.add(mock(IComponent.class));

        sentence.parse();

        for (IComponent component : sentence.getComponents()) {
            verify(component).parse();
        }
    }

    @Test
    public void testAddMethods() {
        sentence.components = mock(List.class);
        sentence.addWord("abc");
        sentence.addNumber("24");
        sentence.addPunctuationMark(',');
        verify(sentence.components, times(3)).add(any(IComponent.class));
    }

}
