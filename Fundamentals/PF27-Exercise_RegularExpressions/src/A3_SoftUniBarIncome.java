import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A3_SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern patternName = Pattern.compile("(?<=\\%)([A-Z][a-z]+)(?=\\%)");
        Pattern patternProduct = Pattern.compile("(?<=\\<)([\\w]+)(?=\\>)");
        Pattern patternCount = Pattern.compile("(?<=\\|)([\\d]+)(?=\\|)");
        Pattern patternPrice = Pattern.compile("[0-9]*[.]?[0-9]+\\$");
        double totalSum = 0;
        String input;

        while (!(input = scanner.nextLine()).equals("end of shift")) {

            Matcher matcherName = patternName.matcher(input);
            Matcher matcherProduct = patternProduct.matcher(input);
            Matcher matcherCount = patternCount.matcher(input);
            Matcher matcherPrice = patternPrice.matcher(input);

            if (matcherName.find() && matcherProduct.find() && matcherCount.find() && matcherPrice.find()) {
                String name = matcherName.group();
                String product = matcherProduct.group();
                int count = Integer.parseInt(matcherCount.group());
                double price = Double.parseDouble(matcherPrice.group().split("\\$")[0]);

                System.out.printf("%s: %s - %.2f\n", matcherName.group(), matcherProduct.group(), count * price);
                totalSum += count * price;
            }
        }
        System.out.printf("Total income: %.2f", totalSum);
    }
}
/*Let's take a break and visit the game bar at SoftUni. It is about time for the people behind the bar to go home, and
you are the person who has to draw the line and calculate the money from the products that were sold throughout the day.
Until you receive a line with the text "end of shift", you will be given lines of input. But before processing that line,
you have to do some validations first.
Each valid order should have a customer, product, count, and price:
· Valid customer's name should be surrounded by '%' and must start with a capital letter, followed by lower-case letters.
· Valid product contains any word character and must be surrounded by '<' and '>'.
· The valid count is an integer surrounded by '|'.
· The valid price is any real number followed by '$'.
The parts of a valid order should appear in the order given: customer, product, count, and price.
Between each part there can be other symbols, except ('|', '$', '%' and '. ')
For each valid line print on the console: "{customerName}: {product} - {totalPrice}"
When you receive "end of shift", print the total amount of money for the day rounded to 2 decimal places in the
following format: "Total income: {income}".
Input / Constraints
· Strings must be processed until you receive the text "end of shift".
Output
· Print all the valid lines in the format "{customerName}: {product} - {totalPrice}".
· After receiving "end of shift" print the total amount of money for the day rounded to 2 decimal places in the
following format: "Total income: {income}".
· Allowed working time / memory: 100ms / 16MB.*/