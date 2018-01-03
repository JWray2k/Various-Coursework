
import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class PingPongServer {

    private Socket socket = null;
    private ServerSocket server = null;
    private Scanner fromClient = null;
    private PrintWriter toClient = null;
    private static final int PORT_NUMBER = 2020;

    public PingPongServer() throws IOException {
        server = new ServerSocket(PORT_NUMBER);
    }

    // Start Listening
    public void listen() throws IOException {
        System.out.println("Server: Waiting for connection...");
        // wait for a connection from a socket
        socket = server.accept();
        System.out.println("Server: Connection accepted.");

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
        while (count < 5) {
            outMessage = "Ping_" + (count + 1);
            count++;
            toClient.print(outMessage + "\n");
            toClient.flush();
            // get the message from the socket

            inMessage = fromClient.next();
            System.out.println("Server: received " + inMessage);
        }
    } // end PlayGame()

}
