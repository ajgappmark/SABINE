package bot;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

public class Bot {

    public static void main(String[] args) {
        try {
            String response = BotHttpClient.GET("http://localhost:9950/ping");
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
