package org.inria.restlet.TP5Resto.backend;

public class Cuisinier extends Thread{

	private  StandCuisson stand;
	public Cuisinier(StandCuisson stand) {
		this.stand=stand;
		this.setDaemon(true);
	}
	
	@Override
	public void run() {
		while (true) {
			
			try {
				
				stand.cuire();
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
}
