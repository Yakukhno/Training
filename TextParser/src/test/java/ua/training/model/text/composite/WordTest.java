package ua.training.model.text.composite;

import org.junit.Before;
import org.junit.Test;
import ua.training.model.text.IComponent;
import ua.training.model.text.symbol.Symbol;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class WordTest {

    private Word word;

    @Before
    public void before() {
        word = new Word("Аб'я");
    }

    @Test
    public void testParse() {
        word.parse();

        List<IComponent> list = new ArrayList<>();
        list.add(new Symbol('А', Symbol.Type.LETTER));
        list.add(new Symbol('б', Symbol.Type.LETTER));
        list.add(new Symbol('\'', Symbol.Type.PUNCTUATION_MARK));
        list.add(new Symbol('я', Symbol.Type.LETTER));

        assertEquals(list, word.getComponents());
    }

    @Test
    public void testAddMethods() {
        word.components = mock(List.class);
        word.addLetter('c');
        word.addLetter('п');
        word.addPunctuationMark('\'');
        verify(word.components, times(3)).add(any(Symbol.class));
    }

}
