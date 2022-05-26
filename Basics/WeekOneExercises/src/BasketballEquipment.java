import java.util.Scanner;

public class BasketballEquipment {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int taxPerYear = Integer.parseInt(scanner.nextLine());
        double sneakers = taxPerYear * 0.6;
        double outfit = sneakers * 0.8;
        double basketball = outfit * 0.25;
        double accessories = basketball * 0.2;
        double expenses =  taxPerYear + sneakers + outfit + basketball + accessories;

        System.out.println(expenses);
    }
}