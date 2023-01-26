import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /**
         * SmartArray Start
         */

        /**
         * SmartArray End
         */


        /**
         * CustomStack Start
         */
        /*Using push() method of CustomStack class*/
        //Pushes five elements in the stack
        CustomStack customStack = new CustomStack();
        customStack.push(1);
        customStack.push(2);
        customStack.push(3);
        customStack.push(4);
        customStack.push(5);

        /**
         * CustomStack End
         */

    }

    private static void printArray(SmartArray smartArray) {
        for (int i = 0; i < smartArray.size(); i++) {
            System.out.print(smartArray.get(i));
        }
        System.out.println();
    }
}