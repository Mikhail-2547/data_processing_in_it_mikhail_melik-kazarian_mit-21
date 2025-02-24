public class Account
{
    private double balance;
    private String accountNumber;

    public Account(String accountNumber)
    {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public void addMoney(double amount)
    {
        balance += amount;
        System.out.println("Added amount: " + amount);
        System.out.println("Current Balance: " + balance);
    }

    public void reduceMoney(double amount)
    {
        balance -= amount;
        System.out.println("Reduced amount: " + amount);
        System.out.println("Current Balance: " + balance);
    }

    public void displayAccountInfo()
    {
        System.out.println("Account number: " + accountNumber +
                            "\nBalance: " + balance);
    }
}
