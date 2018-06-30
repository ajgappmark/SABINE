import java.io.IOException;

public class Supervisor {

    public static void main(String[] args) {
        try {
            SupervisorHttpServer server = new SupervisorHttpServer(9950);
            server.start();
            int port = server.getPort();
            System.out.println("Server Http launch on port : " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
