package A3_BankAccount;

public class BankAccount {

    private int id;
    private static int accountsCount = 1;
    private double balance;
    private static double interestRate = 0.02;

    public BankAccount() {
        this.id = accountsCount;
        accountsCount++;
    }

    public int getId() {
        return id;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public double getInterest(int years) {
        return balance * years * interestRate;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}
