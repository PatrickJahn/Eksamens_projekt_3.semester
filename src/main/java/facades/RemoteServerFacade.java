/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.persistence.EntityManagerFactory;

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
    
    
    
    // Sequntial metode til at hente film
  
    
    
     
   
     
    /*
     * Denne metode anvender en executor og futures, til at tildele threads opgaver.
     * Tager argumenterne: urls som er en liste af alle de urls man vil hente data fra.
     * og et ExecutorService til at håndtere trådene.
     */
   
     
     
     
    /*
     * Denne metode anvender en executor og futures, til at tildele threads opgaver.
     * Tager argumenterne: urls som er en liste af alle de urls man vil hente data fra.
     * og et ExecutorService til at håndtere trådene.
     */
   
}
