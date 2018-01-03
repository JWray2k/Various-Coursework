/*
 * Jonathan Wray
 * CSCI-295: HW13
 * Dec 2, 2016
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;


/**
 * Opens a port and listens for calculation requests and provides
 * appropriate responses using the same port.
 * 
 * Requests and responses are both strings. The following protocol
 * is used:
 * 
 * //I think I'll keep this enabled so that I can generate new numbers (that'd be cool)
 * Description: The guessing game loop is started with a set of low and high numbers
 * Request: PLAY
 * Response: generated a low number and high number and tells the player to guess a secret number
 * 
 * Description: Guess a number between the low and high values and recieve a response
 * Request: GUESS doubleValue //this is a pretty essential piece of infomation
 * Response: Too high, too low, or a match (which closes the program)
 * 
 * Description: Tells the Server to stop running
 * Request: STOPSEVER
 * Response:
 * 
 * @author John
 *
 */


public class GuessingGameServer {

    private Socket client = null;
    private ServerSocket server = null;
    private Scanner fromClient = null;
    private PrintWriter toClient = null;
    private int connectionCount; //not sure if I need this either
    private int lowNumber;
    private int highNumber;
    private int secretNumber;
    

    /**
     * Constructor: Creates a new DataSet and opens a new ServerSocket
     * on port 9000.
     * @param portNumber //I don't really understand these tags
     * @throws java.io.IOException
    */
    
    public GuessingGameServer(int portNumber) throws IOException {
        //data = new DataSet(); //I don't need this - I'll create my numbers on the spot rather than making a new class
        server = new ServerSocket(portNumber);
        connectionCount = 0;
        System.out.println("Server Started.");
    }


    // Start Listening
    public void listen() throws IOException {
        String command; // command from a connected client
        //String response; // response sent back to the client - am I using toClient instead?
        boolean keepRunning = true;
        while (keepRunning) {
            // wait for a connection from a client
            client = server.accept();

            // a connection was made
            connectionCount++;
            System.out.print("Accepted connection " + connectionCount + ".  ");

            fromClient = new Scanner(client.getInputStream());
            toClient = new PrintWriter(client.getOutputStream());

            // get the command from the client
            command = fromClient.next(); //the client is the one who sends the commands

            // execute the client's commnad
            if (command.equalsIgnoreCase("PLAY")) {
                double guess = fromClient.nextDouble();
                System.out.println("Connection " + connectionCount +
                        " added " + guess + ".");
                
                //generate a low number between 1 and 50
                Random randLow = new Random();
                lowNumber = randLow.nextInt(50) + 1;
                
                //generate a high number between lowNumber and 100
                Random randHigh = new Random();
                highNumber = randHigh.nextInt(100) + lowNumber;
                
                //generate a secret number between the highNumber and lowNumber
                Random randSecret = new Random();
                secretNumber = randSecret.nextInt(highNumber) + lowNumber;
                
                toClient.print("You will have to guess a number between " + lowNumber + " and " + highNumber);
                toClient.flush();
 
                //data.add(item); - instead of adding items, I need to recieve numbers from server
            }

            if (command.equalsIgnoreCase("GUESS")) { //do I need to parse my clent entry and generate the n on the command entry?
                toClient.print("Guess a number between " + lowNumber + " and " + highNumber);
                double guess = fromClient.nextDouble();
                System.out.println("Connection " + connectionCount +
                        " added " + guess + ".");
                if (guess == secretNumber){
                    keepRunning = false;
                    System.out.println("Connection " + connectionCount +
                        " stopped the server."); //not sure I need this connectionCount thing...
                }
                else if(guess < secretNumber){
                    toClient.print("Your guess is too low.\n");
                    toClient.flush();
                }
                else if(guess > secretNumber){
                    toClient.print("Your guess is too high.\n");
                    toClient.flush();
                }
                //System.out.println("Connection " + connectionCount +
                //        " sent a guess.");
                //response = "" + guessCommand(); //not sure if this is how I should be doing the guess command

//literally only need to figure out how n is being handled and how I do this method call
//I need to figure out if the method call itself handles the while loop, or if it's in this command section
            }
            
            //this can stay the same
            if (command.equalsIgnoreCase("STOPSERVER")) {
                keepRunning = false;
                System.out.println("Connection " + connectionCount +
                        " stopped the server.");
            }

            //playGame();

            client.close();

        } // end of while loop
    } // end of listen() method
}
    
    //not sure if I'll need a playGame()
    
//    private void playGame() {
//        String inMessage; // command from a connected socket
//        String outMessage; // response sent back to the socket
//        int count = 0;
        //the below needs to consider the inMessages and outMessages. It will stop
        //when the message 19 is recieved by the client - or if a message 29 is sent
        //by the server to the client
        
