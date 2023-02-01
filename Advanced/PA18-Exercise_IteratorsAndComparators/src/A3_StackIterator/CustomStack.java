package A3_StackIterator;

import java.util.Iterator;

public class CustomStack<T> implements Iterable<T> {

    private class StackIterator implements Iterator<T> {

        private Node<T> currentNode = top;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            T element = currentNode.element;
            currentNode = currentNode.previous;
            return element;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private static class Node<E> {

        private E element;
        private Node<E> previous;

        private Node(E element) {
            this.element = element;
        }
    }

    private Node<T> top;
    private int size;

    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.previous = top;
        top = newNode;
        size++;
    }

    public T pop() {
        getStackState();
        T value = top.element;
        top = top.previous;
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    private void getStackState() {
        if (top == null) {
            throw new IllegalArgumentException("Stack is empty");
        }
    }
}