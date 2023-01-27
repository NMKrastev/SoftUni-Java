
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

    //Checks if the list is empty
    private boolean isEmpty() {
        return this.size == 0;
    }

}
