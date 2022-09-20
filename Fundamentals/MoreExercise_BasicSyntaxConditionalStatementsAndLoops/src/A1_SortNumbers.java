import java.util.Arrays;
import java.util.Scanner;

public class A1_SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        if (num1 > num2 && num1 > num3) {
            System.out.println(num1);
            if (num2 > num3) {
                System.out.println(num2);
                System.out.println(num3);
            } else {
                System.out.println(num3);
                System.out.println(num2);
            }
        } else if (num2 > num1 && num2 > num3) {
            System.out.println(num2);
            if (num1 > num3) {
                System.out.println(num1);
                System.out.println(num3);
            } else {
                System.out.println(num3);
                System.out.println(num1);
            }
        } else if (num3 > num1 && num3 > num2) {
            System.out.println(num3);
            if (num1 > num2) {
                System.out.println(num1);
                System.out.println(num2);
            } else {
                System.out.println(num2);
                System.out.println(num1);
            }
        }

/*        int[] num = new int[3];

        for (int i = 0; i < 3; i++) {

            int currentNum = Integer.parseInt(scanner.nextLine());;

            num[i] = currentNum;

        }
        Arrays.sort(num);
        System.out.printf("%d\n%d\n%d\n", num[2], num[1], num[0]);*/
    }
}
/*Read three real numbers and sort them in descending order.
Print each number on a new line.*/