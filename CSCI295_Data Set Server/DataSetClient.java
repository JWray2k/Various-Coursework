
import java.net.Socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;

import java.util.Scanner;

public class DataSetClient {

    private Socket socket;
    private InputStream inStream;
    private OutputStream outStream;
    private Scanner fromServer;
    private PrintWriter toServer;
    String serverUrl;
    int serverPort;

    public DataSetClient(String url, int port) {
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

    public double maxCommand() throws IOException {
        socket = new Socket(serverUrl, serverPort);
        inStream = socket.getInputStream();
        outStream = socket.getOutputStream();
        fromServer = new Scanner(inStream);
        toServer = new PrintWriter(outStream);

        String request = "MAX\n";

        toServer.print(request);
        toServer.flush();

        double maximum = fromServer.nextDouble();

        socket.close();
        return maximum;
    }

    public double avgCommand() throws IOException {
        socket = new Socket(serverUrl, serverPort);
        inStream = socket.getInputStream();
        outStream = socket.getOutputStream();
        fromServer = new Scanner(inStream);
        toServer = new PrintWriter(outStream);

        String request = "AVG\n";

        toServer.print(request);
        toServer.flush();

        double average = fromServer.nextDouble();

        socket.close();
        return average;
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
