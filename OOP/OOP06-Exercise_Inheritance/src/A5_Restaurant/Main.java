package A5_Restaurant;

public class Main {

    public static void main(String[] args) {

    }
}
/*NOTE: You need a public class Main. Create a restaurant package with the following classes and hierarchy:
There are Food and Beverages in the restaurant and they are all products.
The Product class must have the following members:
•	A public constructor with the following parameters: String name, BigDecimal price
•	name – String
•	price - BigDecimal
•	Getters for the fields
Beverage and Food classes are products.
The Beverage class must have the following members:
•	A public constructor with the following parameters: String name, BigDecimal price, double milliliters
•	name – String
•	price – BigDecimal
•	milliliters - double
•	Getter for milliliters
The Food class must have the following members:
•	A constructor with the following parameters: String name, BigDecimal price, double grams
•	name – String
•	price – double
•	grams - double
•	Getter for grams
HotBeverage and ColdBeverage are beverages and they accept the following parameters upon initialization:
String name, BigDecimal price, double milliliters
Coffee and Tea are hot beverages.
The Coffee class must have the following additional members:
•	double COFFEE_MILLILITERS = 50
•	BigDecimal COFFEE_PRICE = 3.50
•	caffeine – double
•	Getter for caffeine
MainDish, Dessert, and Starter are food. They all accept the following parameters upon initialization:
String name, BigDecimal price, double grams. Dessert must accept one more parameter in its constructor: double calories.
•	calories – double
•	Getter for calories

Make Salmon, Soup and Cake inherit the proper classes.
A Cake must have the following members upon initialization:
•	double CAKE_GRAMS = 250
•	double CAKE_CALORIES = 1000
•	BigDecimal CAKE_PRICE = 5
A Salmon must have the following members upon initialization:
•	double SALMON_GRAMS = 22
*/