package ua.training.model.text.composite;

import org.junit.Before;
import org.junit.Test;
import ua.training.model.text.IComponent;
import ua.training.model.text.symbol.Symbol;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class NumberTest {

    private Number number;

    @Before
    public void before() {
        number = new Number("3.14");
    }

    @Test
    public void testParse() {
        number.parse();

        List<IComponent> list = new ArrayList<>();
        list.add(new Symbol('3', Symbol.Type.DIGIT));
        list.add(new Symbol('.', Symbol.Type.PUNCTUATION_MARK));
        list.add(new Symbol('1', Symbol.Type.DIGIT));
        list.add(new Symbol('4', Symbol.Type.DIGIT));

        assertEquals(list, number.getComponents());
    }

    @Test
    public void testAddMethods() {
        number.components = mock(List.class);
        number.addDigit('4');
        number.addDigit('2');
        number.addPunctuationMark('.');
        verify(number.components, times(3)).add(any(Symbol.class));
    }

}
