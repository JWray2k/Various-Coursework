public class GreetingThreadTester {
    public static void main(String[] args) {
        GreetingRunnable r1 = new GreetingRunnable("Message A");
        GreetingRunnable r2 = new GreetingRunnable("Message B");
        
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        
        t1.start();
        t2.start();
    }
}
