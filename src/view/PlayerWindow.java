package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import com.sun.jna.NativeLibrary;


import specialclasses.Troubleshooter;
import uk.co.caprica.vlcj.player.MediaPlayerEventListener;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.videosurface.CanvasVideoSurface;
import uk.co.caprica.vlcj.player.events.VideoOutputEventListener;


public class PlayerWindow {

	public JFrame mediaFrame = new JFrame("Videofenster");
	private Canvas canvas = new Canvas();
	private static MediaPlayerFactory mediaFactory;
	public static EmbeddedMediaPlayer Player;

	private CanvasVideoSurface Surface;


	
	private void init() {
		
		//Canvasoberfl�che f�r Videos erstellen		
				getCanvas().setBackground(Color.black);
			    getCanvas().setVisible(true);
			    
			    mediaFrame.add(getCanvas());
				   
			    
			    
			    setMediaFactory(new MediaPlayerFactory());
			    Player = getMediaFactory().newEmbeddedMediaPlayer();
			    
			    
			    Surface = getMediaFactory().newVideoSurface(getCanvas());
			    
			    
			    Player.setVideoSurface(Surface);
			    
			    
					
			    mediaFrame.setLocation(new Point(700,0));
				mediaFrame.setSize(400, 300);
			    mediaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				mediaFrame.setVisible(true);
				//mediaFframe.setLocation(new Point(frame.getWidth(),0));
				
				
	}
	public PlayerWindow() {
		
		init();
	}
	
	
	
	public void setListenerVideoOutput(VideoOutputEventListener o) {
		
		PlayerWindow.Player.addVideoOutputEventListener(o);
	}
	
	public void setListenerWindow(WindowListener w) {
		
		this.mediaFrame.addWindowListener(w);
	}
	
	public void setListenerMediaPlayer(MediaPlayerEventListener m) {
		
		PlayerWindow.Player.addMediaPlayerEventListener(m);
	}
	
	public void setListenerCanvas(MouseWheelListener m){
		
		this.canvas.addMouseWheelListener(m);
	}
	
	
	public MediaPlayerFactory getMediaFactory() {
		return mediaFactory;
	}
	public void setMediaFactory(MediaPlayerFactory mediaFactory) {
		this.mediaFactory = mediaFactory;
	}
	public Canvas getCanvas() {
		return canvas;
	}
	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
	

}
