package controller;

import java.util.concurrent.Semaphore;

public class ThreadF1 extends Thread{
	
	private final String EQUIPES[]= {"Mercedes #1", "Mercedes #2", "Ferrari #1", "Ferrari #2", 
			"Willians #1", "Willians #2", "Red Bull #1", "Red Bull #2", "Force India #1", 
			"Force India #2", "McLaren #1", "McLaren #2", "Sauber #1", "Sauber #2"};
	private int tempo[]= new int[14];
	private int idThread;
	private Semaphore semaforo;

	public ThreadF1(int idThread, Semaphore semaforo) {
		this.idThread = idThread;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		try {
			semaforo.acquire();
			correndo();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}
	
	private void correndo(){
		int volta = 1000;
		int distP = 0;
		int t = 0;
		int i = 1;
		int menor = 0;
		
		while(i <= 3){
			distP += (int)(Math.random() * 240) + 20; //O carro anda de 20 a 260km/h
			if(distP >= volta){
				System.out.println("O carro " + EQUIPES[idThread] + " completou a volta " + i + " em "
						+ "" + t + " segundos");
				menor = (t < menor || menor == 0)? t : menor;
				distP = 0;
				t = 0;
				i++;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			t++;
		}
		tempo[idThread] = menor; //menor tempo guradado
		System.out.println("O carro " + EQUIPES[idThread] + " terminou sua qualificacao!!!");
	}	
	
}
