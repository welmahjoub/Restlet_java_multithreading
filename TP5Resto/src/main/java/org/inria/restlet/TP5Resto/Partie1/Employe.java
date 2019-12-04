package org.inria.restlet.TP5Resto.Partie1;

public class Employe extends Thread {
	
	private Buffet buffet;
	private final int QTE_A_DESPOSER =1000;

	public Employe(Buffet buffet) {
		this.buffet=buffet;
		this.setDaemon(true);
	}
	
	
	
	@Override
	public void run() {
		while (true) {
			
			buffet.getBac_poisson().remplirBac(QTE_A_DESPOSER);
			buffet.getBac_viande().remplirBac(QTE_A_DESPOSER);
			buffet.getBac_legumes().remplirBac(QTE_A_DESPOSER);
			buffet.getBac_nouilles().remplirBac(QTE_A_DESPOSER);
			
		}
	}
}
