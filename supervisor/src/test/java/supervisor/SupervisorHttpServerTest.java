package supervisor;

import junit.framework.TestCase;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.net.InetSocketAddress;

import static org.junit.jupiter.api.Assertions.*;

class SupervisorHttpServerTest {
    private SupervisorHttpServer server;
    private int port = 9950;

    @BeforeEach
    void setUp() throws IOException {
        server = new SupervisorHttpServer(port);
        server.start();
    }

    @AfterEach
    void tearDown() {
        server.stop(0);
    }

    @Test
    void startErrorPortInvalid() {
        assertThrows(IOException.class, () -> new SupervisorHttpServer(22));
    }

    @Test
    void startErrorBindAddress() {
        assertThrows(java.net.BindException.class, () -> new SupervisorHttpServer(9950));
    }

    @Test
    void start() {
        assertDoesNotThrow(() -> new SupervisorHttpServer(9951));
    }

    @Test
    void getPort() {
        assertEquals(port, server.getPort());
    }

    @Test
    void getAddress() {
        assertEquals(new InetSocketAddress(port), server.getAddress());
    }

    @Test
    void getAddressString() {
        assertEquals(new InetSocketAddress(port).toString(), server.getAddressString());
    }

}