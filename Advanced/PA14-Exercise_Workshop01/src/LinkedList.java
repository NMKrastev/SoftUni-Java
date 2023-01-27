import java.util.function.Consumer;

public class LinkedList {

    private static class Node {

        private int element;
        private Node next;

        private Node(int element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return element + "";
        }
    }

    private Node head;
    private int size;

    //Create node; Make newNode the head; Increase the size of the list;
    public void addFirst(int element) {
        Node newNode = new Node(element);
        //Checks if list is empty and if not makes the new node head of the list
        if (!isEmpty()) {
            newNode.next = head;
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
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
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
        return firstElement;
    }

    //Removes last(Tail) element of the list
    public int removeLast() {
        if (size < 2) {
            return removeFirst();
        }
        Node currentNode = head;
        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }
        int lastElement = currentNode.next.element;
        currentNode.next = null;
        size--;
        return lastElement;
    }

    //Gets element on the searched index
    public int get(int index) {
        checkIndex(index);
        int getElement = 0;
        int counter = 0;
        Node currentNode = head;
        while (counter < index) {
            currentNode = currentNode.next;
            counter++;
        }
        return currentNode.element;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node currentNode = head;
        while (currentNode != null) {
            consumer.accept(currentNode.element);
            currentNode = currentNode.next;
        }
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
