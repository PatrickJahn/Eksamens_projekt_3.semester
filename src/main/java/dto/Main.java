/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nimbusds.jose.shaded.json.JSONArray;
import com.nimbusds.jose.shaded.json.JSONObject;
import com.nimbusds.jose.shaded.json.parser.JSONParser;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import java.io.IOException;
import utils.HttpUtils;
import com.squareup.okhttp.Response;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Madsj
 */
public class Main {
    
    private static final Gson GSON = new GsonBuilder().setLenient().setPrettyPrinting().create();
    public static void main(String[] args) throws IOException, com.nimbusds.jose.shaded.json.parser.ParseException {
        
        
        String token = "8e444044-04c9-45c3-a3a9-ab2724991821";
        String url = "https://api.sallinggroup.com/v1/food-waste/?zip=8000";

        String yoyoyo = (HttpUtils.fetchDataWithToken2(url, token));
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(url).addHeader("Content-Type" , "application/json").addHeader("Authorization", "Bearer 8e444044-04c9-45c3-a3a9-ab2724991821").build();
        Response response = client.newCall(request).execute();
        String mitRespons = response.body().string();
       // mitRespons = mitRespons.substring(1, mitRespons.length() - 1);
            
      
       List<Object> obj = (List<Object>) new JSONParser().parse(mitRespons); 
    
       List<FoodWasteDTO> foodWasteDTOs = new ArrayList<>();
       
       for (Object o : obj){
         foodWasteDTOs.add(GSON.fromJson(o.toString(), FoodWasteDTO.class)); 
       }
       
       // Så skal vi bare retunere foodWasteDTOs
      
       
    }
}
