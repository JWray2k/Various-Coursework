
import java.io.IOException;

/**
 * This class simply creates a PingPongServer object
 * and starts it.
 */
public class PingPongServerRunner {

    public static void main(String[] args) throws IOException {
        PingPongServer ppServer = new PingPongServer();
        ppServer.listen();

    }
}
