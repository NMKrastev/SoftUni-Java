import java.util.Scanner;

public class SuppliesForSchool {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int pencils = Integer.parseInt(scanner.nextLine());
        int markers = Integer.parseInt(scanner.nextLine());
        int litersOfDetergent = Integer.parseInt(scanner.nextLine());
        double discountPercent = Double.parseDouble(scanner.nextLine()) / 100;
        double price = ((pencils * 5.80) + (markers * 7.20) + (litersOfDetergent * 1.20));
        double discount = price * discountPercent;
        double totalPrice = price - discount;

        System.out.println(totalPrice);

    }
}
