import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LinkedList {

    private static class Node {

        private int element;
        private Node next;
        private Node prev;

        private Node(int element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return element + "";
        }
    }

    private Node head;
    private Node tail;
    private int size;

    //Create node; Make newNode the head; Increase the size of the list;
    public void addFirst(int element) {
        Node newNode = new Node(element);
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
    public void addLast(int element) {
        if (isEmpty()) {
            addFirst(element);
            return;
        }
        Node newNode = new Node(element);
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    //Removes first(Head) element of the list
    public int removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove elements from an empty list!");
        }
        int firstElement = head.element;
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
    public int removeLast() {
        if (size < 2) {
            return removeFirst();
        }
        int lastElement = tail.element;
        tail = tail.prev;
        tail.next = null;
        size--;
        return lastElement;
    }

    //Gets element on the searched index
    public int get(int index) {
        checkIndex(index);
        int counter = 0;
        Node currentNode;
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
    public void forEach(Consumer<Integer> consumer) {
        Node currentNode = head;
        while (currentNode != null) {
            consumer.accept(currentNode.element);
            currentNode = currentNode.next;
        }
    }

    //Creates arrays of ints and returns it
    public int[] toArray() {
        List<Integer> array = new ArrayList<>();
        forEach(array::add);
        return array.stream().mapToInt(e -> e).toArray();
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
