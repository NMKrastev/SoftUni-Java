import java.util.Scanner;

public class A12_EvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isEven = false;

        while (!isEven) {

            int num = Integer.parseInt(scanner.nextLine());
            num = Math.abs(num);

            if (num % 2 != 0) {
                System.out.println("Please write an even number.");
            } else {
                System.out.printf("The number is: %d", num);
                isEven = true;
            }
        }
    }
}
/*Take as an input an even number and print its absolute value with
a message: "The number is: {absoluteValue}". If the number is odd,
print "Please write an even number." and continue reading numbers.*/