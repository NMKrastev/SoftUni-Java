import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LinkedList<T> {

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

    //Create node; Make newNode the head; Increase the size of the list;
    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);
        //Checks if list is empty and if not makes the new node head of the list
        if (!isEmpty()) {
            newNode.next = head;
            head.prev = newNode;
        } else {
            tail = newNode;
        }
        head = newNode;
        size++;
    }

    //Adds an element to back of the list
    public void addLast(T element) {
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

    //Removes first(Head) element of the list
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

    //Removes last(Tail) element of the list
    public T removeLast() {
        if (size < 2) {
            return removeFirst();
        }
        T lastElement = tail.element;
        tail = tail.prev;
        tail.next = null;
        size--;
        return lastElement;
    }

    //Gets element on the searched index
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

    //Iterates over the elements of the list
    public void forEach(Consumer<T> consumer) {
        Node<T> currentNode = head;
        while (currentNode != null) {
            consumer.accept(currentNode.element);
            currentNode = currentNode.next;
        }
    }

    //Creates arrays of ints and returns it
    public T[] toArray() {
        List<T> array = new ArrayList<>();
        forEach(array::add);
        Class<?> arrayType = array.getClass();
        Class<?> type = arrayType.getComponentType();
        if (type.equals(int.class)) {
            // TODO: 30.1.2023 г.
        }
        return null;
    }

    //Checks if the list is empty
    private boolean isEmpty() {
        return this.size == 0;
    }

    //Checks if the index is in bounds
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("No such index in the list!");
        }
    }
}
