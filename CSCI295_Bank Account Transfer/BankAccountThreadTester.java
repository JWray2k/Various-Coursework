public class BankAccountThreadTester {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount();
        int amount = 100;
        int repetition = 1000;
        
        DepositRunnable d = new DepositRunnable(myAccount, amount, repetition);
        WithdrawRunnable w = new WithdrawRunnable(myAccount, amount, repetition);
        
        Thread tD = new Thread(d);
        Thread tW = new Thread(w);
        
        tD.start();
        tW.start();
    }
}
