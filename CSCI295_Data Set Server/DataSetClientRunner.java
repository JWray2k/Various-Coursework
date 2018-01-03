
import java.io.IOException;
import java.util.Scanner;

public class DataSetClientRunner {

    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);
        String hostName;
        
        // Create a new client
        if(args.length == 1){
            hostName = args[0];
        } else {
            hostName = "127.0.0.1";// can also use "localhost"
        }
        
        DataSetClient dsClient = new DataSetClient(hostName, 9000);

        System.out.print("What would you like to do:\n"
                + "\t1) Add a number\n"
                + "\t2) Get average\n"
                + "\t3) Get maximum\n"
                + "\t4) Stop the server\n\n");

        double number;
        int choice;
        do {
            System.out.print("Choice: ");
            choice = console.nextInt();
        } while(choice < 1 || choice > 4);

        if(choice == 1){
                System.out.print("Enter number: ");
                number = console.nextDouble();
                dsClient.addCommand(number);
         } else if(choice == 2){
                number = dsClient.avgCommand();
                System.out.println("Average is " + number);
         } else if(choice == 3){
                number = dsClient.maxCommand();
                System.out.println("Maximum is " + number);
         } else { // must be 4
                System.out.println("");
                dsClient.stopserverCommand();
        }
        
    }
}
