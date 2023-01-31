package A7_CustomList;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> list = new CustomList<>();
        String input;

        while (!(input = scanner.nextLine()).equals("END")) {
            String[] command = input.split("\\s+");
            switch (command[0]) {
                case "Add":
                    String elementToAdd = command[1];
                    list.add(elementToAdd);
                    break;
                case "Remove":
                    int index = Integer.parseInt(command[1]);
                    list.remove(index);
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Greater":
                    String elementToCompare = command[1];
                    System.out.println(list.countGreaterThan(elementToCompare));
                    break;
                case "Contains":
                    String containsElement = command[1];
                    System.out.println(list.contains(containsElement));
                    break;
                case "Swap":
                    int indexOne = Integer.parseInt(command[1]);
                    int indexTwo = Integer.parseInt(command[2]);
                    list.swapPlace(indexOne, indexTwo);
                    break;
                case "Print":
                    System.out.println(list);
                    break;
            }
        }
    }
}
/*Create a generic data structure that can store any type that can be compared. Implement functions:
•	void add(T element)
•	T remove(int index)
•	boolean contains(T element)
•	void swap(int index, int index)
•	int countGreaterThan(T element)
•	T getMax()
•	T getMin()
Create a command interpreter that reads commands and modifies the custom list that you have created. Implement the commands:
•	Add {element} - Adds the given element to the end of the list.
•	Remove {index} - Removes the element at the given index.
•	Contains {element} - Prints if the list contains the given element (true or false).
•	Swap {index1} {index2} - Swaps the elements at the given indexes.
•	Greater {element} - Counts the elements that are greater than the given element and prints their count
•	Max - Prints the maximum element in the list.
•	Min - Prints the minimum element in the list.
•	Print - Prints all elements in the list, each on a separate line.
•	END - stops the reading of commands.
*/
