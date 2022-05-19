import java.util.Scanner;

public class AccountBalance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numberOrText = scanner.nextLine();
        double sum = 0;

        while (!numberOrText.equals("NoMoreMoney")) {

            Double number = Double.parseDouble(numberOrText);
            if (number < 0) {
                System.out.println("Invalid operation!");
                System.out.printf("Total: %.2f", sum);
                break;
            }
            sum += number;
            System.out.printf("Increase: %.2f\n", number);
            numberOrText = scanner.nextLine();
            if (numberOrText.equals("NoMoreMoney")) {
                System.out.printf("Total: %.2f\n", sum);
            }
        }


    }
}
/*Напишете програма, която пресмята колко общо пари има в сметката, след като направите определен брой вноски.
На всеки ред ще получавате сумата, която трябва да внесете в сметката, до получаване на команда  "NoMoreMoney ".
При всяка получена сума на конзолата трябва да се извежда "Increase: " + сумата и тя да се прибавя в сметката.
Ако получите число по-малко от 0 на конзолата трябва да се изведе "Invalid operation!"  и програмата да приключи.
Когато програмата приключи трябва да се принтира "Total: " + общата сума в сметката форматирана до втория
знак след десетичната запетая*/