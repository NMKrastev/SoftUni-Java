import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double deposit = Double.parseDouble(scanner.nextLine());
        int periodOfDeposit = Integer.parseInt(scanner.nextLine());
        double interest = Double.parseDouble(scanner.nextLine()) / 100;
        double totalSum =  deposit + periodOfDeposit * ((deposit * interest) / 12);

        System.out.println(totalSum);

    }
}
