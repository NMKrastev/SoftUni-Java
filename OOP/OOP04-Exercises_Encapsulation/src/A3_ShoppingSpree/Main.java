package A3_ShoppingSpree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] peopleInfo = scanner.nextLine().split(";");
        Map<String, Person> peopleMap = new LinkedHashMap<>();

        for (String personString : peopleInfo) {
            String[] personData = personString.split("=");
            String name = personData[0];
            double money = Double.parseDouble(personData[1]);
            try {
                Person person = new Person(name, money);
                peopleMap.put(name, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String[] productsInfo = scanner.nextLine().split(";");
        Map<String, Product> productsMap = new LinkedHashMap<>();

        for (String productString : productsInfo) {
            String[] productData = productString.split("=");
            String name = productData[0];
            double cost = Double.parseDouble(productData[1]);
            try {
                Product product = new Product(name, cost);
                productsMap.put(name, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        System.out.println();
        String input;

        while (!(input = scanner.nextLine()).equals("END")) {
            String personName = input.split("\\s+")[0];
            String productName = input.split("\\s+")[1];

            Person buyer = peopleMap.get(personName);
            Product product = productsMap.get(productName);

            try {
                buyer.buyProduct(product);
                System.out.printf("%s bought %s\n", personName, productName);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        peopleMap.values().forEach(System.out::println);
    }
}
/*Create two classes: class Person and class Product. Each person should have a name, money, and a bag of products.
Each product should have a name and cost. The name cannot be an empty string. Be careful about white space in the name.
Money and cost cannot be a negative number.
Person
-	name: String
-	money:  double
-	products:  List<Product>
+ 	Person (String,  double)
-	setName (String): void
-	setMoney (double): void
+	buyProduct (Product): void
+	getName(): String
Product
-	name: String
-	cost: double
+ 	Product (String,  double)
-	setCost (double): void
-	setName (String): void
+	getName(): String
+	getCost (): double
Create a program in which each command corresponds to a person buying a product. If the person can afford a product
add it to his bag. If a person doesn’t have enough money, print an appropriate exception message:
"{Person name} can't afford {Product name}"
In the first two lines, you are given all people and all products. After all, purchases print every person
in the order of appearance and all products that he has bought also in order of appearance. If nothing is bought, print:
"{Person name} - Nothing bought".
Read commands till you find the line with the "END" command. In case of invalid input
(negative money exception message: "Money cannot be negative") or empty name:
(empty name exception message "Name cannot be empty") break the program with an appropriate message.
*/