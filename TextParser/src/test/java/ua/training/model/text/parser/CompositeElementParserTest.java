package ua.training.model.text.parser;

import org.junit.Before;
import org.junit.Test;
import ua.training.model.text.IComponent;
import ua.training.model.text.composite.ICompositeElement;
import ua.training.model.text.element.Symbol;
import ua.training.model.text.element.SymbolFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CompositeElementParserTest {

    private CompositeElementParser parser;

    @Before
    public void before() {
        parser = new CompositeElementParser();
    }

    @Test
    public void testParseSentence() {
        ICompositeElement sentence = parser
                .parseSentence("И я тоже, гляжу ей в глаза!..");

        List<IComponent> list = new ArrayList<>();
        list.add(parser.parseWord("И"));
        list.add(parser.parseWord(("я")));
        list.add(parser.parseWord(("тоже")));
        list.add(SymbolFactory.getSymbol(',', Symbol.Type.PUNCTUATION_MARK));
        list.add(parser.parseWord(("гляжу")));
        list.add(parser.parseWord(("ей")));
        list.add(parser.parseWord(("в")));
        list.add(parser.parseWord(("глаза")));
        list.add(SymbolFactory.getSymbol('!', Symbol.Type.PUNCTUATION_MARK));
        list.add(SymbolFactory.getSymbol('.', Symbol.Type.PUNCTUATION_MARK));
        list.add(SymbolFactory.getSymbol('.', Symbol.Type.PUNCTUATION_MARK));

        assertEquals(list, sentence.getComponents());
    }

    @Test
    public void testParseWord() {
        ICompositeElement word = parser.parseWord("Аб'я");

        List<IComponent> list = new ArrayList<>();
        list.add(SymbolFactory.getSymbol('А', Symbol.Type.LETTER));
        list.add(SymbolFactory.getSymbol('б', Symbol.Type.LETTER));
        list.add(SymbolFactory.getSymbol('\'', Symbol.Type.PUNCTUATION_MARK));
        list.add(SymbolFactory.getSymbol('я', Symbol.Type.LETTER));

        assertEquals(list, word.getComponents());
    }


    @Test
    public void testParseNumber() {
        ICompositeElement number = parser.parseNumber("3.14");

        List<IComponent> list = new ArrayList<>();
        list.add(SymbolFactory.getSymbol('3', Symbol.Type.DIGIT));
        list.add(SymbolFactory.getSymbol('.', Symbol.Type.PUNCTUATION_MARK));
        list.add(SymbolFactory.getSymbol('1', Symbol.Type.DIGIT));
        list.add(SymbolFactory.getSymbol('4', Symbol.Type.DIGIT));

        assertEquals(list, number.getComponents());
    }
}
