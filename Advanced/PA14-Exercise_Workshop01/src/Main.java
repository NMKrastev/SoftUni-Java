public class Main {
    public static void main(String[] args) {

        /*Using addFirst() method*/
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(3); // Ads number 3 to the head of the list
        linkedList.addFirst(2); // Ads number 2 to the head of the list
        linkedList.addFirst(1); // Ads number 1 to the head of the list

    }
}
/*In this workshop, we are going to create another custom data structure, which has similar functionalities as the
Java LinkedList. Just like the structures from the previous workshop, our custom LinkedList will work only with integers.
It will have the following functionalities:
•	void addFirst(int element) – adds an element at the beginning of the collection
•	void addLast(int element) – adds an element at the end of the collection
•	int get(int index) - Returns the element at the specified position in this list
•	int removeFirst() – removes the element at the beginning of the collection
•	int removeLast() – removes the element at the end of the collection
•	void forEach() – goes through the collection and executes a given action
•	int[] toArray() – returns the collection as an array
Feel free to implement your functionality or to write the methods by yourself.
*/
