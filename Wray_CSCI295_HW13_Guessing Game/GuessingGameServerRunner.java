/*
 * Jonathan Wray
 * CSCI-295: HW13
 * Dec 2, 2016
 */

import java.io.IOException;

/**
 * This class simply creates a DataSetServer object
 * and starts it.
 */
public class GuessingGameServerRunner {

    public static void main(String[] args) throws IOException {
        int portNumber = 9000;
        GuessingGameServer ggServer = new GuessingGameServer(portNumber);
        ggServer.listen();

    }
}
