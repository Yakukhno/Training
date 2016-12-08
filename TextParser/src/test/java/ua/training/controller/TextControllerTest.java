//package ua.training.controller;
//
//import org.junit.Test;
//import ua.training.model.io.reader.IStringReader;
//import ua.training.model.io.writer.IStringWriter;
//import ua.training.model.text.IComponent;
//import ua.training.model.text.parser.ITextProcessor;
//import ua.training.view.IView;
//
//import java.util.Comparator;
//
//import static org.mockito.Mockito.*;
//
//public class TextControllerTest {
//
//    private TextController controller;
//
//    @Test
//    public void testExecute() {
//        IView view = mock(IView.class);
//        IStringReader textReader = mock(IStringReader.class);
//        IStringReader wordsReader = mock(IStringReader.class);
//        ITextProcessor wordsParser = mock(ITextProcessor.class);
//        Comparator comparator = mock(Comparator.class);
//
//        when(wordsParser.wordsByOccurrencesComparator()).thenReturn(comparator);
//        when(wordsParser.getText()).thenReturn(mock(IComponent.class));
//
//        controller = new TextController(view, textReader, wordsReader);
//        controller.setParser(wordsParser);
//
//        controller.execute();
//
//        verify(wordsParser).parse();
//        verify(view, atLeast(2)).showMessage(anyString());
//    }
//
//}
