import java.util.function.Consumer;

public class CustomStack<T> {

    //Using Top-Down approach to track the elements in the Stack
    private class Node {

        private T element;
        private Node previous;

        private Node (T element) {
            this.element = element;
        }
    }

    private Node top;
    private int size;

    //Adds element to the top of the stack
    public void push(T element) {
        Node newNode = new Node(element);
        newNode.previous = top;
        top = newNode;
        size++;
    }

    //Removes the top element of the stack
    public T pop() {
        getStackState();
        T value = top.element;
        top = top.previous;
        size--;
        return value;
    }

    //Returns the top element of the stack without removing it
    public T peek() {
        getStackState();
        return top.element;
    }

    // Implementing a forEach that returns the whole stack
    public void forEach(Consumer<T> consumer) {
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
/*The custom stack will also have similar functionality to the Java ArrayDeque and again,
we will make it work only with integers. Later on, we will learn how to implement it in a way that will allow us
to work with any type. It will have the following functionality:
•	void push(int element) – Adds the given element to the stack
•	int pop() – Removes the last added element
•	int peek() – Returns the last element in the stack without removing it
•	void forEach(Consumer<Integer> consumer) – Goes through each of the elements in the stack
Feel free to implement your functionality or to write the methods by yourself.
*/