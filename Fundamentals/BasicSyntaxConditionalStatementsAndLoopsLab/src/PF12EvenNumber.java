import java.util.Scanner;

public class PF12EvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i >= 1; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            if (num % 2 != 0) {
                System.out.println("Please write an even number.");
            } else {
                System.out.printf("The number is: %d", Math.abs(num));
                break;
            }

        }
    }
}
/*Take as an input an even number and print its absolute value with a message: "The number is: {absoluteValue}".
If the number is odd, print "Please write an even number." and continue reading numbers. */