import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.Collectors;

public class A4_AddVAT {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] prices = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        DoubleUnaryOperator addVAT = vat -> vat + (vat * 0.20);

        Consumer<double[]> printPrices = p -> {
            System.out.println("Prices with VAT:");
            System.out.println(Arrays.stream(p)
                    .map(addVAT)
                    .mapToObj(d -> String.format("%.2f", d))
                    .collect(Collectors.joining(System.lineSeparator())));
        };

        printPrices.accept(prices);
    }
}
/*Write a program that reads one line of Double prices separated by ", ".
Print the prices with added VATs for all of them. Format them to the 2nd digit after the decimal point.
The order of the prices must remain the same.
Use an UnaryOperator<Double>.
*/
