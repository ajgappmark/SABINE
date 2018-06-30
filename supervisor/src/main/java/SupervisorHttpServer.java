import com.sun.net.httpserver.HttpServer;
import handler.HandlerData;
import handler.HandlerDefault;
import handler.HandlerPing;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Objects;

public class SupervisorHttpServer {
    private HttpServer httpServer;
    private int port;
    private InetSocketAddress address;

    /**
     * TODO: dynamic context
     * TODO: multithreading
     *
     * @param port port
     * @throws IOException
     */
    public SupervisorHttpServer(int port) throws IOException {
        this.port = port;
        address = new InetSocketAddress(port);
        httpServer = HttpServer.create(address, 0);
        httpServer.createContext("/", new HandlerDefault());
        httpServer.createContext("/ping", new HandlerPing());
        httpServer.createContext("/data", new HandlerData());
        httpServer.setExecutor(null);
    }

    public void start() {
        httpServer.start();
    }

    public void stop(int delay) {
        httpServer.stop(delay);
    }

    public int getPort() {
        return port;
    }

    public InetSocketAddress getAddress() {
        return address;
    }

    public String getAddressString() {
        return address.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupervisorHttpServer server = (SupervisorHttpServer) o;
        return port == server.port &&
                Objects.equals(address, server.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(port, address);
    }

}
