package org.inria.restlet.TP5Resto.backend;

import java.util.concurrent.Semaphore;

public class StandCuisson {

	private int nbAssiete;
	private Semaphore semaClient;
	private Semaphore semaCuisinier;
	
	public StandCuisson() {
		nbAssiete=0;
		semaClient=new Semaphore(0);
		semaCuisinier=new Semaphore(0);
		
	}
	
	public synchronized void deposerAssiete() throws InterruptedException
	{
		nbAssiete++;
		
		semaCuisinier.release();//debloquer server => v
		
		System.err.println("client"+nbAssiete);
		semaClient.acquire(); // p sur sema client => wait
		
		//  attendre son assiete
	}
	
	public void cuire() throws InterruptedException
	{
		
		semaCuisinier.acquire();//attend client
		
		Thread.sleep(20); // temps de preparation 
		nbAssiete--; 
		
		System.err.println("cuisine"+nbAssiete);
		
		semaClient.release(); // debloque un client
	
	}
	
}
