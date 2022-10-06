import java.util.Scanner;

public class A1_DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        switch (input) {
            case "int":
                int num = Integer.parseInt(scanner.nextLine());
                printInt(num);
                break;
            case "real":
                double number = Double.parseDouble(scanner.nextLine());
                printReal(number);
                break;
            case "string":
                String line = scanner.nextLine();
                printString(line);
                break;
        }
    }

    public static void printInt(int num) {
        System.out.println(num * 2);
    }

    public static void printReal(double number) {
        System.out.printf("%.2f", number * 1.5);
    }

    public static void printString(String line) {
        System.out.printf("$%s$", line);
    }
}
/*Write a program that, depending on the first line of the input, reads an int, double, or string.
•	If the data type is int, multiply the number by 2.
•	If the data type is real, multiply the number by 1.5 and format it to the second decimal point.
•	If the data type is a string, surround the input with "$".
Print the result on the console.
*/