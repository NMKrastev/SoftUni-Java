import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int max = Integer.MIN_VALUE;

        while (!text.equals("Stop")) {

            Integer number = Integer.parseInt(text);
            if (number > max) {
                max = number;
            }

            text = scanner.nextLine();

        }

        System.out.println(max);
    }
}
/*Напишете програма, която до получаване на командата "Stop", чете цели числа, въведени от потребителя
и намира най-голямото измежду тях. Въвежда се по едно число на ред.*/