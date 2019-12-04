package org.inria.restlet.TP5Resto.resources;

import org.inria.restlet.TP5Resto.backend.Backend;
import org.inria.restlet.TP5Resto.backend.Client;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 *
 * Resource exposing a user.
 *
 * @author msimonin
 * @author ctedeschi
 *O
 */
public class ClientsResource extends ServerResource
{

    /** Backend.*/
    private Backend backend_;

   

    /**
     * Constructor.
     * Call for every single user request.
     */
    public ClientsResource()
    {
        backend_ = (Backend) getApplication().getContext().getAttributes()
                .get("backend");
    }


    @Get("json")
    public Representation getClients() throws Exception
    {
    	String clientIdString = (String) getRequest().getAttributes().get("clientId");
        int clientId = Integer.valueOf(clientIdString);
        Client client = backend_.getResto().getClient(clientId);
        
        JSONObject userObject = new JSONObject();
        if(client != null) {
        userObject.put("id", client.getId());
        userObject.put("etat", client.getEtat());
        }
        
        else {
       	 userObject.put("Client ","Client don't exist");
        }
        
        return new JsonRepresentation(userObject);
      
    }

}
