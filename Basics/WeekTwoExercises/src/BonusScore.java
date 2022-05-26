import java.util.Scanner;

public class BonusScore {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        double bonus, total = 0;

        if (number <= 100) {
            bonus = 5;
        } else if (number > 100 && number <= 1000) {
            bonus = number * 0.2;
        } else {
            bonus = number * 0.1;
        }

        if(number % 2 == 0) {
            bonus += 1;
            total = number + bonus;
        } else if (number % 10 == 5) {
            bonus += 2;
            total = number + bonus;
        } else {
            total = number + bonus;
        }

        System.out.printf("%.1f\n%.1f", bonus, total);

    }
}
