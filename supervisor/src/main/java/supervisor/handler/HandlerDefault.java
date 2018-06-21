package supervisor.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class HandlerDefault implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        int port = httpExchange.getLocalAddress().getPort();
        String response = getResponse(port);
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    public String getResponse(int port) {
        return "<h1>Server start success if you see this message</h1>" + "<h1>Port: " + port + "</h1>";
    }
}
