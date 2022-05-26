import java.util.Scanner;

public class YardGreening {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double area = Double.parseDouble(scanner.nextLine()) * 7.61;
        double discount = area * 0.18;
        double priceWithDiscount = area - discount;

        System.out.printf("The final price is: %.2f lv.%nThe discount is: %.2f lv.",priceWithDiscount, discount);

    }
}
