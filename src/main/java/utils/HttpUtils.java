package utils;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HttpUtils {

    private static final String TOKEN = "Bearer 8e444044-04c9-45c3-a3a9-ab2724991821";
    
    public static String fetchData(String _url) throws MalformedURLException, IOException {
        URL url = new URL(_url);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        //con.setRequestProperty("Accept", "application/json;charset=UTF-8");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("User-Agent", "server");

        Scanner scan = new Scanner(con.getInputStream());
        String jsonStr = null;
        if (scan.hasNext()) {
            jsonStr = scan.nextLine();
        }
        scan.close();
        return jsonStr;
    }

    public static String fetchDataWithToken(String _url) throws MalformedURLException, IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(_url).addHeader("Content-Type" , "application/json").addHeader("Authorization", "Bearer 8e444044-04c9-45c3-a3a9-ab2724991821").build();
        Response response = client.newCall(request).execute();
        String jsonResponse = response.body().string();
        
        return jsonResponse;
    }
     public static String fetchDataWithToken2(String _url, String token) throws MalformedURLException, IOException {
        URL url = new URL(_url);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json;charset=UTF-8");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("Authorization", "bearer " + token);
        //con.setRequestProperty("User-Agent", "server");
        Scanner scan = new Scanner(con.getInputStream());
        String jsonStr = null;
        BufferedReader in = new BufferedReader(
        new InputStreamReader(con.getInputStream()));
        
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
        content.append(inputLine);
        }
        
        in.close();
        scan.close();
         
        return jsonStr;
    }

}
