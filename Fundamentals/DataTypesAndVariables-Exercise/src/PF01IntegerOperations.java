import java.util.Scanner;

public class PF01IntegerOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());
        int fourthNum = Integer.parseInt(scanner.nextLine());

        System.out.println(((firstNum + secondNum) / thirdNum) * fourthNum);
    }
}
/*Read four integer numbers. Add first to the second, divide (integer) the sum by the third number,
and multiply the result by the fourth number. Print the result.
Constraints
•	The four numbers from the input are in the range [-2,147,483,648… 2,147,483,647].
*/