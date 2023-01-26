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

    //Adds element to the top of the stack
    public void push(int element) {
        Node newNode = new Node(element);
        newNode.previous = top;
        top = newNode;
        size++;
    }

    //Removes the top element of the stack
    public int pop() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty");
        }
        int value = top.element;
        top = top.previous;
        size--;
        return value;
    }

}
