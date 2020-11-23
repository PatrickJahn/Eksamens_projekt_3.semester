/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.IOException;
import utils.HttpUtils;

/**
 *
 * @author Madsj
 */
public class Main {

    public static void main(String[] args) throws IOException {
       
        String token = "8e444044-04c9-45c3-a3a9-ab2724991821";
        String url = "https://api.sallinggroup.com/v1/food-waste/?zip=8000";
       
        System.out.println(HttpUtils.fetchDataWithToken(url, token));
        
       
    }
}
