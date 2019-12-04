package org.inria.restlet.TP5Resto.Partie1;

public class Bac {
	
 private int quantite;


 public Bac(int quantite) {
	
	this.quantite = quantite;
}
 
 public synchronized void consommer(int kiloconso) throws InterruptedException {
		
		while(kiloconso > quantite ) {
			wait();
		}
		
		int temps = 200 + ( (int)Math.random()  * (300-200) );
		Thread.sleep(temps);
		quantite= quantite-kiloconso;
		notifyAll();
		
	}
 
 public synchronized void remplirBac(int qteAjouter) {
	 
	 if(quantite <= 100) {
		 
		 quantite = qteAjouter;

		 notifyAll();
	 }
	 
 }
 
}
