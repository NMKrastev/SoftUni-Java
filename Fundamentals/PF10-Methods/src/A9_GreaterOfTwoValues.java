import java.util.Scanner;

public class A9_GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        switch (input) {
            case "int":
                int numOne = Integer.parseInt(scanner.nextLine());
                int numTwo = Integer.parseInt(scanner.nextLine());
                System.out.println(getMax(numOne, numTwo));
                break;
            case "char":
                char one = scanner.nextLine().charAt(0);
                char two = scanner.nextLine().charAt(0);
                System.out.println(getMax(one, two));
                break;
            case "string":
                String lineOne = scanner.nextLine();
                String lineTwo = scanner.nextLine();
                System.out.println(getMax(lineOne, lineTwo));
        }
    }

    private static int getMax(int numOne, int numTwo) {

        return Math.max(numOne, numTwo);
    }

    private static char getMax(char one, char two) {

        return (char) Math.max(one, two);
    }

    private static String getMax(String lineOne, String lineTwo) {

        if (lineOne.compareTo(lineTwo) >= 0) {
            return lineOne;
        }
        return lineTwo;
    }
}
/*You are given two values of the same type as input. The values can be of type int, char of String.
Create a method getMax() that returns the greater of the two values: */