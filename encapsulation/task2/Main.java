public class Main 
{
    public static void main(String[] args)
    {
        Account account = new Account("0000 0000 0000 0001");
        account.displayAccountInfo();
        System.out.println();
        account.addMoney(100.0);
        account.reduceMoney(10.0);
        System.out.println();
        account.displayAccountInfo();
    }
}
