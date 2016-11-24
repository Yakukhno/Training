package ua.training;

import java.util.*;

public class MyLinkedList<T> implements List<T>, Deque<T> {

    private int size;
    private Node<T> first;
    private Node<T> last;

    private int modCount;

    public MyLinkedList(){}

    public MyLinkedList(Collection<? extends T> collection) {
        this();
        addAll(collection);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        Node<T> newNode = new Node<>(t);
        if (first == null) {
            first = last = newNode;
        } else {
            newNode.previous = last;
            last.next = newNode;
            last = newNode;
        }
        size++;
        modCount++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index != -1) {
            remove(index);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Objects.requireNonNull(c);
        c.forEach(this::add);
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        checkOutOfBounds(index);
        return getNode(index).item;
    }

    @Override
    public T set(int index, T element) {
        checkOutOfBounds(index);
        Node<T> node = getNode(index);
        T oldItem = node.item;
        node.item = element;
        return oldItem;
    }

    @Override
    public void add(int index, T element) {
        if (index != size) {
            checkOutOfBounds(index);
            Node<T> previousIndexNode = getNode(index);
            if (first.equals(previousIndexNode)) {
                Node<T> newNode = new Node<>(element, null, previousIndexNode);
                newNode.next.previous = newNode;
                first = newNode;
            } else {
                Node<T> newNode = new Node<>(element, previousIndexNode.previous,
                        previousIndexNode);
                newNode.previous.next = newNode;
                newNode.next.previous = newNode;
            }
            size++;
            modCount++;
        } else {
            add(element);
        }
    }

    @Override
    public T remove(int index) {
        checkOutOfBounds(index);
        Node<T> nodeToRemove = getNode(index);
        if (size != 1) {
            if (nodeToRemove.equals(first)) {
                first = nodeToRemove.next;
                first.previous = null;
            } else if (nodeToRemove.equals(last)) {
                last = nodeToRemove.previous;
                last.next = null;
            } else {
                nodeToRemove.previous.next = nodeToRemove.next;
                nodeToRemove.next.previous = nodeToRemove.previous;
            }
        } else {
            first = last = null;
        }
        size--;
        modCount++;
        return nodeToRemove.item;
    }

    @Override
    public int indexOf(Object o) {
        Node<T> node = first;
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                if (o != null) {
                    if (node.item.equals(o)) {
                        return i;
                    }
                } else {
                    if (node.item == null) {
                        return i;
                    }
                }
                node = node.next;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override
    public ListIterator<T> listIterator(final int index) {
        if (index != size) {
            checkOutOfBounds(index);
        }
        return new ListIterator<T>() {
            private int currentIndex = index;
            private Node<T> currentNode = getNode(index);
            private int initialMod = modCount;

            @Override
            public boolean hasNext() {
                return (currentIndex < size);
            }

            @Override
            public T next() {
                checkForComodification();
                if (hasNext()) {
                    T currentItem = currentNode.item;
                    currentNode = currentNode.next;
                    currentIndex++;
                    return currentItem;
                } else {
                    throw new NoSuchElementException();
                }
            }

            @Override
            public boolean hasPrevious() {
                return (currentIndex - 1 >= 0);
            }

            @Override
            public T previous() {
                checkForComodification();
                if (hasPrevious()) {
                    if (currentNode == null) {
                        currentNode = last;
                    } else {
                        currentNode = currentNode.previous;
                    }
                    currentIndex--;
                    return currentNode.item;
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
                checkForComodification();
                Node<T> nodeToRemove = currentNode.previous;
                if (nodeToRemove != null) {
                    if (nodeToRemove.equals(first)) {
                        nodeToRemove.next.previous = null;
                        first = nodeToRemove.next;
                    } else if (nodeToRemove.equals(last)) {
                        nodeToRemove.previous.next = null;
                        last = nodeToRemove.previous;
                    } else {
                        nodeToRemove.previous.next = nodeToRemove.next;
                        nodeToRemove.next.previous = nodeToRemove.previous;
                    }
                    size--;
                } else {
                    throw new IllegalStateException();
                }
            }

            @Override
            public void set(T t) {
                currentNode.item = t;
            }

            @Override
            public void add(T t) {
                checkForComodification();
                if (first.equals(currentNode)) {
                    Node<T> newNode = new Node<>(t, null, currentNode);
                    newNode.next.previous = newNode;
                    first = newNode;
                } else {
                    Node<T> newNode = new Node<>(t, currentNode.previous,
                            currentNode);
                    newNode.previous.next = newNode;
                    newNode.next.previous = newNode;
                }
                size++;
            }

            private void checkForComodification() {
                if (modCount != initialMod)
                    throw new ConcurrentModificationException();
            }
        };
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public void addFirst(T t) {
        Node<T> newNode = new Node<>(t);
        if (first == null) {
            first = last = newNode;
        } else {
            newNode.next = first;
            first.previous = newNode;
            first = newNode;
        }
        size++;
        modCount++;
    }

    @Override
    public void addLast(T t) {
        add(t);
    }

    @Override
    public boolean offerFirst(T t) {
        return false;
    }

    @Override
    public boolean offerLast(T t) {
        return false;
    }

    @Override
    public T removeFirst() {
        T removedElement = pollFirst();
        checkNullPointer();
        return removedElement;
    }

    @Override
    public T removeLast() {
        T removedElement = pollLast();
        checkNullPointer();
        return removedElement;
    }

    @Override
    public T pollFirst() {
        if (size != 0) {
            T removedItem = first.item;
            first.next.previous = null;
            first = first.next;
            size--;
            modCount++;
            return removedItem;
        } else {
            return null;
        }
    }

    @Override
    public T pollLast() {
        if (size != 0) {
            T removedItem = last.item;
            last.previous.next = null;
            last = last.previous;
            size--;
            modCount++;
            return removedItem;
        } else {
            return null;
        }
    }

    @Override
    public T getFirst() {
        checkNullPointer();
        return first.item;
    }

    @Override
    public T getLast() {
        checkNullPointer();
        return last.item;
    }

    @Override
    public T peekFirst() {
        return (first != null) ? first.item : null;
    }

    @Override
    public T peekLast() {
        return (last != null) ? last.item : null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean offer(T t) {
        return false;
    }

    @Override
    public T remove() {
        return removeFirst();
    }

    @Override
    public T poll() {
        return pollFirst();
    }

    @Override
    public T element() {
        return getFirst();
    }

    @Override
    public T peek() {
        return peekFirst();
    }

    @Override
    public void push(T t) {
        addFirst(t);
    }

    @Override
    public T pop() {
        return removeFirst();
    }

    @Override
    public Iterator<T> descendingIterator() {
        return null;
    }

    private Node<T> getNode(int index) {
        Node<T> node;
        if (index < size / 2) {
            node = first;
            for (int i = 0; i <= index; i++) {
                if (i == index) {
                    return node;
                }
                node = node.next;
            }
        } else if (index < size){
            node = last;
            for (int i = size - 1; i >= index; i--) {
                if (i == index) {
                    return node;
                }
                node = node.previous;
            }
        }
        return null;
    }

    private void checkOutOfBounds(int index) {
        if ((index < 0) || (index > size - 1)) {
            throw new ArrayIndexOutOfBoundsException("index = " + index
                    + " size = " + size);
        }
    }

    private void checkNullPointer() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
    }

    private class Node<T> {
        T item;
        Node<T> previous;
        Node<T> next;

        Node(T item) {
            this.item = item;
        }

        Node(T item, Node<T> previous, Node<T> next) {
            this.item = item;
            this.previous = previous;
            this.next = next;
        }
    }

}
