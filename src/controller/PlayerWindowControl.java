package controller;

import java.awt.Dimension;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;




import model.PlayerWindowModel;
import model.TranscriptionWindowModel;



import specialclasses.SubTitleDb;
import uk.co.caprica.vlcj.binding.internal.libvlc_media_t;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventListener;
import uk.co.caprica.vlcj.player.events.VideoOutputEventListener;

import view.Database;
import view.PlayWindow;
import view.PlayerWindow;
import view.SubTitleWindow;
import view.TranscriptionWindow;



@SuppressWarnings("deprecation")
public class PlayerWindowControl {
    
    private PlayerWindow playerwindow;    
    private PlayerWindowModel playerwindowmodel;  
    //private TranscriptionWindowModel transcriptionwindowmodel;
    private Database database;
    private int i = 0; // F�r Datenbankschleife
    private long[] importantValue;
    //private Zeit zeit;
    private getTime gt;
    
    
    
    public PlayerWindowControl() {
       	playerwindow = new PlayerWindow();    	
    	playerwindowmodel = new PlayerWindowModel();
    	//zeit = new Zeit();    	
    	addListener();
    	gt = new getTime();
    	database = new Database();
    	
		
    	
    	
    }
    
    
    private void addListener() {
    	
    	
    	this.playerwindow.setListenerVideoOutput(new playerWindowListener1());
    	this.playerwindow.setListenerWindow(new playerWindowListener2());
    	this.playerwindow.setListenerMediaPlayer(new playerWindowListener3());
    	this.playerwindow.setListenerCanvas(new playerwindowListener4());
    }
    
    
    
        

    	
    	class playerWindowListener1 implements VideoOutputEventListener{
    		
    		public void videoOutputAvailable(MediaPlayer Player, boolean videoOutput) {
		        if(videoOutput) {
		          Dimension size = PlayerWindow.Player.getVideoDimension();
		          if(size != null) {
		            playerwindow.getCanvas().setSize(size.width, size.height);
		            
		            playerwindow.mediaFrame.pack();
		          }
		        }
		      }
    		}
    	
    
    
    class playerWindowListener2 implements WindowListener{
    	
    	
		public void windowActivated(WindowEvent e) {
			
			
		}

		
		public void windowClosed(WindowEvent e) {
			
			PlayerWindow.Player.release();
			playerwindow.getMediaFactory().release();
			
		}

		
		public void windowClosing(WindowEvent e) {
			
			PlayerWindow.Player.release();
	        playerwindow.getMediaFactory().release();
		}

		
		public void windowDeactivated(WindowEvent e) {
			
			
		}

		
		public void windowDeiconified(WindowEvent e) {
		
			
		}

		
		public void windowIconified(WindowEvent e) {
			
			
		}

		
		public void windowOpened(WindowEvent e) {
			
			
		}		    
    }

    class playerWindowListener3 implements MediaPlayerEventListener{
    	
    	public void positionChanged(MediaPlayer Player,float wert)
    	{
    		
		}
		
		public void backward(MediaPlayer arg0) {
		
		}
		
		public void buffering(MediaPlayer arg0) {
			
		}
	
		public void endOfSubItems(MediaPlayer arg0) {
	
		}
		
		public void error(MediaPlayer arg0) {
			
		}
		
		public void finished(MediaPlayer arg0) {
		
		}
		
		public void forward(MediaPlayer arg0) {
			
		}
	
		public void lengthChanged(MediaPlayer arg0, long arg1) {
			
		}
		
		public void mediaChanged(MediaPlayer arg0) {
		
		}
		
		public void mediaDurationChanged(MediaPlayer arg0, long arg1) {
			
		}
		
		public void mediaFreed(MediaPlayer arg0) {
			
		}
		
		public void mediaMetaChanged(MediaPlayer arg0, int arg1) {
	
		}
		
		public void mediaParsedChanged(MediaPlayer arg0, int arg1) {
			
		}
		
		public void mediaStateChanged(MediaPlayer arg0, int arg1) {

		}
		
		public void mediaSubItemAdded(MediaPlayer arg0, libvlc_media_t arg1) {
			
		}
		
		public void newMedia(MediaPlayer arg0) {
			
		}
		
		public void opening(MediaPlayer arg0) {
	
		}
		
		public void pausableChanged(MediaPlayer arg0, int arg1) {
			
		}
		
		public void paused(MediaPlayer mediaPlayer)
		{
			gt.interrupt();
			
			/*
			while(!PlayerWindow.Player.isPlaying())
			{
				//PlayerWindowModel.setPlayTimeFull(fulltime.format(PlayerWindow.Player.getTime() - 3600000));
				//TranscriptionWindowModel.getZeit().setText(PlayerWindowModel.getPlayTimeFull());
				//System.out.println("pause");
			}*/
			
		}
		
