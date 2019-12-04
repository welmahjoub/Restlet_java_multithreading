package org.inria.restlet.TP5Resto.Partie1;

import java.util.ArrayList;
import java.util.List;

public class Restaurant{
private int nbPlace = 25;
private int nbclient = 50;

private Buffet buffet ;
private StandCuisson stand;
private Cuisinier cuisinier;
private Employe employer;
private List<Client> clients; 

public Restaurant() {
	
	buffet= new Buffet(1000, 1000, 1000, 1000);
	stand=new StandCuisson();
	cuisinier=new Cuisinier(stand);
	employer=new Employe(buffet);
	
	clients =new ArrayList<Client>();
	
	for (int i = 0; i < 50; i++) {
		clients.add(new Client(this));
	}
}

public void lancer() throws InterruptedException {
	
	//Lancer le cuisiner
	cuisinier.start();
	employer.start();
	
	//Lancer les clients
	for (Client client : clients) {
		client.start();
	}
	
	
}

public synchronized void entrerRestaurant() throws InterruptedException {
	
	while(nbPlace<=0) {
		wait();
	}
	
	nbPlace--;
}

public synchronized void sortirRestaurant() throws InterruptedException {

	nbPlace++;
	notifyAll();
}

public Buffet getBuffet() {
	return buffet;
}

public StandCuisson getStandCuison() {
	return stand;
}



public List<Client> getClients() {
	return clients;
}



public static void main(String[] args) throws InterruptedException {
	
	Restaurant r=new Restaurant();
	r.lancer();
	
	int i=1;
	
	
		i=1;
		for (Client c : r.getClients()) {
			
			System.err.println(i+" "+c.getEtat());
			i++;
		}
		
		System.err.println(" --------");
	
	
}
}
