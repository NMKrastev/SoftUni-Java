import java.util.Scanner;

public class AverageNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int i = 0;
        double sum = 0;


        while (i < n) {
            double num = Double.parseDouble(scanner.nextLine());

            sum += num;

            i++;
        }

        System.out.printf("%.2f", sum / n);
    }
}
