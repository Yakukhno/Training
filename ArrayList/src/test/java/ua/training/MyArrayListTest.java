package ua.training;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class MyArrayListTest {

    List<String> list;

    @Before
    public void before() {
        list = new MyArrayList<>();
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
    public void testIndexAdd() {
        list.add(4, "t");
        assertEquals(list.size(), 5);
        assertEquals(list.get(4), "t");
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
    }

    @Test
    public void testIndexRemove() {
        assertEquals(list.remove(1), "b");
        assertEquals(list.size(), 3);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testIndexRemoveBounds() {
        list.remove(-1);
    }

    @Test
    public void testClear() {
        list.clear();
        assertEquals(list.size(), 0);
    }

    @Test
    public void testGet() {
        assertEquals(list.get(2), "c");
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetBounds() {
        list.get(4);
    }

    @Test
    public void testSet() {
        assertEquals(list.set(2, "t"), "c");
        assertEquals(list.get(2), "t");
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNext() {
        Iterator<String> iterator = list.iterator();
        assertEquals(iterator.next(), "a");
        iterator.next();
        iterator.next();
        assertEquals(iterator.next(), "d");
        iterator.next();
    }

    @Test
    public void testIteratorHasNext() {
        Iterator<String> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        for (int i = 0; i < 4; i++) {
            iterator.next();
        }
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testIteratorRemove() {
        Iterator<String> iterator = list.iterator();
        iterator.next();
        iterator.next();
        iterator.remove();
        assertEquals(list.size(), 3);
        assertEquals(list.get(1), "c");
    }

    @Test(expected = ConcurrentModificationException.class)
    public void testIteratorModificationException() {
        Iterator<String> iterator = list.iterator();
        iterator.next();
        list.add(1, "t");
        iterator.remove();
    }

}
