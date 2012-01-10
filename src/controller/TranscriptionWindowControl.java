package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;




import model.CommentWindowModel;
import model.PlayWindowModel;
import model.PlayerWindowModel;

import model.TranscriptionWindowModel;
import view.CommentWindow;
import view.PlayerWindow;
import view.TranscriptionWindow;

public class TranscriptionWindowControl {

	private TranscriptionWindow transcriptionwindow;
	private TranscriptionWindowModel transcriptionwindowmodel;
	private PlayWindowModel playwindowmodel;
	private PlayerWindowModel playerwindowmodel;
	private CommentWindowModel commentwindowmodel;
	private getTime gt;
	
	public TranscriptionWindowControl() {
		
		this.transcriptionwindow = new TranscriptionWindow();
		this.transcriptionwindowmodel = new TranscriptionWindowModel();
		this.playwindowmodel = new PlayWindowModel();
		this.playerwindowmodel = new PlayerWindowModel();
		this.commentwindowmodel = new CommentWindowModel();
		this.gt = new getTime();
		new PlayerWindowControl();
		addListener();
		
		
				
	}
	
	private void addListener() {
		
		this.transcriptionwindow.setListenerMinus1(new minusbutton1());
		this.transcriptionwindow.setListenerMinus2(new minusbutton2());
		this.transcriptionwindow.setListenerMinus3(new minusbutton3());
		this.transcriptionwindow.setListenerMinus4(new minusbutton4());
		this.transcriptionwindow.setListenerMinus5(new minusbutton5());
		this.transcriptionwindow.setListenerPlus1(new plusbutton1());
		this.transcriptionwindow.setListenerPlus2(new plusbutton2());
		this.transcriptionwindow.setListenerPlus3(new plusbutton3());
		this.transcriptionwindow.setListenerPlus4(new plusbutton4());
		this.transcriptionwindow.setListenerPlus5(new plusbutton5());
		this.transcriptionwindow.setListenerButtonPlay(new playbutton());
		this.transcriptionwindow.setListenerButtonPause(new pausebutton());
		this.transcriptionwindow.setListenerButtonStop(new stopbutton());
		this.transcriptionwindow.setListenerButtonSeekb(new seekbbutton());
		this.transcriptionwindow.setListenerButtonSeekf(new seekfbutton());
		this.transcriptionwindow.setListenerTimeget(new timegetbutton());
		this.transcriptionwindow.setListenerTimeset(new timesetbutton());
		this.transcriptionwindow.setListenerVideo(new videoslider());
    	    	
	}
	
	class minusbutton1 implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			System.out.println("vor der schleife");
			System.out.println("wert:" + PlayerWindowModel.getIsPlaying());
			if(PlayerWindowModel.getIsPlaying() == true)
			{
				PlayerWindow.Player.pause();
				PlayerWindowModel.setIsPlaying(false);
			}
			
				
				
				
				if(playerwindowmodel.getPlayTime() >=100) {
					
				//PlayerWindowModel.setFulltime(new SimpleDateFormat("HH':'mm':'ss':'SSS"));
					PlayerWindowModel.setPlayTime(playerwindowmodel.getPlayTime()-100);
				PlayerWindow.Player.setTime(playerwindowmodel.getPlayTime());
				PlayerWindowModel.setPlayTimeFull(PlayerWindowModel.getFulltime().format(playerwindowmodel.getPlayTime()-3600000));
				TranscriptionWindowModel.getZeit().setText(PlayerWindowModel.getPlayTimeFull());
				transcriptionwindowmodel.getVideo().setValue((int)(PlayerWindow.Player.getPosition()*100));
				
				}else 
				{	
					System.out.println("Nee");
					PlayerWindowModel.setPlayTime(0);
					PlayerWindow.Player.setPosition(0);
					transcriptionwindowmodel.getVideo().setValue((int)(PlayerWindow.Player.getPosition()*100));
					PlayerWindow.Player.setTime(0);
					TranscriptionWindowModel.getZeit().setText("00:00:00:000");
				}
			
		}
		
	}
	
