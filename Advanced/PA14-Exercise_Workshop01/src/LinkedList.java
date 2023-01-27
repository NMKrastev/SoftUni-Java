
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
