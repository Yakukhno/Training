package ua.training;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

public class ListTest {

    private List<String> list;

    @Before
    public void before() {
        list = new MyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
    }

    @Test
    public void testSize() {
        assertEquals(list.size(), 4);
        list.add("e");
        list.add("f");
        assertEquals(list.size(), 6);
        list.remove(2);
        assertEquals(list.size(), 5);
    }

    @Test
    public void testIsEmpty() {
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIndexOf() {
        assertEquals(list.indexOf("a"), 0);
        assertEquals(list.indexOf("d"), 3);
        assertEquals(list.indexOf("t"), -1);
    }

    @Test
    public void testIndexAdd() {
        list.add(4, "t");
        assertEquals(list.size(), 5);
        assertEquals(list.get(4), "t");
        list.add(0, "u");
        assertEquals(list.get(0), "u");
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testIndexAddBounds() {
        list.add(5, "t");
    }

    @Test
    public void testObjectAdd() {
        assertTrue(list.add("t"));
        assertEquals(list.size(), 5);
        assertEquals(list.get(list.size() - 1), "t");

        list.clear();
        list.add("t");
        assertEquals(list.get(0), "t");
        assertEquals(list.size(), 1);
    }

    @Test
    public void testIndexRemove() {
        assertEquals(list.remove(0), "a");
        assertEquals(list.size(), 3);
        assertEquals(list.remove(2), "d");
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testIndexRemoveBounds() {
        list.remove(-1);
    }

    @Test
    public void testObjectRemove() {
        assertTrue(list.remove("a"));
        assertEquals(list.size(), 3);
        assertTrue(list.remove("d"));
        assertFalse(list.remove("t"));
    }

    @Test
    public void testClear() {
        list.clear();
        assertEquals(list.size(), 0);
    }

    @Test
    public void testGet() {
        assertEquals(list.get(0), "a");
        assertEquals(list.get(2), "c");
        assertEquals(list.get(3), "d");
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetBounds() {
        list.get(4);
    }

    @Test
    public void testSet() {
        assertEquals(list.set(0, "t"), "a");
        assertEquals(list.get(0), "t");
        assertEquals(list.set(3, "u"), "d");
        assertEquals(list.get(3), "u");
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testSetBounds() {
        list.set(4, "t");
    }

    @Test
    @Ignore
    public void testIteratorNext() {
        Iterator<String> iterator = list.iterator();
        assertEquals(iterator.next(), "a");
        iterator.next();
        iterator.next();
        assertEquals(iterator.next(), "d");
        iterator.next();
    }

    @Test
    @Ignore
    public void testIteratorHasNext() {
        Iterator<String> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        for (int i = 0; i < 4; i++) {
            iterator.next();
        }
        assertFalse(iterator.hasNext());
    }

    @Test
    @Ignore
    public void testIteratorRemove() {
        Iterator<String> iterator = list.iterator();
        iterator.next();
        iterator.next();
        iterator.remove();
        assertEquals(list.size(), 3);
        assertEquals(list.get(1), "c");
    }

    @Test(expected = ConcurrentModificationException.class)
    @Ignore
    public void testIteratorModificationException() {
        Iterator<String> iterator = list.iterator();
        iterator.next();
        list.add(1, "t");
        iterator.remove();
    }

    @Test
    public void testListIteratorNext() {
        ListIterator<String> iterator = list.listIterator();
        assertEquals(iterator.next(), "a");
        iterator.next();
        iterator.next();
        assertEquals(iterator.next(), "d");
    }

    @Test(expected = NoSuchElementException.class)
    public void testListIteratorNextException() {
        ListIterator<String> iterator = list.listIterator(4);
        iterator.next();
    }

    @Test
    public void testListIteratorPrevious() {
        ListIterator<String> iterator = list.listIterator(4);
        assertEquals(iterator.previous(), "d");
        iterator.previous();
        iterator.previous();
        assertEquals(iterator.previous(), "a");
    }

    @Test(expected = NoSuchElementException.class)
    public void testListIteratorPreviousException() {
        ListIterator<String> iterator = list.listIterator(0);
        iterator.previous();
    }

    @Test
    public void testListIteratorAdd() {
        ListIterator<String> iterator = list.listIterator();
        iterator.add("t");
        assertEquals(iterator.next(), "a");
        iterator.next();
        iterator.next();
        assertEquals(iterator.next(), "d");
    }

    @Test
    public void testListIteratorRemove() {
        ListIterator<String> iterator = list.listIterator();
        iterator.next();
        iterator.next();
        iterator.remove();
        iterator.remove();
        assertEquals(list.size(), 2);
        assertEquals(list.get(0), "c");
    }

    @Test(expected = ConcurrentModificationException.class)
    public void testListConcurrentModException() {
        ListIterator<String> iterator = list.listIterator();
        iterator.next();
        iterator.next();
        list.remove(0);
        iterator.next();
    }

}
