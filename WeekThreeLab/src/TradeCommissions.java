import java.util.Scanner;

public class TradeCommissions {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String city = scanner.nextLine().toLowerCase();
        double volume = Double.parseDouble(scanner.nextLine());
        double commission = -1;

        if (city.equals("sofia")) {
            if (volume >= 0 && volume <= 500) {
                commission = volume * 0.05;
            } else if (volume > 500 && volume <= 1000) {
                commission = volume * 0.07;
            } else if (volume > 1000 && volume <= 10000) {
                commission = volume * 0.08;
            } else if (volume > 10000) {
                commission = volume * 0.12;
            }
        } else if (city.equals("varna")) {
            if (volume >= 0 && volume <= 500) {
                commission = volume * 0.045;
            } else if (volume > 500 && volume <= 1000) {
                commission = volume * 0.075;
            } else if (volume > 1000 && volume <= 10000) {
                commission = volume * 0.1;
            } else if (volume > 10000) {
                commission = volume * 0.13;
            }
        } else if (city.equals("plovdiv")) {
            if (volume >= 0 && volume <= 500) {
                commission = volume * 0.055;
            } else if (volume > 500 && volume <= 1000) {
                commission = volume * 0.08;
            } else if (volume > 1000 && volume <= 10000) {
                commission = volume * 0.12;
            } else if (volume > 10000) {
                commission = volume * 0.145;
            }
        }
        if (commission >= 0) {
            System.out.printf("%.2f", commission);
        } else {
            System.out.printf("error");
        }
    }
}