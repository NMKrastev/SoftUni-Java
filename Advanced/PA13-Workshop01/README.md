# Workshop custom data structures

## Overview </br>

### In this workshop, we will create our own custom data structures – a custom list (SmartArray) and a custom stack.
</br>

1. SmartArray

   * The SmartArray will have similar functionality to Java ArrayList that you've used before. 
Our SmartArray will work only with integers for now, but after the Generics lecture from this course, 
you can try to change that and make the structure generic, which means it will be able to work with any type. 
It will have the following functionality:</br>
     * ```void add(int element)``` - Adds the given element to the end of the list</br>
     * ```int get(int index)``` - Returns the element at the specified position in this list</br>
     * ```int remove(int index)``` - Removes the element at the given index</br>
     * ```boolean contains(int element)``` - Checks if the list contains the given element returns (True or False)</br>
     * ```void add(int firstIndex, int secondIndex)``` - Adds element at the specific index, the element at this index gets shifted to the right alongside any following elements, increasing the size</br>
     * ```void forEach(Consumer<Integer> consumer)``` - Goes through each one of the elements in the list</br>
   * Additional functionality:
     * ```int[] grow()``` - Each time the size reaches the length it grows twice the size.</br>
     * ```int size()``` - Returns the size of the list</br>
     * ```void isIndexInBounds(int index)``` - Returns IndexOutOfBoundsException if the index is not in the list boundaries</br>
     * ```int[] shrink()``` - Shrinks the list to double its size each time the size equals the length divided by 4</br>
</br>
     
2. Custom Stack</br>

   * The custom stack will also have similar functionality to the Java ArrayDeque and again, 
   we will make it work only with integers. Later on, we will learn how to implement it in a way that will 
   allow us to work with any type. It will have the following functionality:</br>
     *	```void push(int element)``` – Adds the given element to the stack</br>
     *	```int pop()``` – Removes the last added element</br>
     *	```int peek()``` – Returns the last element in the stack without removing it</br>
     *	```void forEach(Consumer<Integer> consumer)``` – Goes through each of the elements in the stack</br>
   * Additional functionality:
     * ```int size()``` - Returns size of the stack