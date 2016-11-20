package ua.training;

import java.util.*;

public class MyArrayList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private int size;

    private Object[] data;

    public MyArrayList() {
        data = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        data = new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public boolean contains(Object o) {
        return false;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex;
            private int iteratorSize = size;

            @Override
            public boolean hasNext() {
                return (currentIndex < size);
            }

            @Override
            public E next() {
                if (hasNext()) {
                    return (E) data[currentIndex++];
                } else {
                    throw new NoSuchElementException();
                }
            }

            @Override
            public void remove() {
                if (!isSizeChanged()) {
                    MyArrayList.this.remove(currentIndex - 1);
                    iteratorSize--;
                    currentIndex--;
                } else {
                    throw new ConcurrentModificationException();
                }
            }

            private boolean isSizeChanged() {
                return size != iteratorSize;
            }
        };
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }

    public boolean add(E e) {
        checkCapacity();
        data[size++] = e;
        return true;
    }

    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(o)) {
                System.arraycopy(data, i + 1, data, i, size - i - 1);
                data[--size] = null;
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void clear() {
        for (int i = 0; i < size - 1; i++) {
            data[i] = null;
        }
        size = 0;
    }

    public E get(int index) {
        checkOutOfBounds(index);
        return (E) data[index];
    }

    public E set(int index, E element) {
        checkOutOfBounds(index);
        Object oldValue = data[index];
        data[index] = element;
        return (E) oldValue;
    }

    public void add(int index, E element) {
        if (index != size) {
            checkOutOfBounds(index);
        }
        checkCapacity();
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
    }

    public E remove(int index) {
        checkOutOfBounds(index);
        E oldElement = (E) data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null;
        return oldElement;
    }

    public void trimToSize() {
        data = Arrays.copyOf(data, size);
        System.out.println(data.length + " " + size);
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    public ListIterator<E> listIterator(final int index) {
        checkOutOfBounds(index);
        return new ListIterator<E>() {
            private int currentIndex = index;
            private int iteratorSize = size;

            @Override
            public boolean hasNext() {
                return (currentIndex < size);
            }

            @Override
            public E next() {
                if (hasNext()) {
                    return (E) data[currentIndex++];
                } else {
                    throw new NoSuchElementException();
                }
            }

            @Override
            public boolean hasPrevious() {
                return (currentIndex - 1 >= 0);
            }

            @Override
            public E previous() {
                if (hasPrevious()) {
                    return (E) data[--currentIndex];
                } else {
                    throw new NoSuchElementException();
                }
            }

            @Override
            public int nextIndex() {
                return currentIndex;
            }

            @Override
            public int previousIndex() {
                return currentIndex - 1;
            }

            @Override
            public void remove() {
                if (!isSizeChanged()) {
                    MyArrayList.this.remove(currentIndex - 1);
                    iteratorSize--;
                    currentIndex--;
                } else {
                    throw new ConcurrentModificationException();
                }
            }

            @Override
            public void set(E e) {
                MyArrayList.this.set(currentIndex - 1, e);
            }

            @Override
            public void add(E e) {
                if (!isSizeChanged()) {
                    MyArrayList.this.add(currentIndex, e);
                    iteratorSize++;
                    currentIndex++;
                } else {
                    throw new ConcurrentModificationException();
                }
            }

            private boolean isSizeChanged() {
                return size != iteratorSize;
            }
        };
    }

    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    private void checkCapacity() {
        if (data.length == size) {
            increaseCapacity();
        }
    }

    private void increaseCapacity() {
        data = Arrays.copyOf(data, data.length * 3 / 2 + 1);
    }

    private void checkOutOfBounds(int index) {
        if ((index < 0) || (index > size - 1)) {
            throw new ArrayIndexOutOfBoundsException("index = " + index
                    + " size = " + size);
        }
    }
}
