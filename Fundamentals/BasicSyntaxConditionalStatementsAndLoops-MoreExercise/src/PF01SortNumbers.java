import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class PF01SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] num = new double[3];

        for (int i = 0; i < 3; i++) {

            double currentNum = Double.parseDouble(scanner.nextLine());

            num[i] = currentNum;

        }
        Arrays.sort(num);
        System.out.printf("%.0f\n%.0f\n%.0f\n", num[2], num[1], num[0]);
    }
}



