package ua.training.controller;

import org.junit.Test;
import ua.training.model.io.reader.IStringReader;
import ua.training.model.io.writer.IStringWriter;
import ua.training.model.text.IComponent;
import ua.training.model.text.parser.ITextProcessor;
import ua.training.view.IView;

import java.util.Comparator;
import java.util.Map;

import static org.mockito.Mockito.*;

public class TextControllerTest {

    private TextController controller;

    @Test
    public void testExecute() {
        IView view = mock(IView.class);
        IStringReader textReader = mock(IStringReader.class);
        IStringReader wordsReader = mock(IStringReader.class);
        ITextProcessor textProcessor = mock(ITextProcessor.class);
        Comparator comparator = mock(Comparator.class);

        when(textProcessor.wordsByOccurrencesComparator(anyMap()))
                .thenReturn(comparator);
        when(textReader.getString()).thenReturn("test 1");
        when(textProcessor.getText()).thenReturn(mock(IComponent.class));
        when(wordsReader.getString()).thenReturn("test 2");

        controller = new TextController(view, textReader, wordsReader);
        controller.setTextProcessor(textProcessor);

        controller.execute();

        verify(textProcessor).getWordsOccurrencesInEachSentence(wordsReader
                .getString());
        verify(textProcessor).getWordsOccurrencesInAllSentences(wordsReader
                .getString());
        verify(textProcessor).sortWords(textProcessor
                .getWordsOccurrencesInAllSentences(wordsReader.getString()),
                comparator);
        verify(view, atLeast(2)).showMessage(anyString());
    }

}
