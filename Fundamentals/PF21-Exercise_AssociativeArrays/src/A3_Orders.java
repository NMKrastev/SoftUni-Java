import java.util.*;

public class A3_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> mapPrice = new LinkedHashMap<>();
        Map<String, Integer> mapQuantity = new LinkedHashMap<>();
        String line;

        while (!(line = scanner.nextLine()).equals("buy")) {

            String product = line.split("\\s+")[0];

            if (!mapPrice.containsKey(product) && !mapQuantity.containsKey(product)) {
                mapPrice.put(product, Double.parseDouble(line.split("\\s+")[1]));
                mapQuantity.put(product, Integer.parseInt(line.split("\\s+")[2]));
            } else {
                double newPrice = Double.parseDouble(line.split("\\s+")[1]);
                int newQuantity = mapQuantity.get(product) + Integer.parseInt(line.split("\\s+")[2]);
                mapPrice.put(product, newPrice);
                mapQuantity.put(product, newQuantity);

            }
        }

        for (String key : mapPrice.keySet()) {
            if (mapQuantity.containsKey(key)) {
                System.out.printf("%s -> %.2f\n", key, mapPrice.get(key) * mapQuantity.get(key));
            }
        }
    }
}
/*Write a program which keeps the information about products and their prices. Each product has a name, a price,
and its quantity. If the product doesn't exist yet, add it with its starting quantity.
If you receive a product that already exists, increases its quantity by the input quantity and if its price is
different, replace the price as well.
You will receive products' names, prices, and quantities on new lines. Until you receive the command "buy",
keep adding items. When you do receive the command "buy", print the items with their names and the total price
of all the products with that name.
Input
•	Until you receive "buy", the products come in the format: "{name} {price} {quantity}".
•	The product data is always delimited by a single space.
Output
•	Print information about each product, following the format:
"{productName} -> {totalPrice}"
•	Format the average total price to the 2nd decimal place.
*/