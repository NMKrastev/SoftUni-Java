import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A1_Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> boughtFurnitureList = new ArrayList<>();
        double totalSum = 0;
        String regex = ">>(?<furniture>[A-Za-z]+)<<(?<price>[0-9]*[.]?[0-9]+)!(?<quantity>\\d+)";
        String input;

        Pattern pattern = Pattern.compile(regex);

        while (!(input = scanner.nextLine()).equals("Purchase")) {

            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                boughtFurnitureList.add(matcher.group("furniture"));
                totalSum += Double.parseDouble(matcher.group("price")) * Integer.parseInt(matcher.group("quantity"));
            }
        }
        System.out.println("Bought furniture:");
        boughtFurnitureList.forEach(e -> System.out.printf("%s\n", e));
        System.out.printf("Total money spend: %.2f", totalSum);
    }
}
/*Write a program to calculate the total cost of different types of furniture. You will be given some lines of input
until you receive the line "Purchase". For the line to be valid, it should be in the following format:
">>{furniture name}<<{price}!{quantity}"
The price can be a floating-point number or a whole number. Store the names of the furniture and the total price.
In the end, print each bought furniture on a separate line in the format:
"Bought furniture:
{1st name}
{2nd name}
…"
And on the last line, print the following: "Total money spend: {spend money}", formatted to the second decimal point.*/