class minusbutton2 implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			System.out.println("vor der schleife");
			System.out.println("wert:" + PlayerWindowModel.getIsPlaying());
			if(PlayerWindowModel.getIsPlaying() == true)
			{
				PlayerWindow.Player.pause();
				PlayerWindowModel.setIsPlaying(false);
			}
			
				
				
				
				if(playerwindowmodel.getPlayTime() >=500) {
					
				//PlayerWindowModel.setFulltime(new SimpleDateFormat("HH':'mm':'ss':'SSS"));
					PlayerWindowModel.setPlayTime(playerwindowmodel.getPlayTime()-500);
				PlayerWindow.Player.setTime(playerwindowmodel.getPlayTime());
				PlayerWindowModel.setPlayTimeFull(PlayerWindowModel.getFulltime().format(playerwindowmodel.getPlayTime()-3600000));
				TranscriptionWindowModel.getZeit().setText(PlayerWindowModel.getPlayTimeFull());
				transcriptionwindowmodel.getVideo().setValue((int)(PlayerWindow.Player.getPosition()*100));
				}else 
				{	
					
					PlayerWindowModel.setPlayTime(0);
					PlayerWindow.Player.setPosition(0);
					transcriptionwindowmodel.getVideo().setValue((int)(PlayerWindow.Player.getPosition()*100));
					PlayerWindow.Player.setTime(0);
					TranscriptionWindowModel.getZeit().setText("00:00:00:000");
				}
			
		}
		
	}


class minusbutton3 implements ActionListener{

	
	public void actionPerformed(ActionEvent e) {
		System.out.println("vor der schleife");
		System.out.println("wert:" + PlayerWindowModel.getIsPlaying());
		if(PlayerWindowModel.getIsPlaying() == true)
		{
			PlayerWindow.Player.pause();
			PlayerWindowModel.setIsPlaying(false);
		}
		
			
			
			
			if(playerwindowmodel.getPlayTime() >=1000) {
				
			//PlayerWindowModel.setFulltime(new SimpleDateFormat("HH':'mm':'ss':'SSS"));
				PlayerWindowModel.setPlayTime(playerwindowmodel.getPlayTime()-1000);
			PlayerWindow.Player.setTime(playerwindowmodel.getPlayTime());
			PlayerWindowModel.setPlayTimeFull(PlayerWindowModel.getFulltime().format(playerwindowmodel.getPlayTime()-3600000));
			TranscriptionWindowModel.getZeit().setText(PlayerWindowModel.getPlayTimeFull());
			transcriptionwindowmodel.getVideo().setValue((int)(PlayerWindow.Player.getPosition()*100));
			}else 
			{	
				
				PlayerWindowModel.setPlayTime(0);
				PlayerWindow.Player.setPosition(0);
				transcriptionwindowmodel.getVideo().setValue((int)(PlayerWindow.Player.getPosition()*100));
				PlayerWindow.Player.setTime(0);
				TranscriptionWindowModel.getZeit().setText("00:00:00:000");
			}
		
	}
	
}


class minusbutton4 implements ActionListener{

	
	public void actionPerformed(ActionEvent e) {
		System.out.println("vor der schleife");
		System.out.println("wert:" + PlayerWindowModel.getIsPlaying());
		if(PlayerWindowModel.getIsPlaying() == true)
		{
			PlayerWindow.Player.pause();
			PlayerWindowModel.setIsPlaying(false);
		}
		
			
			
			
			if(playerwindowmodel.getPlayTime() >=5000) {
				
			//PlayerWindowModel.setFulltime(new SimpleDateFormat("HH':'mm':'ss':'SSS"));
				PlayerWindowModel.setPlayTime(playerwindowmodel.getPlayTime()-5000);
			PlayerWindow.Player.setTime(playerwindowmodel.getPlayTime());
			PlayerWindowModel.setPlayTimeFull(PlayerWindowModel.getFulltime().format(playerwindowmodel.getPlayTime()-3600000));
			TranscriptionWindowModel.getZeit().setText(PlayerWindowModel.getPlayTimeFull());
			transcriptionwindowmodel.getVideo().setValue((int)(PlayerWindow.Player.getPosition()*100));
			}else 
			{	
				
				PlayerWindowModel.setPlayTime(0);
				PlayerWindow.Player.setPosition(0);
				transcriptionwindowmodel.getVideo().setValue((int)(PlayerWindow.Player.getPosition()*100));
				PlayerWindow.Player.setTime(0);
				TranscriptionWindowModel.getZeit().setText("00:00:00:000");
			}
		
	}
	
}

