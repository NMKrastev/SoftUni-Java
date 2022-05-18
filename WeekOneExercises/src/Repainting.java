import java.util.Scanner;

public class Repainting {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int nylon = Integer.parseInt(scanner.nextLine()) + 2;
        int litersOfPaint = Integer.parseInt(scanner.nextLine());
        int litersOFPaintThinner = Integer.parseInt(scanner.nextLine());
        int hourNeeded = Integer.parseInt(scanner.nextLine());
        double price = (nylon * 1.50) + ((litersOfPaint * 0.1 + litersOfPaint) * 14.50)
                + (litersOFPaintThinner * 5.00) + 0.40;
        double workersFee = (price * 0.3) * hourNeeded;
        double totalPrice = price + workersFee;
        System.out.println(totalPrice);

    }
}
