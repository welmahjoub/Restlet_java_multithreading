package org.inria.restlet.TP5Resto.resources;

import java.util.ArrayList;
import java.util.Collection;

import org.inria.restlet.TP5Resto.backend.Backend;
import org.inria.restlet.TP5Resto.backend.Buffet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * Resource exposing the users
 *
 * @author ctedeschi
 * @author msimonin
 *
 */
public class BuffetResource extends ServerResource
{

    /** Backend. */
    private Backend backend_;

    /**
     * Constructor.
     * Call for every single user request.
     */
    public BuffetResource()
    {
        super();
        backend_ = (Backend) getApplication().getContext().getAttributes()
            .get("backend");
    }

    /**
     *
     * Returns the list of all the users
     *
     * @return  JSON representation of the users
     * @throws JSONException format no supporter
     */
    @Get("json")
    public Representation getBuffets() throws JSONException
    {
    	// recuper le buffet
    	 Buffet buffet=backend_.getResto().getBuffet();
    	
    	 // recuper tous les bacs
    	 
         Collection<JSONObject> jsonBacs = new ArrayList<JSONObject>();

         JSONObject bac_legume = new JSONObject();
         bac_legume.put("name","Bac legumes" );
         bac_legume.put("etat", buffet.getBac_legumes().getQte());
         jsonBacs.add(bac_legume);

         JSONObject bac_viande = new JSONObject();
         bac_viande.put("name","Bac viande" );
         bac_viande.put("etat", buffet.getBac_viande().getQte());
         jsonBacs.add(bac_viande);
         
       
         JSONObject bac_poisson = new JSONObject();
         bac_poisson.put("name","Bac poisson" );
         bac_poisson.put("etat", buffet.getBac_poisson().getQte());
         jsonBacs.add(bac_poisson);

         JSONObject bac_nouilles = new JSONObject();
         bac_nouilles.put("name","Bac nouilles" );
         bac_nouilles.put("etat", buffet.getBac_nouilles().getQte());
         jsonBacs.add(bac_nouilles);
         
         JSONArray jsonArray = new JSONArray(jsonBacs);
         return new JsonRepresentation(jsonArray);
    }

    
}
