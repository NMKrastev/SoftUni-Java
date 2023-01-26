public class CustomStack {

    //Using Top-Down approach to track the elements in the Stack
    private static class Node {

        private int element;
        private Node previous;

        private Node (int element) {
            this.element = element;
        }
    }

    private Node top;
    private int size;

    public void push(int element) {
        Node newNode = new Node(element);
        newNode.previous = top;
        top = newNode;
        size++;
    }
}
