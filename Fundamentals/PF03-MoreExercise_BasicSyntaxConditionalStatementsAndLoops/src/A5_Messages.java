import java.util.Scanner;

public class A5_Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] letter = new String[][] {{" ", "1", "a", "d", "g", "j", "m", "p", "t", "w"},
                                            {" ", "1", "b", "e", "h", "k", "n", "q", "u", "x"},
                                            {" ", "1", "c", "f", "i", "l", "o", "r", "v", "y"},
                                            {" ", "1", "", "", "", "", "", "s", "", "z"}};
        StringBuilder sb = new StringBuilder();

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number; i++) {
            String num = scanner.nextLine();
            int digit = Integer.parseInt(num) % 10;
            int length = num.length() - 1;

            sb.append(letter[length][digit]);

        }
        System.out.println(sb);
    }
}
/*Write a program that emulates typing an SMS, following this guide:

1       2-abc       3-def
4-ghi   5-jkl       6-mno
7-pqrs  8-tuv       9-wxyz
        0-space

Following the guide, 2 becomes "a", 22 becomes "b" and so on*/