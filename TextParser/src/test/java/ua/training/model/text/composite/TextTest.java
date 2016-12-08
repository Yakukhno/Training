//package ua.training.model.text.composite;
//
//import org.junit.Before;
//import org.junit.Test;
//import ua.training.model.text.IComponent;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;
//
//public class TextTest {
//
//    private Text text;
//
//    @Before
//    public void before() {
//        text = new Text("Нас двое в комнате: собака моя и я." +
//                " На дворе воет страшная, неистовая буря.\n" + "\n" +
//                "Собака сидит передо мною — и смотрит мне прямо в глаза.");
//    }
//
//    @Test
//    public void testParse() {
//        text.parse();
//
//        List<IComponent> list = new ArrayList<>();
//        list.add(new Sentence("Нас двое в комнате: собака моя и я."));
//        list.add(new Sentence("На дворе воет страшная, неистовая буря."));
//        list.add(new Sentence("Собака сидит передо мною — " +
//                "и смотрит мне прямо в глаза."));
//
//        assertEquals(list, text.getComponents());
//    }
//
//    @Test
//    public void testParseComponents() {
//        text = new Text("");
//
//        text.components.add(mock(IComponent.class));
//        text.components.add(mock(IComponent.class));
//        text.components.add(mock(IComponent.class));
//
//        text.parse();
//
//        for (IComponent component : text.getComponents()) {
//            verify(component).parse();
//        }
//    }
//
//    @Test
//    public void testAddMethods() {
//        text.components = mock(List.class);
//        text.addSentence("abc.");
//        text.addSentence("cde?");
//        text.addSentence("fdf!");
//        text.addSentence("jkl, oiu?..");
//        verify(text.components, times(4)).add(any(IComponent.class));
//    }
//}
