package supervisor;

import java.io.IOException;

public class Supervisor {

    public static void main(String[] args) {
        try {
            SupervisorHttpServer server = new SupervisorHttpServer(8080);
            int port = server.getPort();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
