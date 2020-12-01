package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nimbusds.jose.shaded.json.parser.ParseException;
import entities.User;
import errorhandling.API_Exception;
import facades.FacadeExample;
import facades.RemoteServerFacade;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import utils.EMF_Creator;

/**
 * @author lam@cphbusiness.dk
 */
@Path("vejret")
public class VejrResource {
    
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final FacadeExample FACADE =  FacadeExample.getFacadeExample(EMF);
   private static final RemoteServerFacade remoteFACADE =  RemoteServerFacade.getRemoteServerFacade(EMF);
    
   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfo() {
        // return other message
        return "{\"msg\":\"Hello anonymous\"}";
    }

    
    
    
    

    
     @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("by/{city}")
    public String getAllFoodWaste(@PathParam("city") String city) throws IOException, ParseException, API_Exception{
        return GSON.toJson(remoteFACADE.getWheaterFromCity(city).getCurrentData());
    }


}