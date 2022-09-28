import java.util.Scanner;

public class A2_CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String lineOne = scanner.nextLine();
        String[] arrayOne = lineOne.split(" ");
        String lineTwo = scanner.nextLine();
        String[] arrayTwo = lineTwo.split(" ");

        for (int i = 0; i < arrayTwo.length; i++) {

            for (int j = 0; j < arrayOne.length; j++) {

                if(arrayTwo[i].equals(arrayOne[j])) {
                    System.out.print(arrayOne[j] + " ");
                }
            }
        }
    }
}
/*Write a program that prints common elements in two arrays.
You have to compare the elements of the second array to the elements of the first.*/