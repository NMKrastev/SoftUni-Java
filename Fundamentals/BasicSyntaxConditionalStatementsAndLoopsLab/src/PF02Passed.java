import java.util.Scanner;

public class PF02Passed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double grade = Double.parseDouble(scanner.nextLine());

        if (grade >= 3.00) {
            System.out.println("Passed!");
        }
    }
}
/*Write a program, which takes as an input a grade and prints "Passed!" if the grade is equal or more than 3.00.
Input
The input comes as a single floating-point number.
Output
The output is either "Passed!" if the grade is equal or more than 3.00, otherwise you should print nothing.
*/