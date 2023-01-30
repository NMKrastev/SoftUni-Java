package A3_GenericSwapMethodString;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<String> list = new Box<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            list.add(input);
        }

        int indexOne = scanner.nextInt();
        int indexTwo = scanner.nextInt();
        scanner.close();

        list.swapPlace(indexOne, indexTwo);
        System.out.println(list);
    }
}
/*Create a generic method that receives a list containing any type of data and swaps the elements at two given indexes.
As in the previous problems, read n number of boxes of type String and add them to the list. On the next line, however,
you will receive a swap command consisting of two indexes. Use the method you've created to swap the elements
corresponding to the given indexes and print each element in the list.
*/
