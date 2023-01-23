public class A3PA11_BankAccount {

    private int id;
    private static int accountsCount = 1;
    private double balance;
    private static double interestRate = 0.02;

    public A3PA11_BankAccount() {
        this.id = accountsCount;
        accountsCount++;
    }

    public int getId() {
        return id;
    }

    public static void setInterestRate(double interestRate) {
        A3PA11_BankAccount.interestRate = interestRate;
    }

    public double getInterest(int years) {
        return balance * years * interestRate;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}
