/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nimbusds.jose.shaded.json.parser.JSONParser;
import com.nimbusds.jose.shaded.json.parser.ParseException;
import dto.FoodWasteDTO;
import errorhandling.API_Exception;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import utils.HttpUtils;

/**
 *
 * @author Patrick
 */
public class RemoteServerFacade {
    
      private static EntityManagerFactory emf;
      private static RemoteServerFacade instance;
      private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    
   
    public RemoteServerFacade(){}
      /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static RemoteServerFacade getRemoteServerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new RemoteServerFacade();
        }
        return instance;
    }
    
    
    
    
    
    public List<FoodWasteDTO> getAllStoresAndOffers() throws IOException, ParseException, API_Exception{
        
        // Change to take Zip as parameter later in project. For now its just 8000

        
        try {
       
           String url = "https://api.sallinggroup.com/v1/food-waste/?zip=2100"; 
            
           String mitRespons = HttpUtils.fetchDataWithToken(url);
       
           List<Object> obj = (List<Object>) new JSONParser().parse(mitRespons); 
           List<FoodWasteDTO> foodWasteDTOs = new ArrayList<>();

            
            for (Object o : obj){
                foodWasteDTOs.add(GSON.fromJson(o.toString(), FoodWasteDTO.class)); 
                 }
            
           return foodWasteDTOs;
       
        } catch (Exception err){
            throw new API_Exception("Something went wrong. Maybe wrong zip-code");
        }
     
    }
     
     
    public List<FoodWasteDTO> getAllStoresAndOffersByZip(String zip) throws IOException, ParseException, API_Exception{
        
        // Change to take Zip as parameter later in project. For now its just 8000

        
        try {
       
           String url = "https://api.sallinggroup.com/v1/food-waste/?zip=" + zip; 
            
           String mitRespons = HttpUtils.fetchDataWithToken(url);
       
           List<Object> obj = (List<Object>) new JSONParser().parse(mitRespons); 
           List<FoodWasteDTO> foodWasteDTOs = new ArrayList<>();

            
            for (Object o : obj){
                foodWasteDTOs.add(GSON.fromJson(o.toString(), FoodWasteDTO.class)); 
                 }
            
           return foodWasteDTOs;
       
        } catch (Exception err){
            throw new API_Exception("Something went wrong. Maybe wrong zip-code");
        }
     
    }
  
}
