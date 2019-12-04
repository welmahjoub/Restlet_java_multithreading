package org.inria.restlet.TP5Resto.backend;

/**
 *
 * Backend for all resources.
 * 
 * @author ctedeschi
 * @author msimonin
 *
 */
public class Backend
{
    /** Database.*/
    private Restaurant resto;

    public Backend()
    {
    	
    	try {
    		resto = new Restaurant();
			resto.lancer();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
    }

    public Restaurant getResto()
    {
        return resto;
    }

}
