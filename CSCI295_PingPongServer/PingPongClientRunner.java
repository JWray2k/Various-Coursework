
import java.io.IOException;

public class PingPongClientRunner {

    private static final int PORT_NUMBER = 2020;

    public static void main(String[] args) throws IOException {
        String hostName;

        if (args.length == 1){
            hostName = args[0];
        } else {
            hostName = "localhost";
        }
        // Create a new client
        PingPongClient ppClient = new PingPongClient(hostName, PORT_NUMBER);

        ppClient.connect();
    }
}
