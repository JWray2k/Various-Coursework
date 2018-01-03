
import java.io.IOException;

/**
 * This class simply creates a DataSetServer object
 * and starts it.
 */
public class DataSetServerRunner {

    public static void main(String[] args) throws IOException {
        int portNumber = 9000;
        DataSetServer dsServer = new DataSetServer(portNumber);
        dsServer.listen();

    }
}
