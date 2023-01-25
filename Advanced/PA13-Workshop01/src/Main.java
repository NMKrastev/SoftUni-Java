import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*Using add() method of SmartArray class*/
        //Time for doing the loop is between 25-29 milliseconds
        //using for loop with 1000000 iterations
        List<Integer> list = new ArrayList<>();
        long startTimeList = System.currentTimeMillis();
        for (int i = 1; i <= 1000000 ; i++) {
            list.add(i);
        }
        long endTimeList = System.currentTimeMillis();
        System.out.println(endTimeList - startTimeList);

        //Time for doing the loop is between 6-10 milliseconds
        //using for loop with 1000000 iterations
        SmartArray smartArray = new SmartArray();
        long startTimeArray = System.currentTimeMillis();
        for (int i = 1; i <= 1000000 ; i++) {
            smartArray.add(i);
        }
        long endTimeArray = System.currentTimeMillis();
        System.out.println(endTimeArray - startTimeArray);

        /*Using get() method of SmartArray class*/
        System.out.println(smartArray.get(1000000 - 1)); //returns 1000000
        System.out.println(smartArray.get(1000000)); //returns IndexOutOfBoundsException
        //If you want to use the code below make sure to comment the line above!

        /*Using size() method of SmartArray class*/
        System.out.println(smartArray.size()); //returns 1000000
    }
}