package A9_CustomListIterator;

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
                    list.swap(indexOne, indexTwo);
                    break;
                case "Sort":
                    Sorter.sort(list);
                    break;
                case "Print":
                    //System.out.println(list);
                    list.forEach(System.out::println);
                    break;
            }
        }
    }
}
/*Extend the previous problem by creating an additional Sorter class.
It should have a single static method sort() which can sort objects of type CustomList
containing any type that can be compared. Extend the command list to support one additional command Sort:
•	Sort - Sort the elements in the list in ascending order.
*/
