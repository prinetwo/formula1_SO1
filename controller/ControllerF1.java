package controller;

import java.util.concurrent.Semaphore;

public class ControllerF1 {
	
	public ControllerF1() {

	}
	
	public void corridaF1(){
		int permissao = 5;
		Semaphore semaforo = new Semaphore(permissao);
		
		for(int i = 0;i < 14;i++){
			Thread t = new ThreadF1(i , semaforo);
			t.start();
		}		
	}
}
