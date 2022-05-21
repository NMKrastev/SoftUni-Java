import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOne = Integer.parseInt(scanner.nextLine());
        int numTwo = Integer.parseInt(scanner.nextLine());
        int magicNum = Integer.parseInt(scanner.nextLine());
        int result = 0, count = 0;
        boolean isFound = false;

        for (int i = numOne; i <= numTwo; i++) {
            for (int j = numOne; j <= numTwo; j++) {

                result = i + j;
                count++;
                if (result == magicNum) {
                    System.out.printf("Combination N:%d (%d + %d = %d)\n", count, i, j, magicNum);
                    isFound = true;
                    break;
                }
            }
            if(isFound == true) {
                break;
            }
        }
        if (isFound == false) {
            System.out.printf("%d combinations - neither equals %d\n", count, magicNum);
        }
    }
}
