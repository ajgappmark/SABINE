package supervisor;

import com.sun.net.httpserver.HttpServer;
import supervisor.handler.HandlerData;
import supervisor.handler.HandlerDefault;
import supervisor.handler.HandlerPing;

import java.io.IOException;
import java.net.InetSocketAddress;

public class SupervisorHttpServer {
    private HttpServer httpServer;
    private int port;
    private InetSocketAddress address;

    /**
     * TODO: dynamic context
     * TODO: multithreading
     *
     * @param port
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

}
