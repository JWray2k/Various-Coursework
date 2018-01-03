public class GreetingRunnable implements Runnable {
    private String message; // This will be printed
    
    public GreetingRunnable(String message){
        this.message = message;
    }
    
    @Override
    public void run() {
        try {
            for(int i = 1; i <= 10; i++){
                System.out.println(message);
                Thread.sleep(1000); // One Second
            }
        } catch (InterruptedException e){
            
        }
    }

}
