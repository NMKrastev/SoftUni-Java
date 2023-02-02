package A9_LinkedListTraversal;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

    private class LinkedListIterator implements Iterator<T> {

        private Node<T> currentNode = head;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            T element = currentNode.element;
            currentNode = currentNode.next;
            return element;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private static class Node<E> {

        private E element;
        private Node<E> next;
        private Node<E> prev;

        private Node(E element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return element + "";
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);
        if (!isEmpty()) {
            newNode.next = head;
            head.prev = newNode;
        } else {
            tail = newNode;
        }
        head = newNode;
        size++;
    }

    public void add(T element) {
        if (isEmpty()) {
            addFirst(element);
            return;
        }
        Node<T> newNode = new Node<>(element);
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove elements from an empty list!");
        }
        T firstElement = head.element;
        head = head.next;
        size--;
        if (size > 1) {
            head.prev = null;
        }
        if (isEmpty()) {
            head = null;
            tail = null;
        }
        return firstElement;
    }

    public boolean remove(T element) {
        if (size < 2) {
            return (boolean) removeFirst();
        }
        Node<T> currentElement = head;
        for (int i = 0; i < size; i++) {
            if (currentElement.element.equals(element)) {
                if (size - 1 == i) {
                    tail = currentElement.prev;
                    tail.next = null;
                }
                if (i == 0 && size > 2) {
                    head = currentElement.next;
                    head.prev = null;
                    head.next = currentElement.next.next;
                } else if (i == 0) {
                    head = currentElement.next;
                    head.prev = null;
                    head.next = null;
                }
                if (i != 0 && size - 1 != i) {
                    currentElement.prev.next = currentElement.next;
                    currentElement.next.prev = currentElement.prev;
                }
                size--;
                return true;
            }
            currentElement = currentElement.next;
        }
        return false;
    }

    public T get(int index) {
        checkIndex(index);
        int counter = 0;
        Node<T> currentNode;
        if (index > size / 2) {
            currentNode = tail;
            int lastIndex = size - 1;
            int countOfIterations = lastIndex - index;
            while (countOfIterations < size) {
                currentNode = currentNode.prev;
                countOfIterations++;
            }
        } else {
            currentNode = head;
            while (counter < index) {
                currentNode = currentNode.next;
                counter++;
            }
        }

        return currentNode.element;
    }

    public int getSize() {
        return size;
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("No such index in the list!");
        }
    }
}
