package handler;

import com.sun.net.httpserver.HttpExchange;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class util {


    static void sendResponse(HttpExchange httpExchange, String response) throws IOException {
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    public static HashMap<String, String> getPOSTFromHttpExchange(HttpExchange httpExchange) throws IOException {
        HashMap<String, String> post;
        InputStream input = httpExchange.getRequestBody();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
        String line = bufferedReader.readLine();
        post = getPOSTFromString(line);
        bufferedReader.close();
        return post;
    }

    public static HashMap<String, String> getPOSTFromString(String line) {
        HashMap<String, String> post = new HashMap<>();

        String[] lineSplit = line.split("[&=]");
        for (int i = 0; i < lineSplit.length; i++) {
            post.put(lineSplit[i++], lineSplit[i]);
        }
        return post;
    }

    public static String getPrompt() {
        Date d = new Date();
        return "[" + getFormattedDate(d) + "] -> ";
    }

    public static String getFormattedDate(Date d) {
        String format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(d);
    }
}
