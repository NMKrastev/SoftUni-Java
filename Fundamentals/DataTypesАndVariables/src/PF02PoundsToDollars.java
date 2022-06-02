import java.util.Scanner;

public class PF02PoundsToDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double pounds = Double.parseDouble(scanner.nextLine());

        double dollars = pounds * 1.36;

        System.out.printf("%.3f", dollars);
    }
}
/*Write a program that converts British pounds to US dollars formatted to the 3rd decimal point.
1 British Pound = 1.36 Dollars
*/