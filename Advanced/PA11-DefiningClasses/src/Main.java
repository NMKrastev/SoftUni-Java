import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, BankAccount> bankAccountsMap = new LinkedHashMap<>();

        BiFunction<BankAccount, String, String> depositFunction = (b, s) -> {
            int amount = Integer.parseInt(s);
            b.deposit(amount);
            return String.format("Deposited %d to ID%d", amount, b.getId());
        };

        BiFunction<BankAccount, String, String> getInterestFunction = (b, s) -> {
            int years = Integer.parseInt(s);
            double interest = b.getInterest(years);
            return String.format("%.2f", interest);
        };

        String input;
        while (!(input = scanner.nextLine()).equals("End")) {

            String[] operation = input.split("\\s+");

            if (operation[0].equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                bankAccountsMap.put(bankAccount.getId(), bankAccount);
                System.out.printf("Account ID%d created\n", bankAccount.getId());
            } else if (operation[0].equals("Deposit")) {
                String output = executeOnBankAccount(operation, bankAccountsMap, depositFunction);
                System.out.println(output);
            } else if (operation[0].equals("SetInterest")) {
                double interestRate = Double.parseDouble(operation[1]);
                BankAccount.setInterestRate(interestRate);
            } else if (operation[0].equals("GetInterest")) {
                String output = executeOnBankAccount(operation, bankAccountsMap, getInterestFunction);
                System.out.println(output);
            }
        }
    }

    private static String executeOnBankAccount(String[] operation, Map<Integer, BankAccount> bankAccountsMap,
                                               BiFunction<BankAccount, String, String> function) {

        BankAccount bankAccount = bankAccountsMap.get(Integer.parseInt(operation[1]));
        if (bankAccount == null) {
            return "Account does not exist";
        }

        return function.apply(bankAccount, operation[2]);
    }
}
