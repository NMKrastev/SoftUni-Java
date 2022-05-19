import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int n;
        int sum = 0;

        for (int i = 0; i < num; i++) {
            n = Integer.parseInt(scanner.nextLine());
            sum += n;

        }
        System.out.println(sum);
    }
}
