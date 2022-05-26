import java.util.Scanner;

public class MinNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int min = Integer.MAX_VALUE;

        while (!text.equals("Stop")) {
            Integer number = Integer.parseInt(text);
            if (min > number) {
                min = number;
            }
            text = scanner.nextLine();
        }

        System.out.println(min);

    }
}
/*Напишете програма, която до получаване на командата "Stop", чете цели числа,
въведени от потребителя и намира най-малкото измежду тях. Въвежда се по едно число на ред.*/