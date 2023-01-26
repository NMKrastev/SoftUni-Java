import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*Using add() method of SmartArray class*/
        //Doing for loop with 1000000 iterations takes between 25-29 milliseconds
        List<Integer> list = new ArrayList<>();
        long startTimeList = System.currentTimeMillis();
        for (int i = 1; i <= 5 ; i++) {
            list.add(i);
        }
        long endTimeList = System.currentTimeMillis();
        System.out.println(endTimeList - startTimeList);

        //Doing for loop with 1000000 iterations takes between 6-10 milliseconds
        SmartArray smartArray = new SmartArray();
        long startTimeArray = System.currentTimeMillis();
        for (int i = 1; i <= 5 ; i++) {
            smartArray.add(i);
        }
        long endTimeArray = System.currentTimeMillis();
        System.out.println(endTimeArray - startTimeArray);

        /*Using get() method of SmartArray class*/
        System.out.println(smartArray.get(5 - 1)); //returns 5
        //System.out.println(smartArray.get(5)); //returns IndexOutOfBoundsException
        /**If you want to use the code below make sure to comment the line above!*/

        /*Using size() method of SmartArray class*/
        System.out.println(smartArray.size()); //returns 5
        printArray(smartArray);  // returns [1, 2, 3, 4, 5]

        /*Using remove() method of SmartArray class*/
        System.out.println(smartArray.remove(2)); // returns 3
        printArray(smartArray);  // returns [1, 2, 4, 5]

        /*Using contains() method of SmartArray class*/
        System.out.println(smartArray.contains(2)); //returns true
        System.out.println(smartArray.contains(7)); //returns false

        /*Using add() method with element on curtain index of SmartArray class*/
        smartArray.add(2, 3); // ads element(number) 3 to index 2
        printArray(smartArray); // returns [1, 2, 3, 4, 5]

        /*Using forEach() method of SmartArray class*/
        smartArray.forEach(System.out::print); // returns [1, 2, 3, 4, 5]

    }

    private static void printArray(SmartArray smartArray) {
        for (int i = 0; i < smartArray.size(); i++) {
            System.out.print(smartArray.get(i));
        }
        System.out.println();
    }
}