package org.inria.restlet.TP5Resto.backend;

public class Buffet {

	private Bac bac_poisson;
	private Bac bac_viande;
	private Bac bac_legumes;
	private Bac bac_nouilles;
	
	
	
	public Buffet(int bac_poisson, int bac_viande, int bac_legumes, int bac_nouilles) {
		super();
		this.bac_poisson = new Bac(bac_poisson);
		this.bac_viande = new Bac(bac_viande);
		this.bac_legumes = new Bac(bac_legumes);
		this.bac_nouilles = new Bac(bac_nouilles);
	}


	public Bac getBac_poisson() {
		return bac_poisson;
	}


	public Bac getBac_viande() {
		return bac_viande;
	}


	public Bac getBac_legumes() {
		return bac_legumes;
	}


	public Bac getBac_nouilles() {
		return bac_nouilles;
	}


	public void setBac_poisson(Bac bac_poisson) {
		this.bac_poisson = bac_poisson;
	}


	public void setBac_viande(Bac bac_viande) {
		this.bac_viande = bac_viande;
	}


	public void setBac_legumes(Bac bac_legumes) {
		this.bac_legumes = bac_legumes;
	}


	public void setBac_nouilles(Bac bac_nouilles) {
		this.bac_nouilles = bac_nouilles;
	}
	

}
