
import java.net.Socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;

import java.util.Scanner;

/**
 * This class connects to a PingPongServer and provides an
 * interface to send properly formatted commands to the server.
 */
public class PingPongClient {

    private Socket socket;
    private InputStream inStream;
    private OutputStream outStream;
    private Scanner fromServer;
    private PrintWriter toServer;
    String serverUrl;
    int serverPort;

    public PingPongClient(String url, int port) {
        serverUrl = url;
        serverPort = port;
    }

    public void connect() throws IOException{
        System.out.println("Client: Requesting connection...");
        socket = new Socket(serverUrl, serverPort);
        System.out.println("Client: Connection confirmed.");
        inStream = socket.getInputStream();
        outStream = socket.getOutputStream();
        fromServer = new Scanner(inStream);
        toServer = new PrintWriter(outStream);

        playGame();

        socket.close();

    }

    private void playGame() {
        String inMessage; // command from a connected client
        String outMessage; // response sent back to the client
        int count = 0;
        while (count < 5) {
            outMessage = "Pong_" + (count + 1);
            count++;
            toServer.print(outMessage + "\n");
            toServer.flush();
            // get the message from the client

            inMessage = fromServer.next();
            System.out.println("Client: received " + inMessage);
        }

    }


}
