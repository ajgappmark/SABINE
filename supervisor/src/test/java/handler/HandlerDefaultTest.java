package handler;

import org.junit.Test;

import static org.junit.Assert.*;

public class HandlerDefaultTest {
    private HandlerDefault d = new HandlerDefault();
    private int port = 9950;

    @Test
    public void getResponse() {
        assertEquals("<h1>Server start success if you see this message</h1>" + "<h1>Port: " + port + "</h1>", d.getResponse(port));
    }
}