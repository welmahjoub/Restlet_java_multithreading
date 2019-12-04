package org.inria.restlet.TP5Resto.backend;

public class StandCuisson {

	private int nbAssiete;
	
	public StandCuisson() {
		nbAssiete=0;
	}
	
	public synchronized void deposerAssiete() throws InterruptedException
	{
		nbAssiete++;
		
		wait();//  attendre son assiete
	}
	
	public synchronized void cuire() throws InterruptedException
	{
		if(nbAssiete>=0)
		{
			Thread.sleep(1000); // temps de preparation 
			nbAssiete--; 
			notify();// liberer un client
		}
		
		
	}
	
}