//        while (count < 5) {
//            outMessage = "Ping_" + (count + 1);
//            count++;
//            toClient.print(outMessage + "\n");
//            toClient.flush();
//            // get the message from the socket
//
//            inMessage = fromClient.next();
//            System.out.println("Server: received " + inMessage);
//        }
//    } // end PlayGame()
    
//}


/*
public class GuessingGameServer {
    
    private Socket socket = null;
    private ServerSocket server = null;
    private Scanner fromClient = null;
    private PrintWriter toClient = null;
    private static final int PORT_NUMBER = 1337;

     public GuessingGameServer() throws IOException {
        server = new ServerSocket(PORT_NUMBER);
    }
     
      // Start Listening
    public void listen() throws IOException {
        System.out.println("Server: Waiting for connection...");
        // wait for a connection from a socket
        socket = server.accept();
        System.out.println("Server: Connection accepted.");
        //generate low number
        //generate high number
        //generate a secret number between low and high

        // a connection was made
        fromClient = new Scanner(socket.getInputStream());
        toClient = new PrintWriter(socket.getOutputStream());

        playGame();

        socket.close();
    }
    
     private void playGame() {
        String inMessage; // command from a connected socket
        String outMessage; // response sent back to the socket
        int count = 0;
        //the below needs to consider the inMessages and outMessages. It will stop
        //when the message 19 is recieved by the client - or if a message 29 is sent
        //by the server to the client
        
//        while (count < 5) {
//            outMessage = "Ping_" + (count + 1);
//            count++;
//            toClient.print(outMessage + "\n");
//            toClient.flush();
//            // get the message from the socket
//
//            inMessage = fromClient.next();
//            System.out.println("Server: received " + inMessage);
//        }
    } // end PlayGame()

    
}

/*

import java.net.ServerSocket;
import java.net.Socket;

import java.io.PrintWriter;
import java.io.IOException;

import java.util.Scanner;

/**
 * Opens a port and listens for calculation requests and provides
 * appropriate responses using the same port.
 * 
 * Requests and responses are both strings. The following protocol
 * is used:
 * 
 * //I think I'll keep this enabled so that I can generate new numbers (that'd be cool)
 * Description: The guessing game loop is started with a set of low and high numbers
 * Request: PLAY
 * Response: generated a low number and high number and tells the player to guess a secret number
 * 
 * Description: Guess a number between the low and high values and recieve a response
 * Request: GUESS doubleValue //this is a pretty essential piece of infomation
 * Response: Too high, too low, or a match (which closes the program)
 * 
 * Description: Tells the Server to stop running
 * Request: STOPSEVER
 * Response:
 * 
 * @author John
 *
 */

    /*
public class GuessingGameServer {

    private DataSet data; //pretty sure I don't need this
    private Socket client = null;
    private ServerSocket server = null;
    private Scanner fromClient = null;
    private PrintWriter toClient = null;
    private int connectionCount; //not sure if I need this either

    /**
     * Constructor: Creates a new DataSet and opens a new ServerSocket
     * on port 9000.
    =?
    public DataSetServer(int portNumber) throws IOException {
        data = new DataSet(); //I don't need this - I'll create my numbers on the spot rather than making a new class
        server = new ServerSocket(portNumber);
        connectionCount = 0;
        System.out.println("Server Started.");
    }


    // Start Listening
    public void listen() throws IOException {
        String command; // command from a connected client
        String response; // response sent back to the client
        boolean keepRunning = true;
        while (keepRunning) {
            // wait for a connection from a client
            client = server.accept();

            // a connection was made
            connectionCount++;
            System.out.print("Accepted connection " + connectionCount + ".  ");

            fromClient = new Scanner(client.getInputStream());
            toClient = new PrintWriter(client.getOutputStream());

            // get the command from the client
            command = fromClient.next(); //the client is the one who sends the commands

            // execute the client's commnad
            if (command.equalsIgnoreCase("PLAY")) {
                double item = fromClient.nextDouble();
                System.out.println("Connection " + connectionCount +
                        " added " + item + ".");
                data.add(item);
            }


            if (command.equalsIgnoreCase("GUESS")) { //do I need to parse my clent entry and generate the n on the command entry?
                System.out.println("Connection " + connectionCount +
                        " sent a guess.");
                response = "" + guessCommand(); //not sure if this is how I should be doing the guess command

//literally only need to figure out how n is being handled and how I do this method call
//I need to figure out if the method call itself handles the while loop, or if it's in this command section

                toClient.print(response + "\n");
                toClient.flush();
            }
            
            //this can stay the same
            if (command.equalsIgnoreCase("STOPSERVER")) {
                keepRunning = false;
                System.out.println("Connection " + connectionCount +
                        " stopped the server.");
            }

            PlayGame();

            client.close();

        } // end of while loop
    } // end of listen() method
}

*/