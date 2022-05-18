import java.util.Scanner;

public class FruitOrVegetable {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine().toLowerCase();

        boolean isFriut = product.equals("banana")
                || product.equals("apple")
                || product.equals("kiwi")
                || product.equals("cherry")
                || product.equals("lemon")
                || product.equals("grapes");

        boolean isVegetable = product.equals("tomato")
                || product.equals("cucumber")
                || product.equals("pepper")
                || product.equals("carrot");

        if (isFriut) {
            System.out.println("fruit");
        } else if (isVegetable) {
            System.out.println("vegetable");
        } else {
            System.out.println("unknown");
        }
    }
}