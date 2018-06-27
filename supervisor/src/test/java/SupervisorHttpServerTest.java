
import java.io.IOException;
import java.net.InetSocketAddress;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SupervisorHttpServerTest {
    private SupervisorHttpServer server;
    private int port = 9950;

    @Before
    public void setUp() throws IOException {
        server = new SupervisorHttpServer(port);
        server.start();
    }

    @After
    public void tearDown() {
        server.stop(0);
    }

    @Test(expected = IOException.class)
    public void startErrorPortInvalid() throws IOException {
       new SupervisorHttpServer(22);
    }

    @Test(expected = java.net.BindException.class)
    public void startErrorBindAddress() throws IOException {
        new SupervisorHttpServer(9950);
    }

    @Test
    public void start() throws IOException {
        new SupervisorHttpServer(9951);
    }

    @Test
    public void getPort() {
        assertEquals(port, server.getPort());
    }

    @Test
    public void getAddress() {
        assertEquals(new InetSocketAddress(port), server.getAddress());
    }

    @Test
    public void getAddressString() {
        assertEquals(new InetSocketAddress(port).toString(), server.getAddressString());
    }

}