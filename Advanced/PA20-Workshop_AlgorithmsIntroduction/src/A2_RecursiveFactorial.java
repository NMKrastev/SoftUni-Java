import java.util.Scanner;

public class A2_RecursiveFactorial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fact = Integer.parseInt(scanner.nextLine());

        int sum = findFact(fact);
        System.out.println(sum);
    }

    private static int findFact(int fact) {
        if (fact == 1) {
            return fact;
        }

        return fact * findFact(fact - 1);
    }
}
/*Write a program that finds the factorial of a given number. Use recursion.
Note: In practice, recursion should not be used here. Instead, you should use an iterative solution.
This type of solution is for exercise purposes.
*/
