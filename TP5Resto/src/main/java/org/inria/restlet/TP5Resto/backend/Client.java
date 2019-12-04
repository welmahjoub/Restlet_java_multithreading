package org.inria.restlet.TP5Resto.backend;

public class Client extends Thread {

	private Restaurant resto;
	private String etat="WAITING TO ENTER";
	private int id;
	
	
public Client(Restaurant resto,int id) {
		super();
		this.resto = resto;
		this.id=id;
	}

@Override
public void run() {
	try {
		
		resto.entrerRestaurant();
		Buffet buffet = resto.getBuffet();
		StandCuisson stand = resto.getStandCuison();
		
		int qte_poisson =  0 + ( (int)Math.random()  * (100-0) ); 
		int qte_legumes = (int) (Math.random() * 100);
		int qte_viande = (int) (Math.random() * 100);
		int qte_nouille = (int) (Math.random() * 100);
		
		//Remplir son assiette
		
		etat="AT THE BUFFET";
		buffet.getBac_poisson().consommer(qte_poisson);
		buffet.getBac_viande().consommer(qte_viande);
		buffet.getBac_legumes().consommer(qte_legumes);
		buffet.getBac_nouilles().consommer(qte_nouille);
		
		//Partir Au stand de cuisson
		
		etat="WAITING THE COOK";
		stand.deposerAssiete();
		
		//Manger
		etat="EATING";
		Thread.sleep(5000);
		
		//Sortir du resto
		etat="OUT";
		resto.sortirRestaurant();
		
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
}
public String getEtat()
{
	return etat;
}
}
