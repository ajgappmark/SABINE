package supervisor.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.URI;
import java.util.HashMap;

public class HandlerPing implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        HashMap<String, String> POST;

        StringBuilder response = new StringBuilder();

        POST = util.getPOSTFromHttpExchange(httpExchange);

        for (String key : POST.keySet()) {
            response.append(key).append(" = ").append(POST.get(key)).append("\n");
        }

        util.sendResponse(httpExchange, response.toString());

    }


}
