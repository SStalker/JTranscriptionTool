package controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.zfqjava.swing.JFontChooser;




import model.DatabaseModel;
import model.PlayWindowModel;
import model.PlayerWindowModel;
import model.SubtitleWindowModel;

import view.CommentWindow;
import view.Database;
import view.PlayWindow;
import view.PlayerWindow;
import view.SubTitleWindow;

import view.TranscriptionWindow;


public class PlayWindowControl {

	private Database database;
	private PlayWindow playwindow;
	private PlayWindowModel playwindowmodel;
	private PlayerWindowControl playerwindowcontrol;
	private SubtitleWindowModel subtitlewindowmodel;
	private Zeit zeit;
	
	public PlayWindowControl() {
	
		this.database = new Database();
		this.zeit = new Zeit();
		this.playwindow = new PlayWindow();
		this.playerwindowcontrol = new PlayerWindowControl();
		playwindowmodel = new PlayWindowModel();	
		subtitlewindowmodel = new SubtitleWindowModel();
		addListener();
		
		
	}
	
	private void addListener() {
		
		this.playwindow.setListenerplaywindow(new framelistener());
		this.playwindow.setListenerButtonShowSubtitle(new showsubtitle());
		this.playwindow.setListenerButtonChangeFont(new changefont());
		this.playwindow.setListenerButtonSeekf(new seekfbutton());
    	this.playwindow.setListenerButtonSeekb(new seekbbutton());
    	this.playwindow.setListenerButtonStop(new stopbutton());
    	this.playwindow.setListenerButtonPause(new pausebutton());
    	this.playwindow.setListenerButtonPlay(new playbutton());
    	
	}
	
	class framelistener implements WindowListener{

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent e) {
			
			
			System.out.println("OPEN");
			Vector<Vector<Object>> test;
			try 
			{
				test = database.getDataVector();
				
				Vector<String> title = new Vector<String>(2);
				title.add("Name");
				title.add("Text");
				title.add("Zeit");
				
				playwindow.getModel().setDataVector(test, title);
			}
			catch(SQLException s) 
			{
				if(s.getMessage().equalsIgnoreCase("no such table: information")) 
				{
					JOptionPane.showMessageDialog(null,
						    "You dont have a SQLite File from this Programm",
						    "Information",    					  
						    JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
			catch (Exception e1)
			{
				System.out.println("Exception catch!!");
				e1.printStackTrace();
			}	
						
		}
		
	}
	
	class showsubtitle implements ActionListener{
		
		public void actionPerformed(ActionEvent e) 
		{				
			System.out.println("subfenster " + subtitlewindowmodel.isWindowOpen());
			
			if(subtitlewindowmodel.isWindowOpen() == false)
			{				
				new SubtitleWindowControl();
				subtitlewindowmodel.setWindowOpen(true);	
				System.out.println("subfenster 2 " + subtitlewindowmodel.isWindowOpen());
			}
		}		    	
}
	
	class changefont implements ActionListener{
		
		public void actionPerformed(ActionEvent e) 
		{
			System.out.println("CHANGE FONT");
			JFontChooser fontChooser = new JFontChooser();
			   int result = fontChooser.showDialog(null);
			   if (result == JFontChooser.OK_OPTION)
			   {
			        Font font = fontChooser.getSelectedFont(); 
			        System.out.println("Selected Font : " + font);
			        SubTitleWindow.getNameEingabe().setFont(font);
			        SubTitleWindow.getTextEingabe().setFont(font);
			        
			   }
			  
		}
	}
	
class seekfbutton implements ActionListener{
    	
    	public void actionPerformed(ActionEvent e) 
		{					
    		PlayerWindow.Player.skip(5000);  
		}		    
    }
    
    class seekbbutton implements ActionListener{
    	
    	public void actionPerformed(ActionEvent e) 
		{					
    		PlayerWindow.Player.skip(-5000);  
		}		    
    }
    
    class stopbutton implements ActionListener{
    	
    	public void actionPerformed(ActionEvent e) 
		{					
    		PlayerWindow.Player.stop();	 
		}		    
    }
    
    class pausebutton implements ActionListener{
    	
    	public void actionPerformed(ActionEvent e) 
		{					
    		if(PlayerWindow.Player.isPlaying()) {
    			PlayerWindow.Player.pause();
    		 
		}		    
    }
 }    
    class playbutton implements ActionListener{
    	
    	public void actionPerformed(ActionEvent e) 
		{			
    		int i = 3;
    		int j = 0;
    		Vector<Vector<Object>> daten;
			try {
				daten = database.getDataVector();
				System.out.println(daten.get(j).elementAt(i));
				Long a = (Long) daten.get(j).get(i);
				System.out.println(a);
				
				while(PlayerWindowModel.getIsPlaying() == true) 
   			 {
					System.out.println("Player: " + PlayerWindow.Player.getTime());
					if(a == PlayerWindow.Player.getTime()) {System.out.println("wow xD");}
   				 //System.out.println("Zeit: " + daten.get(j).elementAt(i));
   				 
   				 j++;
   			 }
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,
					    "You must choose a functional Database",
					    "Inane error",    					  
					    JOptionPane.ERROR_MESSAGE);
			}
			
			
    		if(PlayerWindow.Player.isPlaying() == false && PlayerWindow.Player.getLength() == -1) {
    			
    				if(playwindowmodel.getPlayPath() != null)
    				{    			
    					PlayerWindow.Player.playMedia(playwindowmodel.getPlayPath(),"");    	    			
    				}
    				else 
    				{
    					JOptionPane.showMessageDialog(null,
	    					    "You must choose a Video",
	    					    "Inane error",    					  
	    					    JOptionPane.ERROR_MESSAGE);
    				}
    			
    			
    			
    			 
    		}else {
    	PlayerWindow.Player.play();  
		}
	}
  }
    
}

