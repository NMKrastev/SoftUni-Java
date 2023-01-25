public class SmartArray {

    private int[] data;
    private int size;

    public SmartArray() {
        this.data = new int[8];
        this.size = 0;
    }

    public void add(int element) {
        if (size == data.length) {
            data = grow();
        }
        data[size++] = element;
    }

    private int[] grow() {
        //Optimizes the time for method add()
        int newLength = data.length * 2;

        int[] newData = new int[newLength];

        //Also optimizes the time needed for adding element to the array
        //Instead of a for loop it uses System.arraycopy
        System.arraycopy(data, 0, newData, 0, data.length);

        return newData;
    }

    public int get(int index) {
        isIndexInBounds(index);
        return data[index];
    }

    public int remove(int index) {
        int removedElement = get(index);
        //Optimizes the time needed for removing an element from the array
        if (size - 1 - index >= 0) System.arraycopy(data, index + 1, data, index, size - 1 - index);
        data[size - 1] = 0;
        size--;
        return removedElement;
    }


    public int size() {
        return size;
    }

    private void isIndexInBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
    }
}
/*In this workshop, we will create our own custom data structures – a custom list (SmartArray) and a custom stack.
The SmartArray will have similar functionality to Java ArrayList that you've used before.
Our SmartArray will work only with integers for now, but after the Generics lecture from this course,
you can try to change that and make the structure generic, which means it will be able to work with any type.
It will have the following functionality:
•	void add(int element) - Adds the given element to the end of the list
•	int get(int index) - Returns the element at the specified position in this list
•	int remove(int index) - Removes the element at the given index
•	bool contains(int element) - Checks if the list contains the given element returns (True or False)
•	void add(int firstIndex, int secondIndex) - Adds element at the specific index, the element at this index gets
shifted to the right alongside any following elements, increasing the size
•	void forEach(Consumer<Integer> consumer) - Goes through each one of the elements in the list
Feel free to implement your functionality or to write the methods by yourself.
*/