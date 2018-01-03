public class BankAccount {
    private int balance;
    
    public BankAccount(){
        balance = 0;
    }
    
    public int getBalance(){
        return balance;
    }
    
    public void deposit(int amount){
        System.out.println("D - Depositing " + amount + ".");
        int newBalance = balance + amount;
        System.out.println("D - New balance is " + newBalance + ".");
        balance = newBalance;
    }

    public void withdraw(int amount){
        System.out.println("W - Withdrawing " + amount + ".");
        int newBalance = balance - amount;
        System.out.println("W - New balance is " + newBalance + ".");
        balance = newBalance;
    }

}
