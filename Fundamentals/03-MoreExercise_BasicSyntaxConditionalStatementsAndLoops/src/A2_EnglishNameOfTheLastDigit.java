import java.util.Scanner;

public class A2_EnglishNameOfTheLastDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        String digit = String.valueOf(num % 10);
        System.out.println(lastDigit(digit));

    }

    public static String lastDigit(String digit) {

        return switch (digit) {
            case "0" -> "zero";
            case "1" -> "one";
            case "2" -> "two";
            case "3" -> "three";
            case "4" -> "four";
            case "5" -> "five";
            case "6" -> "six";
            case "7" -> "seven";
            case "8" -> "eight";
            case "9" -> "nine";
            default -> "";
        };
    }
}
/*Write a method that returns the English name of the last digit of a given number.
Write a program that reads an integer and prints the returned value from this method.*/