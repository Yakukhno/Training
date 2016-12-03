package ua.training;

import java.util.*;

public class MyTreeSet<T extends Comparable> implements Set<T> {

    private Node rootNode;
    private int size;

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
        return findNode(rootNode, (T) o) != null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private List<Node> listInOrder = new ArrayList<>();
            {
                getList(rootNode);
            }
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    return listInOrder.get(index++).item;
                } else {
                    throw new NoSuchElementException();
                }
            }

            private void getList(Node node) {
                if (node.left != null) {
                    getList(node.left);
                }
                listInOrder.add(node);
                if (node.right != null) {
                    getList(node.right);
                }
            }

        };
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
        if (rootNode == null) {
            rootNode = new Node(t);
            size++;
            return true;
        } else {
            return findPositionAndAdd(rootNode, t);
        }
    }

    @Override
    public boolean remove(Object o) {
        Node nodeToRemove = findNode(rootNode, (T) o);
        if (nodeToRemove == null) {
            return false;
        }

        if (nodeToRemove == rootNode) {
            if (nodeToRemove.right != null) {
                nodeToRemove.right.parent = null;
                nodeToRemove.left.parent = findMinNode(nodeToRemove.right);
                nodeToRemove.right.left = nodeToRemove.left.parent;
                rootNode = nodeToRemove.right;
            } else {
                if (nodeToRemove.left != null) {

                } else {

                }
            }
        }

        if (nodeToRemove.right != null) {
            if (nodeToRemove.parent.left == nodeToRemove) {
                nodeToRemove.parent.left = nodeToRemove.right;
            } else if (nodeToRemove.parent.right == nodeToRemove){
                nodeToRemove.parent.right = nodeToRemove.right;
            }
            nodeToRemove.right.parent = nodeToRemove.parent;
            if (nodeToRemove.left != null) {
                nodeToRemove.left.parent = findMinNode(nodeToRemove.right);
                nodeToRemove.left.parent.left = nodeToRemove.left;
            }
        } else {
            if (nodeToRemove.parent.left == nodeToRemove) {
                nodeToRemove.parent.left = nodeToRemove.left;
            } else if (nodeToRemove.parent.right == nodeToRemove) {
                nodeToRemove.parent.right = nodeToRemove.left;
            }
            if (nodeToRemove.left != null) {
                nodeToRemove.left.parent = nodeToRemove.parent;
            }
        }
        size--;
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean isSetChanged = false;
        for (T item : c) {
            isSetChanged = add(item);
        }
        return isSetChanged;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        rootNode = null;
        size = 0;
    }

    private boolean findPositionAndAdd(Node node, T t) {
        Objects.requireNonNull(t);
        int comparingResult = node.item.compareTo(t);
        if (comparingResult > 0) {
            if (node.left == null) {
                node.left = new Node(t);
                node.left.parent = node;
                size++;
                return true;
            } else {
                return findPositionAndAdd(node.left, t);
            }
        } else if (comparingResult < 0) {
            if (node.right == null) {
                node.right = new Node(t);
                node.right.parent = node;
                size++;
                return true;
            } else {
                return findPositionAndAdd(node.right, t);
            }
        } else {
            return false;
        }
    }

    private Node findNode(Node node, T t) {
        int comparingResult = node.item.compareTo(t);
        if (comparingResult > 0) {
            if (node.left != null) {
                return findNode(node.left, t);
            } else {
                return null;
            }
        } else if (comparingResult < 0) {
            if (node.right != null) {
                return findNode(node.right, t);
            } else {
                return null;
            }
        } else {
            return node;
        }
    }

    private Node findMinNode(Node node) {
        Node smallestNode = node;
        if (node.left != null) {
            smallestNode = findMinNode(node.left);
        }
        return smallestNode;
    }

    private class Node {
        T item;
        Node left;
        Node right;
        Node parent;

        Node(T item) {
            this.item = item;
        }
    }


}
