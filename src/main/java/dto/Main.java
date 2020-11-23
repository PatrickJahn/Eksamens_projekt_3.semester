/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import java.io.IOException;
import java.util.List;
import utils.HttpUtils;
import com.squareup.okhttp.Response;

/**
 *
 * @author Madsj
 */
public class Main {
    
    private static final Gson GSON = new GsonBuilder().setLenient().setPrettyPrinting().create();
    public static void main(String[] args) throws IOException {
        
        
        String token = "8e444044-04c9-45c3-a3a9-ab2724991821";
        String url = "https://api.sallinggroup.com/v1/food-waste/?zip=8000";

        String yoyoyo = (HttpUtils.fetchDataWithToken2(url, token));
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(url).addHeader("Content-Type" , "application/json").addHeader("Authorization", "Bearer 8e444044-04c9-45c3-a3a9-ab2724991821").build();
        Response response = client.newCall(request).execute();
        //System.out.println(response.body().string());
        String mitRespons = response.body().string();
        mitRespons = mitRespons.substring(1, mitRespons.length() - 1);
            
        System.out.println(mitRespons);
        JsonObject jsonObject = new JsonParser().parse(mitRespons).getAsJsonObject();
        FoodWasteDTO fwwDTO = GSON.fromJson(mitRespons, FoodWasteDTO.class);
    }
}
