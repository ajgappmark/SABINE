package handler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandlerDefaultTest {
    private HandlerDefault d = new HandlerDefault();
    private int port = 9950;

    @Test
    void getResponse() {
        assertEquals("<h1>Server start success if you see this message</h1>" + "<h1>Port: " + port + "</h1>", d.getResponse(port));
    }
}