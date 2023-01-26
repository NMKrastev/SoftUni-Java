import java.util.function.Consumer;
import java.util.stream.Collectors;

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
        getStackState();
        int value = top.element;
        top = top.previous;
        size--;
        return value;
    }

    //Returns the top element of the stack without removing it
    public int peek() {
        getStackState();
        return top.element;
    }

    // Implementing a forEach that returns the whole stack
    public void forEach(Consumer<Integer> consumer) {
        Node current = top;
        while (current != null) {
            consumer.accept(current.element);
            current = current.previous;
        }
    }

    // Returns stack size
    public int size() {
        return size;
    }
    private void getStackState() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty");
        }
    }
}
