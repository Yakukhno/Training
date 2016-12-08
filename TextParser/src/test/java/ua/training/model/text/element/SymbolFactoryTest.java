package ua.training.model.text.element;

import org.junit.Test;
import ua.training.model.text.IComponent;

public class SymbolFactoryTest {

    @Test
    public void testGetSymbol() {
        IComponent component1 = SymbolFactory.getSymbol('a',
                Symbol.Type.LETTER);
        IComponent component2 = SymbolFactory.getSymbol(',',
                Symbol.Type.PUNCTUATION_MARK);
        IComponent component3 = SymbolFactory.getSymbol('a',
                Symbol.Type.LETTER);
        IComponent component4 = SymbolFactory.getSymbol(',',
                Symbol.Type.PUNCTUATION_MARK);

        assert component1 != component2;
        assert component1 == component3;
        assert component2 == component4;
    }

}
