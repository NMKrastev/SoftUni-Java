package A6_GenericCountMethodDouble;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<Double> list = new Box<>();
        for (int i = 0; i < n; i++) {
            Double input = Double.valueOf(scanner.nextLine());
            list.add(input);
        }

        String element = scanner.nextLine();

        System.out.println(list.countOfGreaterItems(Double.valueOf(element)));
    }
}
/*Use the description of the previous problem but now, test your list of generic boxes with Doubles.*/
