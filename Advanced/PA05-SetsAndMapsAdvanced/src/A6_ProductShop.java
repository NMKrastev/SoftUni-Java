import java.util.*;

public class A6_ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> storeInfoMap = new TreeMap<>();
        String input;
        while (!(input = scanner.nextLine()).equals("Revision")) {

            String store = input.split(",\\s+")[0];
            String product = input.split(",\\s+")[1];
            double price = Double.parseDouble(input.split(",\\s+")[2]);

            storeInfoMap.putIfAbsent(store, new LinkedHashMap<>());
            storeInfoMap.get(store).putIfAbsent(product, price);
        }

        for (Map.Entry<String, Map<String, Double>> storesInfo : storeInfoMap.entrySet()) {
            System.out.printf("%s->\n", storesInfo.getKey());
            storesInfo.getValue().forEach((product, price) ->
                    System.out.printf("Product: %s, Price: %.1f\n", product, price));
        }
    }
}
/*Write a program that prints information about food shops in Sofia and the products they store. Until the "Revision"
command you will receive an input in the format: "{shop}, {product}, {price}".
Keep in mind that if you get a store that already exists, you must gather product information.
Your output must be ordered by shop name and must be in the format:
"{shop}->
Product: {product}, Price: {price}"
The price should be formatted to one digit after the decimal point.
*/
