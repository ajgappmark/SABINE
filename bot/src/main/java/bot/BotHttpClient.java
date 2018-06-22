package bot;

import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.util.HashMap;

public class BotHttpClient {

    public static String GET(String url) throws IOException {
        return Request.Get(url).execute().returnContent().asString();
    }

    public static String POST(String url, HashMap<String, String> form) throws IOException {
        Form f = Form.form();
        for (String key : form.keySet()) {
            f.add(key, form.get(key));
        }
        return Request.Post(url).bodyForm(f.build()).execute().returnContent().asString();
    }

}
