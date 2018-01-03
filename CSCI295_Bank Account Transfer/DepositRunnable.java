public class DepositRunnable implements Runnable{
    private int delay = 1;
    
    private BankAccount account;
    private int amount; // Amount of each deposit
    private int count; // Nuber of deposits
    
    // Constructor
    public DepositRunnable(BankAccount account, int amount, int count){
        this.account = account;
        this.amount = amount;
        this.count = count;
    }
    
    @Override
    public void run() {
        try{
           for(int i = 0; i < count; i++){
               account.deposit(amount);
               Thread.sleep(delay);
           } 
        } catch (InterruptedException e){
            
        }
    }

}
