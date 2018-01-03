/*
 * Jonathan Wray
 * CSCI-295: HW13
 * Dec 2, 2016
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


/**
 *
 * @author jw91482
 */

public class GuessingGameClient {

    private Socket socket;
    private InputStream inStream;
    private OutputStream outStream;
    private Scanner fromServer;
    private PrintWriter toServer;
    String serverUrl;
    int serverPort;

    public GuessingGameClient(String url, int port) {
        serverUrl = url;
        serverPort = port;
    }

    public void addCommand(double item) throws IOException {
        socket = new Socket(serverUrl, serverPort);
        outStream = socket.getOutputStream();
        toServer = new PrintWriter(outStream);

        String request = "ADD " + item + "\n";

        toServer.print(request);
        toServer.flush();
        socket.close();
    }

    //for the below, I either need to make another method call within this method, or I need to convert all the numbers to strings and back
    public double guessCommand() throws IOException {
        socket = new Socket(serverUrl, serverPort);
        inStream = socket.getInputStream();
        outStream = socket.getOutputStream();
        fromServer = new Scanner(inStream);
        toServer = new PrintWriter(outStream);

        String request = "GUESS\n";

        toServer.print(request);
        toServer.flush();

        String response = fromServer.nextString();

        socket.close();
        return response; //string cannot be converted to a double
    }

    public double generateNumbers() throws IOException {
        socket = new Socket(serverUrl, serverPort);
        inStream = socket.getInputStream();
        outStream = socket.getOutputStream();
        fromServer = new Scanner(inStream);
        toServer = new PrintWriter(outStream);

        String request = "PLAY\n";

        toServer.print(request);
        toServer.flush();

        String response = fromServer.nextString(); //maybe this shoud be an array - unsure... I need both numbers (maybe the server can just store these)

        socket.close();
        return response;
        
//        double maximum = fromServer.nextDouble();
//
//        socket.close();
//        return maximum;
    }

    public void stopserverCommand() throws IOException {
        socket = new Socket(serverUrl, serverPort);
        //inStream = socket.getInputStream();
        outStream = socket.getOutputStream();
        //fromServer = new Scanner(inStream);
        toServer = new PrintWriter(outStream);

        String request = "STOPSERVER\n";

        toServer.print(request);
        toServer.flush();

        socket.close();
    }
}
