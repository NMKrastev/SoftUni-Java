package A2_GenericBoxOfInteger;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<Integer> box;
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            box = new Box<>(input);
            System.out.println(box);
        }
    }
}
/*Use the description of the previous problem but now, test your generic box with Integers.*/
