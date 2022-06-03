import java.util.Scanner;

public class PF04RefactoringPrimeChecker {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 2; i <= number; i++) {
            boolean isPrime = true;
            for (int primeChecker = 2; primeChecker < i; primeChecker++) {
                if (i % primeChecker == 0) {
                    isPrime = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", i, isPrime);
        }
    }
}

        //Code that needs refactoring:
        /*Scanner chetec = new Scanner(System.in);

        int ___Do___ = Integer.parseInt(chetec.nextLine());
        for (int takoa = 2; takoa <= ___Do___; takoa++) {
            boolean takovalie = true;
            for (int cepitel = 2; cepitel < takoa; cepitel++) {
                if (takoa % cepitel == 0) {
                    takovalie = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", takoa, takovalie);
        }
        */

/*You are given a program that checks if numbers in a given range [2...N] are prime. For each number is
printed "{number} -> {true or false}". The code, however, is not very well written. Your job is to modify
it in a way that is easy to read and understand.*/