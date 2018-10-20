package controller;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/*
en, vi
 */
public class googleAPI {
    public static String getAPI(String langFrom, String langTo, String word) throws JSONException {
        if (word.length() < 1) {
            return "";
        }
        System.out.println(word);
        String text = word.replace(" ", "%20");
        System.out.println(text);
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
        JSONArray json = new JSONArray(content.toString());
        JSONArray jsonResult = (JSONArray) json.get(0);
        String result = "";
        for (int i = 0; i < jsonResult.length(); i++) {
            JSONArray arrayBlock = (JSONArray) jsonResult.get(i);
            result += arrayBlock.get(0).toString();
        }
        return result;
    }
}