class minusbutton5 implements ActionListener{

	
	public void actionPerformed(ActionEvent e) {
		System.out.println("vor der schleife");
		System.out.println("wert:" + PlayerWindowModel.getIsPlaying());
		if(PlayerWindowModel.getIsPlaying() == true)
		{
			PlayerWindow.Player.pause();
			PlayerWindowModel.setIsPlaying(false);
		}
		
			
			
			
			if(playerwindowmodel.getPlayTime() >=60000) {
				
			//PlayerWindowModel.setFulltime(new SimpleDateFormat("HH':'mm':'ss':'SSS"));
				PlayerWindowModel.setPlayTime(playerwindowmodel.getPlayTime()-60000);
			PlayerWindow.Player.setTime(playerwindowmodel.getPlayTime());
			PlayerWindowModel.setPlayTimeFull(PlayerWindowModel.getFulltime().format(playerwindowmodel.getPlayTime()-3600000));
			TranscriptionWindowModel.getZeit().setText(PlayerWindowModel.getPlayTimeFull());
			transcriptionwindowmodel.getVideo().setValue((int)(PlayerWindow.Player.getPosition()*100));
			}else 
			{	
				
				PlayerWindowModel.setPlayTime(0);
				PlayerWindow.Player.setPosition(0);
				transcriptionwindowmodel.getVideo().setValue((int)(PlayerWindow.Player.getPosition()*100));
				PlayerWindow.Player.setTime(0);
				TranscriptionWindowModel.getZeit().setText("00:00:00:000");
			}
		
	}
	
}

class plusbutton1 implements ActionListener{

	
	public void actionPerformed(ActionEvent e) {
		
		if(PlayerWindowModel.getIsPlaying() == true) {
			PlayerWindow.Player.pause();
			PlayerWindowModel.setIsPlaying(false);
		}
		
		if(playerwindowmodel.getPlayTime()+100 <= playerwindowmodel.getPlayer().getLength()) {
			
			PlayerWindowModel.setPlayTime(playerwindowmodel.getPlayTime()+100);
			PlayerWindow.Player.setTime(playerwindowmodel.getPlayTime());
			PlayerWindowModel.setPlayTimeFull(PlayerWindowModel.getFulltime().format(playerwindowmodel.getPlayTime()-3600000));
			TranscriptionWindowModel.getZeit().setText(PlayerWindowModel.getPlayTimeFull());
			transcriptionwindowmodel.getVideo().setValue((int)(PlayerWindow.Player.getPosition()*100));
		}
		
	}
	
	
}

class plusbutton2 implements ActionListener{

	
	public void actionPerformed(ActionEvent e) {
		
		if(PlayerWindowModel.getIsPlaying() == true) {
			PlayerWindow.Player.pause();
			PlayerWindowModel.setIsPlaying(false);
		}
		
		if(playerwindowmodel.getPlayTime()+500 <= playerwindowmodel.getPlayer().getLength()) {
			
			PlayerWindowModel.setPlayTime(playerwindowmodel.getPlayTime()+500);
			PlayerWindow.Player.setTime(playerwindowmodel.getPlayTime());
			PlayerWindowModel.setPlayTimeFull(PlayerWindowModel.getFulltime().format(playerwindowmodel.getPlayTime()-3600000));
			TranscriptionWindowModel.getZeit().setText(PlayerWindowModel.getPlayTimeFull());
			transcriptionwindowmodel.getVideo().setValue((int)(PlayerWindow.Player.getPosition()*100));
		}
		
	}
	
	
}

class plusbutton3 implements ActionListener{

	
	public void actionPerformed(ActionEvent e) {
		
		if(PlayerWindowModel.getIsPlaying() == true) {
			PlayerWindow.Player.pause();
			PlayerWindowModel.setIsPlaying(false);
		}
		
		if(playerwindowmodel.getPlayTime()+1000 <= playerwindowmodel.getPlayer().getLength()) {
			
			PlayerWindowModel.setPlayTime(playerwindowmodel.getPlayTime()+1000);
			PlayerWindow.Player.setTime(playerwindowmodel.getPlayTime());
			PlayerWindowModel.setPlayTimeFull(PlayerWindowModel.getFulltime().format(playerwindowmodel.getPlayTime()-3600000));
			TranscriptionWindowModel.getZeit().setText(PlayerWindowModel.getPlayTimeFull());
			transcriptionwindowmodel.getVideo().setValue((int)(PlayerWindow.Player.getPosition()*100));
		}
		
	}
	
	
}

