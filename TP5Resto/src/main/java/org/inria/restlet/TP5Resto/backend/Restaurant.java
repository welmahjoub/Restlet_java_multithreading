package org.inria.restlet.TP5Resto.backend;

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
	
	for (int i = 1; i < 51; i++) {
		clients.add(new Client(this,i));
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

public Client getClient(int id)
{
	for (Client client : clients) {
		
		if(client.getIdClient()==id)
			return client;
	}
	return null;
}


}
