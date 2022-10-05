import java.util.Scanner;

public class A1_IntegerOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOne = Integer.parseInt(scanner.nextLine());
        int numTwo = Integer.parseInt(scanner.nextLine());
        int numThree = Integer.parseInt(scanner.nextLine());
        int numFour = Integer.parseInt(scanner.nextLine());

        int result = ((numOne + numTwo) / numThree) * numFour;

        System.out.println(result);

        //System.out.printf("%d", ((numOne + numTwo) / numThree) * numFour);

    }
}
/*Read four integer numbers. Add first to the second, divide (integer)
the sum by the third number, and multiply the result by the fourth number.
Print the result.
Constraints:
· The four numbers from the input are in the range
[-2,147,483,648… 2,147,483,647].*/