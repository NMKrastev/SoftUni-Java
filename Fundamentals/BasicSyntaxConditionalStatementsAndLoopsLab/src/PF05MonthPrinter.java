import java.util.Scanner;

public class PF05MonthPrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        if (num < 1 || num > 12) {
            System.out.println("Error!");
        } else {
            switch (num) {
                case 1:
                    System.out.println("January");
                    break;
                case 2:
                    System.out.println("February");
                    break;
                case 3:
                    System.out.println("March");
                    break;
                case 4:
                    System.out.println("April");
                    break;
                case 5:
                    System.out.println("May");
                    break;
                case 6:
                    System.out.println("June");
                    break;
                case 7:
                    System.out.println("July");
                    break;
                case 8:
                    System.out.println("August");
                    break;
                case 9:
                    System.out.println("September");
                    break;
                case 10:
                    System.out.println("October");
                    break;
                case 11:
                    System.out.println("November");
                    break;
                case 12:
                    System.out.println("December");
                    break;
            }
        }
    }
}
/*Write a program, which takes an integer from the console and prints the corresponding month.
If the number is more than 12 or less than 1 print "Error!".
Input
You will receive a single integer on a single line.
Output
If the number is within the boundaries print the corresponding month, otherwise print "Error!".
*/