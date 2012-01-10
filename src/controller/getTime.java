package controller;

import model.PlayerWindowModel;
import view.PlayerWindow;

public class getTime extends Thread {
	private static long[] currentTime;
	private long timeBefore;
	private static  long t3;
	private long t4;
	private final byte timer = 1; // 1ms
	
	public getTime()
	{
		currentTime = new long[1];
		currentTime[0] = 0;
		timeBefore = 0;
		t3 = 0;
		t4 = 0;
	}
	
	
	
	public void run()
	{
		while( !isInterrupted() ) {
			try {
				sleep(timer);
				
				if(PlayerWindowModel.getIsPlaying() == true) 
				{
					//System.out.println("Bei True: " + PlayerWindowModel.getIsPlaying());
					t3 = PlayerWindow.Player.getTime();
				}
				else 
				{
					t3 = 0;
					t4 = PlayerWindow.Player.getTime();
					//System.out.println("Bei false: " + PlayerWindowModel.getIsPlaying());
				}
								
				//Debug
				//System.out.println("a "+t3);
				//System.out.println("b "+timeBefore);
				//System.out.println("c "+currentTime);
				//System.out.println();
				
				/**
				 * Wenn die Variable "timeBefore" ist gleich der aktuellen Playerzeit
				 * dann wird "currentTime" um 1 erhöht
				 * 
				 * Falls nicht werden "timeBefore" und "currentTime" mit der aktuellen
				 * Playerzeit synchronisiert
				 * Dies hat zur Folge das currentTime ständig gleich mit der Playerzeit ist
				 */
				if(timeBefore == t3) {
					currentTime[0] += timer;
				} else {
					timeBefore = t3;
					currentTime[0] = t3;
				}
				
				if(timeBefore == 0) {
					currentTime[0] = t4;
				}
				
				//debug
				//System.out.println(currentTime[0]);
			} catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public synchronized void notifyThread()
	{
	    notifyAll(); // HIER
	}
	
	public synchronized void waitThread() throws InterruptedException
	{
	    
	}
	
	/* Who says god controls the time? It's me! HAHAHA */
	public static long[] t()
	{
		/* Instead of returning a long, we return an array. That saves us at least one copy process */
		return currentTime;
	}
	
	public static long tplayer() 
	{
		return t3;
	}
}
