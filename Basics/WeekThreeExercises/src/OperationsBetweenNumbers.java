import java.util.Scanner;

public class OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        double result = 0;
        if (operator.equals("+")) {
            result = num1 + num2;
            System.out.printf("%d + %d = %.0f", num1, num2, result);
            if (result % 2 == 0) {
                System.out.println(" - even");
            } else {
                System.out.println(" - odd");
            }
        } else if (operator.equals("-")) {
            result = num1 - num2;
            System.out.printf("%d - %d = %.0f", num1, num2, result);
            if (result % 2 == 0) {
                System.out.println(" - even");
            } else {
                System.out.println(" - odd");
            }
        } else if (operator.equals("*")) {
            result = num1 * num2;
            System.out.printf("%d * %d = %.0f", num1, num2, result);
            if (result % 2 == 0) {
                System.out.println(" - even");
            } else {
                System.out.println(" - odd");
            }
        } else if (operator.equals("/")) {
            if (num1 == 0) {
                System.out.printf("Cannot divide %d by zero", num2);
            } else if (num2 == 0) {
                System.out.printf("Cannot divide %d by zero", num1);
            } else {
                result = num1 / (num2 * 1.00);
                System.out.printf("%d / %d = %.2f", num1, num2, result);
            }
        }else if (operator.equals("%")) {
            if (num1 == 0) {
                System.out.printf("Cannot divide %d by zero", num2);
            } else if (num2 == 0) {
                System.out.printf("Cannot divide %d by zero", num1);
            } else {
                result = num1 % num2;
                System.out.printf("%d %% %d = %.0f", num1, num2, result);
            }
        }
    }
}
