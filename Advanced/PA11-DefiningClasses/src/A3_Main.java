import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;

public class A3_Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, A3_BankAccount> bankAccountsMap = new LinkedHashMap<>();

        BiFunction<A3_BankAccount, String, String> depositFunction = (b, s) -> {
            int amount = Integer.parseInt(s);
            b.deposit(amount);
            return String.format("Deposited %d to ID%d", amount, b.getId());
        };

        BiFunction<A3_BankAccount, String, String> getInterestFunction = (b, s) -> {
            int years = Integer.parseInt(s);
            double interest = b.getInterest(years);
            return String.format("%.2f", interest);
        };

        String input;
        while (!(input = scanner.nextLine()).equals("End")) {

            String[] operation = input.split("\\s+");

            if (operation[0].equals("Create")) {
                A3_BankAccount bankAccount = new A3_BankAccount();
                bankAccountsMap.put(bankAccount.getId(), bankAccount);
                System.out.printf("Account ID%d created\n", bankAccount.getId());
            } else if (operation[0].equals("Deposit")) {
                String output = executeOnBankAccount(operation, bankAccountsMap, depositFunction);
                System.out.println(output);
            } else if (operation[0].equals("SetInterest")) {
                double interestRate = Double.parseDouble(operation[1]);
                A3_BankAccount.setInterestRate(interestRate);
            } else if (operation[0].equals("GetInterest")) {
                String output = executeOnBankAccount(operation, bankAccountsMap, getInterestFunction);
                System.out.println(output);
            }
        }
    }

    private static String executeOnBankAccount(String[] operation, Map<Integer, A3_BankAccount> bankAccountsMap,
                                               BiFunction<A3_BankAccount, String, String> function) {

        A3_BankAccount bankAccount = bankAccountsMap.get(Integer.parseInt(operation[1]));
        if (bankAccount == null) {
            return "Account does not exist";
        }

        return function.apply(bankAccount, operation[2]);
    }
}
/*Create class BankAccount.
The class should have private fields for:
•	Id: int (Starts from 1 and increments for every new account)
•	Balance: double
•	Interest rate: double (Shared for all accounts. Default value: 0.02)
The class should also have public methods for:
•	setInterestRate(double interest): void (static)
•	getInterest(int Years): double
•	deposit(double amount): void
Create a test client supporting the following commands:
•	Create
•	Deposit {Id} {Amount}
•	SetInterest {Interest}
•	GetInterest {ID} {Years}
•	End
*/
