import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A5_MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine().replaceFirst("^0+(?!$)", "");
        int multiply = Integer.parseInt(scanner.nextLine());
        String result = "";

        if (number.isEmpty()) {
            number = "0";
        }
        if (multiply == 0) {
            System.out.println(0);
            return;
        }

        result = multiplyNumber(number, multiply);
        System.out.println(result);
    }

    private static String multiplyNumber(String number, int multiply) {

        StringBuilder sb = new StringBuilder();
        int remainder = 0;

        for (int i = number.length() - 1; i >= 0; i--) {

            int currentSum = 0;

            if (i == 0) {
                int remain = Integer.parseInt(String.valueOf(number.charAt(i))) * multiply + remainder;
                String preReverse = Integer.toString(remain);
                String reversedNum = new StringBuffer(preReverse).reverse().toString();
                sb.append(reversedNum);
                remainder = 0;
                break;
            }
            if (Integer.parseInt(String.valueOf(number.charAt(i))) * multiply + remainder < 10) {
                currentSum = Integer.parseInt(String.valueOf(number.charAt(i))) * multiply + remainder;
                sb.append(currentSum);
                remainder = 0;
            } else {
                currentSum = Integer.parseInt(String.valueOf(number.charAt(i))) * multiply + remainder;
                sb.append(currentSum % 10);
                currentSum /= 10;
                remainder = currentSum;
            }
        }
        return sb.reverse().toString();
    }
}
/*You are given two lines – the first one can be a really big number (0 to 1050). The second one will be a single-digit
number (0 to 9). You must display the product of these numbers.
Note: do not use the BigInteger class.
*/