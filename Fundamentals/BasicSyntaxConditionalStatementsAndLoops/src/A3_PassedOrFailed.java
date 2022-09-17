import java.util.Scanner;

public class A3_PassedOrFailed {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double grade = Double.parseDouble(scanner.nextLine());

        if (grade >= 3.00) {
            System.out.println("Passed!");
        } else {
            System.out.println("Failed!");
        }
    }
}
/*Modify the above program, so it will print "Failed!" if the grade
is lower than 3.00.
Input:
The input comes as a single double number.
Output:
The output is either "Passed!" if the grade is more than 2.99,
otherwise, you should print "Failed!"*/