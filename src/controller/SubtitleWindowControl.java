package controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import model.PlayerWindowModel;
import model.SubtitleWindowModel;
import view.SubTitleWindow;


public class SubtitleWindowControl {

	private SubTitleWindow subtitlewindow;
	private SubtitleWindowModel subtitlewindowmodel;	
	private boolean valueforloop = true;

	public SubtitleWindowControl() {
		
		this.subtitlewindow = new SubTitleWindow();	
		this.subtitlewindowmodel = new SubtitleWindowModel();
		addListener();

	}
	
	private void addListener() {
		
		this.subtitlewindow.addFrameListener(new framelistener());
	}
	
	class framelistener implements WindowListener{

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent e) 
		{
			System.out.println("tot");
			subtitlewindowmodel.setWindowOpen(false);
		}

		@Override
		public void windowClosing(WindowEvent e) 
		{
					
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
		public void windowOpened(WindowEvent e)
		{
			
			
		}
		
	}
}
