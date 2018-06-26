package bot;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.util.HashMap;

public class Bot {

    public static void main(String[] args) {
        try {
            HashMap<String, String> h = new HashMap<>();
            h.put("id", "neon");
            h.put("ip", "localhost");
            h.put("hostname", "neon");
            h.put("name", "localhost");
            h.put("OS", "localhost");

            String response = BotHttpClient.POST("http://localhost:9950/ping", h);

            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
