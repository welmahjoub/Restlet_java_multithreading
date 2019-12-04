package org.inria.restlet.TP5Resto.application;


import org.inria.restlet.TP5Resto.resources.BuffetResource;
import org.inria.restlet.TP5Resto.resources.ClientsResource;
import org.restlet.Application;
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.routing.Router;

/**
 *
 * Application.
 *
 * @author msimonin
 *
 */
public class MyRestaurantApplication extends Application
{

    public MyRestaurantApplication(Context context)
    {
        super(context);
    }

    @Override
    public Restlet createInboundRoot()
    {
        Router router = new Router(getContext());
        
        router.attach("/buffet", BuffetResource.class);
     
        router.attach("/client/{clientId}", ClientsResource.class);
       
        
        return router;
    }
}
