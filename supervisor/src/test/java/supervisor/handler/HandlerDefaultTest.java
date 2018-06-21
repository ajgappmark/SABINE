package supervisor.handler;

import junit.framework.TestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandlerDefaultTest extends TestCase {
    private HandlerDefault d = new HandlerDefault();
    private int port = 9950;

    @Test
    void getResponse() {
        assertEquals("<h1>Server start success if you see this message</h1>" + "<h1>Port: " + port + "</h1>", d.getResponse(port));
    }
}