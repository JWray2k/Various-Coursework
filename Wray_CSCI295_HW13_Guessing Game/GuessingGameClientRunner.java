
/*
 * Jonathan Wray
 * CSCI-295: HW13
 * Dec 2, 2016
 */

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author jw91482
 */

public class GuessingGameClientRunner {

    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);
        String hostName;
        
        // Create a new client
        if(args.length == 1){
            hostName = args[0];
        } else {
            hostName = "127.0.0.1";// can also use "localhost"
        }
        
        GuessingGameClient ggClient = new GuessingGameClient(hostName, 9000);

        System.out.print("What would you like to do:\n"
                + "\t11) Request to play game\n"
                + "\t12) Make a guess that the secret number is n\n"
                + "\t19) Stop the game\n");

        double number;
        double lowNumber = 0;
        double highNumber = 0;
        int choice;
        do {
            System.out.print("Choice: ");
            choice = console.nextInt();
        } while(choice == 11 || choice == 12 || choice == 19);

        if(choice == 11){
                System.out.print("Welcome to the Guessing Game! You'll have to figure out a sevret number between the following two numbers: ");
                ggClient.generateNumbers(); //this should be ggServer
                System.out.println("The low is " + lowNumber + ", and the high is " + highNumber);
         } else if(choice == 12){
                number = console.nextDouble();
                ggClient.guessCommand(number); //should be ggClient - but also
         } else { // must be 19
                System.out.println("");
                ggClient.stopserverCommand();
        }
        
    }
}
