public class WithdrawRunnable implements Runnable{
    private int delay = 1;
    
    private BankAccount account;
    private int amount; // Amount of each withdrawl
    private int count; // Nuber of withdrawls
    
    // Constructor
    public WithdrawRunnable(BankAccount account, int amount, int count){
        this.account = account;
        this.amount = amount;
        this.count = count;
    }
    
    @Override
    public void run() {
        try{
           for(int i = 0; i < count; i++){
               account.withdraw(amount);
               Thread.sleep(delay);
           } 
        } catch (InterruptedException e){
            
        }
    }

}
