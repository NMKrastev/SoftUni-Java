import java.util.Scanner;

public class PoolDay01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        double fee = Double.parseDouble(scanner.nextLine());
        double feePerSunbed = Double.parseDouble(scanner.nextLine());
        double feePerUmbrella = Double.parseDouble(scanner.nextLine());
        double totalFee = people * fee;
        int totalSunbeds = (int) Math.ceil((people * 0.75));
        int totalUmbrellas = (int) Math.ceil(people / 2.00);
        double totalMoney = totalFee + (Math.ceil(totalUmbrellas) * feePerUmbrella) +
                (totalSunbeds * feePerSunbed);

        System.out.printf("%.2f lv.", totalMoney);

    }
}