class plusbutton4 implements ActionListener{

	
	public void actionPerformed(ActionEvent e) {
		
		if(PlayerWindowModel.getIsPlaying() == true) {
			PlayerWindow.Player.pause();
			PlayerWindowModel.setIsPlaying(false);
		}
		
		if(playerwindowmodel.getPlayTime()+5000 <= playerwindowmodel.getPlayer().getLength()) {
			
			PlayerWindowModel.setPlayTime(playerwindowmodel.getPlayTime()+5000);
			PlayerWindow.Player.setTime(playerwindowmodel.getPlayTime());
			PlayerWindowModel.setPlayTimeFull(PlayerWindowModel.getFulltime().format(playerwindowmodel.getPlayTime()-3600000));
			TranscriptionWindowModel.getZeit().setText(PlayerWindowModel.getPlayTimeFull());
			transcriptionwindowmodel.getVideo().setValue((int)(PlayerWindow.Player.getPosition()*100));
		}
		
	}
	
	
}

class plusbutton5 implements ActionListener{

	
	public void actionPerformed(ActionEvent e) {
		
		if(PlayerWindowModel.getIsPlaying() == true) {
			PlayerWindow.Player.pause();
			PlayerWindowModel.setIsPlaying(false);
		}
		
		if(playerwindowmodel.getPlayTime()+60000 <= playerwindowmodel.getPlayer().getLength()) {
			
			PlayerWindowModel.setPlayTime(playerwindowmodel.getPlayTime()+60000);
			PlayerWindow.Player.setTime(playerwindowmodel.getPlayTime());
			PlayerWindowModel.setPlayTimeFull(PlayerWindowModel.getFulltime().format(playerwindowmodel.getPlayTime()-3600000));
			TranscriptionWindowModel.getZeit().setText(PlayerWindowModel.getPlayTimeFull());
			transcriptionwindowmodel.getVideo().setValue((int)(PlayerWindow.Player.getPosition()*100));
		}
		
	}
	
	
}

	class playbutton implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			if(PlayerWindow.Player.isPlaying() == false && PlayerWindow.Player.getLength() == -1) {
    			PlayerWindow.Player.playMedia(playwindowmodel.getPlayPath(),"");
    			//gt.start();

    		}else {
    			
    			
    	PlayerWindow.Player.play();  
    	PlayerWindowModel.setIsPlaying(true);
		}
	}		
}	
	
	class pausebutton implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			
			if(PlayerWindow.Player.isPlaying()) {
				PlayerWindowModel.setIsPlaying(false);
    			PlayerWindow.Player.pause();
    		 
		}		    
	}		
}	
	
	class stopbutton implements ActionListener{

		
		public void actionPerformed(ActionEvent e)
		{
			PlayerWindow.Player.stop();
		}		
}	
	
	class seekbbutton implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			
			PlayerWindow.Player.skip(5000);
	}		
}	
	
	class seekfbutton implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			
			//PlayerWindow.Player.skip(-5000);
			PlayerWindow.Player.setTime(TranscriptionWindowModel.getCurrentValue());
			
	}		
}	

	class timegetbutton implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			TranscriptionWindow.getTimemark_time().setText(PlayerWindowModel.getPlayTimeFull());
			TranscriptionWindowModel.setCurrentValue(PlayerWindow.Player.getTime());
			
		}
		
		
	}
		
	class timesetbutton implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			CommentWindow.getZeitEingabe().setText(TranscriptionWindow.getTimemark_time().getText());
			if(commentwindowmodel.isWindowOpen() == false)
			{				
				new CommentWindowControl();
				commentwindowmodel.setWindowOpen(true);
				CommentWindow.getZeitEingabe().setText(TranscriptionWindow.getTimemark_time().getText());
				
			}
						
		}
		
		
	}
	
	class videoslider implements ChangeListener {

		public void stateChanged(ChangeEvent e)
		{
			JSlider source = (JSlider)e.getSource();
		    if (source.getValueIsAdjusting())
		    {
		    	PlayerWindow.Player.setPosition(((float)((JSlider) (e.getSource ())).getValue())/100);
		    	
		    }
		   
		}
		
	}

}

