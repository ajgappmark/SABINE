package handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class HandlerData implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        System.out.println(util.getPrompt() + "DATA from " + httpExchange.getRemoteAddress().toString());

        String response = "DATA";

        util.sendResponse(httpExchange, response);

    }
}
