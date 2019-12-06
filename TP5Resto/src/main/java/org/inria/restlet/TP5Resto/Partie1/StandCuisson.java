package org.inria.restlet.TP5Resto.Partie1;

import java.util.concurrent.Semaphore;

public class StandCuisson {

	private int nbAssiete;
	private Semaphore sema;
	
	
	public StandCuisson() {
		nbAssiete=0;
		sema=new Semaphore(0);
	}
	
	public synchronized void deposerAssiete() throws InterruptedException
	{
		nbAssiete++;
		
		sema.acquire();//block
		
	}
	
	public synchronized void cuire() throws InterruptedException
	{
		
		while(nbAssiete<=0)
		{
			sema.acquire();
		}

		nbAssiete--; 
		sema.release();// liberer un client	
		
	}
	
}