		public void playing(MediaPlayer Player) {

			System.out.println("SPIELT!!");
			/**
			 *  Dies startet den Thread von der Klasse 'getTime'
			 */
			if(!gt.isAlive())
			gt.start();
			
			/**
			 * Wenn der Thread durch einen Stopp angehalten wird (interrupted)
			 * so wird er wieder gestartet wenn der Player spielt
			 */
			if(gt.isInterrupted())
				gt.notifyThread();
			/**
			 *  Wenn der Player eine MediaDatei abspielt
			 *  so wird PlayerWindowModel.isPlaying() auf "true" gesetzt,
			 *  andernfalls auf "false"
			 */
			if(PlayerWindow.Player.isPlaying()) 
			{
				PlayerWindowModel.setIsPlaying(true);
				}else 
					{
						PlayerWindowModel.setIsPlaying(false);
					}
			
			
			DateFormat fulltime = new SimpleDateFormat("HH':'mm':'ss':'SSS");
			playerwindowmodel.setFulltime(fulltime);
			
			playerwindowmodel.setPlayer(PlayerWindow.Player);
			
			
			
		    while(PlayerWindow.Player.isPlaying()) 
		    {	
		    	boolean test = false;
		    	try {
		    		
		    			Vector<Vector<Object>> vectorbox = database.getDataVector();
						importantValue = new long[vectorbox.size()];
						if(i < vectorbox.size()) 
						{
							int zaehler = 0;
							
							for(int j=0; j < vectorbox.size();j++) 
							{
								
								
								importantValue[j] = (Long) vectorbox.elementAt(zaehler).elementAt(3);
								zaehler++;
								//System.out.println("Z�hler: " + zaehler);
								//System.out.println("J: " + j);
								
								
							}
							
						}
						

						if(getTime.tplayer() >= importantValue[i]) 
						{
							SubTitleWindow.getNameEingabe().setText(vectorbox.elementAt(i).elementAt(0).toString());
							SubTitleWindow.getTextEingabe().setText(vectorbox.elementAt(i).elementAt(1).toString());
							System.out.println(vectorbox.size());
							System.out.println("change");
								
								if(!test && i < vectorbox.size())
								{	
									System.out.println("vor increment" + i);
									i++;
									System.out.println("nach increment" + i);
									test = true;
								}							
						}
						
					
					
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
				
		    	
		    	PlayerWindowModel.setPlayTime(getTime.t()[0]);
		    	
		    	
		    	/**
		    	 *  Setzt die formartierte Zeit im String vom PlayerWindowModel.
		    	 *  -3.600.000 weil sonst die Uhr auf 12:00:00:000 stehen würde.
		    	 */
		    	PlayerWindowModel.setPlayTimeFull(fulltime.format(getTime.t()[0] - 3600000));
		    	
		    	
		    	
		    	//TranscriptionWindowModel.setWert(PlayerWindowModel.getPlayTimeFull());
		    	/**
		    	 * Setzt den JSlider im Transkriptfenster auf die passende Stelle synchron 
		    	 * mit der aktuellen Position des Videos 
		    	 */
		    	TranscriptionWindow.getVideo().setValue((int)(Player.getPosition()*100));
		    	//System.out.println("Wert: " + TranscriptionWindow.getVideo().getValue());
		    	
		    	PlayWindow.getTimeLabel().setText(PlayerWindowModel.getPlayTimeFull());	
		    	//System.out.println(PlayWindow.getTimeLabel().getText());
		    	/**
		    	 *  Holt sich die formatierte Zeit vom PlayerWindowModel und setzt sie 
		    	 *  in das Label vom Transkriptfenster 
		    	 */
		    	
		    	TranscriptionWindowModel.getZeit().setText(PlayerWindowModel.getPlayTimeFull());				    
		    }		    
		    
		   
		}
		
		public void seekableChanged(MediaPlayer arg0, int arg1) {
			
		}
		
		public void snapshotTaken(MediaPlayer arg0, String arg1) {
			
		}
		
		public void stopped(MediaPlayer arg0) 
		{
			System.out.println("test");
			gt.interrupt();
			System.out.println("haha");
		}
		
		public void subItemFinished(MediaPlayer arg0, int arg1) {
			
		}
		
		public void subItemPlayed(MediaPlayer arg0, int arg1) {
		
		}
		
		public void timeChanged(MediaPlayer arg0, long arg1) {

		}
		
		public void titleChanged(MediaPlayer arg0, int arg1) {
			
		}

		
		public void videoOutput(MediaPlayer arg0, int arg1) {
			
			
		}
    
    }
    
    class playerwindowListener4 implements MouseWheelListener {

		
    	public void mouseWheelMoved(MouseWheelEvent e) {
    		
    		System.out.println("test");
			int notches = e.getWheelRotation();
			int volume = 0;
			//Machts leiser
			if(PlayerWindow.Player.getVolume() <= 200 && notches <0) {
				volume = PlayerWindow.Player.getVolume();
				volume += notches;
			PlayerWindow.Player.setVolume(volume);
			System.out.println("Volume leiser?: " + volume);
			}
			//Machts lauter
			if(PlayerWindow.Player.getVolume() >= 0 && notches >0) 
			{
				
				volume = PlayerWindow.Player.getVolume();
				volume += notches;
				PlayerWindow.Player.setVolume(volume);
				System.out.println("Volume lauter?: " + volume);
			}
    	}
    }
}


