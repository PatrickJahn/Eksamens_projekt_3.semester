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
import errorhandling.API_Exception;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Madsj
 */
public class Main {
    
    private static final Gson GSON = new GsonBuilder().setLenient().setPrettyPrinting().create();
    public static void main(String[] args) throws IOException, com.nimbusds.jose.shaded.json.parser.ParseException, API_Exception {
        
        

        String url = "https://api.sallinggroup.com/v1/food-waste/?zip=2300";

       
       
       try {
            
        String mitRespons = HttpUtils.fetchDataWithToken(url);
       
       List<Object> obj = (List<Object>) new JSONParser().parse(mitRespons); 
    
       List<FoodWasteDTO> foodWasteDTOs = new ArrayList<>();
       
       for (Object o : obj){
         foodWasteDTOs.add(GSON.fromJson(o.toString(), FoodWasteDTO.class)); 
       }
       
       } catch (Exception e){
           throw new API_Exception("No data collectet. Perhabs zip is wrong");
       }
       // Så skal vi bare retunere foodWasteDTOs
      
       
    }
}
