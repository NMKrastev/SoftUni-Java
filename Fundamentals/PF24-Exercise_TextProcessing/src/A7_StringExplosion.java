import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A7_StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(">");
        int explosionStrength = 0;
        int strengthLeft = 0;

        for (int i = 0; i < input.length; i++) {
            if (Character.isDigit(input[i].charAt(0))) {
                explosionStrength = Character.getNumericValue(input[i].charAt(0)) + strengthLeft;

                if (input[i].length() >= explosionStrength) {
                    input[i] = input[i].substring(explosionStrength);
                } else {
                    strengthLeft = explosionStrength - input[i].length();
                    input[i] = "";
                }
            }

            if (i == input.length - 1) {
                System.out.print(input[i]);
            } else {
                System.out.print(input[i] + ">");
            }
        }
    }
}
