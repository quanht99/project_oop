package controller;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class googleAPI {

    public static String getAPI(String langFrom, String langTo, String text) throws JSONException {
        if (text.length() < 1) {
            return "";
        }
        StringBuilder content = new StringBuilder();
        try {
            String urlText = "https://translate.googleapis.com/translate_a/single?client=gtx&sl=" + langFrom
                    + "&tl=" + langTo
                    + "&dt=t&q=" + text;
            URL url = new URL(urlText);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 5.1; rv:19.0) Gecko/20100101 Firefox/19.0");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            //Alertapp.ErrorNetwork();
            System.out.println(e);
            return "";
        }
        return content.toString().split("\"", -1)[1];
    }
}

