import java.util.Scanner;

public class PF05Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] letter = new String[][] {{" ", "1", "a", "d", "g", "j", "m", "p", "t", "w"},
                                            {" ", "1", "b", "e", "h", "k", "n", "q", "u", "x"},
                                            {" ", "1", "c", "f", "i", "l", "o", "r", "v", "y"},
                                            {" ", "1", "", "", "", "", "",      "s", "",  "z"}};
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
/*Write a program, which emulates typing an SMS, following this guide:
 Following the guide, 2 becomes "a", 22 becomes "b" and so on.*/