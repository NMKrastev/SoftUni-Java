import java.util.*;

public class A6_ListOfProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        List<String> productsList = getProducts(scanner, num);
        productsList = sortingProductsAlphabetically(productsList);
        printProductsList(productsList);


    }

    public static List<String> getProducts(Scanner scanner, int num) {

        List<String> productsList = new ArrayList<>();
        String product = "";
        for (int i = 0; i < num; i++) {
            productsList.add(product = scanner.nextLine());
        }
        return productsList;
    }

    public static List<String> sortingProductsAlphabetically(List<String> productsList) {

        Collections.sort(productsList);
        return productsList;
    }

    public static void printProductsList(List<String> productsList) {
        int bullet = 1;
        for (String product : productsList) {
            System.out.println(bullet + "." + product);
            bullet++;
        }
    }
}
/*Read a number n and n lines of products. Print a numbered list of all the products ordered by name.*/