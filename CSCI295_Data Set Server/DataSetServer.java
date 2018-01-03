
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
 * Description: Add an item to the data set
 * Request: ADD doubleValue
 * Response: none
 * 
 * Description: Get the average of all items added so far
 * Request: AVG
 * Response: The average of all items added so far
 * 
 * Description: Get the maximum item added so far
 * Request: MAX
 * Response: The maximum item added so far
 * 
 * @author Kevin
 *
 */
public class DataSetServer {
    // a local dataset (from chapter 7) that the server will use

    private DataSet data;
    private Socket client = null;
    private ServerSocket server = null;
    private Scanner fromClient = null;
    private PrintWriter toClient = null;
    private int connectionCount;

    /**
     * Constructor: Creates a new DataSet and opens a new ServerSocket
     * on port 9000.
     */
    public DataSetServer(int portNumber) throws IOException {
        data = new DataSet();
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
            command = fromClient.next();

            // execute the client's commnad
            if (command.equalsIgnoreCase("ADD")) {
                double item = fromClient.nextDouble();
                System.out.println("Connection " + connectionCount +
                        " added " + item + ".");
                data.add(item);
            }

            if (command.equalsIgnoreCase("AVG")) {
                System.out.println("Connection " + connectionCount +
                        " requested the average.");
                response = "" + data.getAverage();

                toClient.print(response + "\n");
                toClient.flush();
            }

            if (command.equalsIgnoreCase("MAX")) {
                System.out.println("Connection " + connectionCount +
                        " requested the maximum.");
                response = "" + data.getMaximum();

                toClient.print(response + "\n");
                toClient.flush();
            }

            if (command.equalsIgnoreCase("STOPSERVER")) {
                keepRunning = false;
                System.out.println("Connection " + connectionCount +
                        " stoppped the server.");
            }

            client.close();

        } // end of while loop
    } // end of listen() method
}
