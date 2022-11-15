import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A2_AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> productsInfoList = new ArrayList<>();
        String line = scanner.nextLine();

        Pattern pattern = Pattern.compile("(#|\\|)(?<item>[A-Za-z ]+)\\1(?<date>\\d{2}/\\d{2}/\\d{2})\\1(?<calories>\\d{1,5})\\1");
        Matcher matcher = pattern.matcher(line);

        int sumCalories = 0;
        while (matcher.find()) {
            String productInfo = matcher.group(0);
            int calories = Integer.parseInt(matcher.group("calories"));
            productsInfoList.add(productInfo);
            sumCalories += calories;
        }

        System.out.printf("You have food to last you for: %d days!\n", sumCalories / 2000);
        productsInfoList.stream().forEach(e -> System.out.printf("Item: %s, Best before: %s, Nutrition: %s\n",
                e.split("(#)|(\\|)")[1], e.split("(#)|(\\|)")[2], e.split("(#)|(\\|)")[3]));
    }
}
/*On the first line of the input, you will be given a text string. You must extract the information
about the food and calculate the total calories.
First, you must extract the food info. It will always follow the same pattern rules:
•	It will be surrounded by "|" or "#" (only one of the two) in the following pattern:
#{item name}#{expiration date}#{calories}#   or
|{item name}|{expiration date}|{calories}|
•	The item name will contain only lowercase and uppercase letters and whitespace
•	The expiration date will always follow the pattern: "{day}/{month}/{year}", where the day, month, and year
will be exactly two digits long
•	The calories will be an integer between 0-10000
Calculate the total calories of all food items and then determine how many days you can last with the food you have.
Keep in mind that you need 2000kcal a day.
Input / Constraints
•	You will receive a single string
Output
•	First, print the number of days you will be able to last with the food you have:
"You have food to last you for: {days} days!"
•	The output for each food item should look like this:
"Item: {item name}, Best before: {expiration date}, Nutrition: {calories}"*/