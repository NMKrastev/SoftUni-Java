import java.util.Scanner;

public class A2_PoundsToDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double dollar = Double.parseDouble(scanner.nextLine());

        System.out.printf("%.3f", dollar * 1.36);
    }
}
/*Write a program that converts British pounds to US dollars
formatted to the 3rd decimal point.
1 British Pound = 1.36 Dollar*/