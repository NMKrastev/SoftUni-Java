import java.util.Scanner;

public class SumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int sumPrime = 0;
        int sumNonPrime = 0;

        while (!input.equals("stop")) {

            int currentNum = Integer.parseInt(input);

            if (currentNum < 0) {
                System.out.println("Number is negative.");
                input = scanner.nextLine();
                continue;
            }
            boolean isPrime = true;

            for (int i = 2; i <= currentNum - 1; i++) {
                if (currentNum % i == 0) {
                    sumNonPrime += currentNum;
                    isPrime = false;
                    break;
                }

            }
            if (isPrime) {
                sumPrime += currentNum;
            }
            input = scanner.nextLine();
        }

        System.out.printf("Sum of all prime numbers is: %d\n", sumPrime);
        System.out.printf("Sum of all non prime numbers is: %d\n", sumNonPrime);

    }
}
/*Напишете програма, която чете от конзолата цели числа в диапазона, докато не се получи команда "stop". Да се намери
сумата на всички въведени прости и сумата на всички въведени непрости числа. Тъй като по дефиниция от математиката
отрицателните числа не могат да бъдат прости, ако на входа се подаде отрицателно число да се изведе следното
съобщение "Number is negative.". В този случай въведено число се игнорира и не се прибавя към нито една от двете суми,
а програмата продължава своето изпълнение, очаквайки въвеждане на следващо число.
На изхода да се отпечатат на два реда двете намерени суми в следния формат:
•	"Sum of all prime numbers is: {prime numbers sum}"
•	"Sum of all non prime numbers is: {nonprime numbers sum}"
*/