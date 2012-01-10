package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Point;

import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.GridLayout;

import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.WindowListener;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JFrame;


import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.PlayWindowModel;




public class PlayWindow{

	private JFrame playwindow = new JFrame("Wiedergabe");
	private JPanel leftPanel = new JPanel(new GridLayout(0,1));
	private JPanel left_time = new JPanel();
	private JPanel left_buttons = new JPanel(new FlowLayout(0,0,0));
	private JPanel rightPanel = new JPanel(new GridLayout(0,1));
	private JPanel downPanel = new JPanel(new BorderLayout());
	
	private JButton showSubtitle = new JButton("Untertitel anzeigen");
	private JButton changeFont = new JButton("Zeichensatz \u00E4ndern");
	
	private JButton seekf = new JButton();
    private JButton seekb = new JButton();
    private JButton stop = new JButton();
    private JButton pause = new JButton();
    private JButton play = new JButton();
    
    private static JLabel timeLabel = new JLabel("00:00:00:000");
    


	private JTable table;
	private DefaultTableModel model;
	
	public String file;
	
	
	
	private void init() {
		
		/* Bilder setzen für die Jar-file*/
		Image image1;
		Image image2;
		Image image3;
		Image image4;
		Image image5;
		try 
		{
			image1 = ImageIO.read(getClass().getResourceAsStream(("/include/pictures/PlayWindow/media-skip-forward.png")));
			image2 = ImageIO.read(getClass().getResourceAsStream(("/include/pictures/PlayWindow/media-skip-backward.png")));
			image3 = ImageIO.read(getClass().getResourceAsStream(("/include/pictures/PlayWindow/media-playback-stop.png")));
			image4 = ImageIO.read(getClass().getResourceAsStream(("/include/pictures/PlayWindow/media-playback-pause.png")));
			image5 = ImageIO.read(getClass().getResourceAsStream(("/include/pictures/PlayWindow/media-playback-start.png")));
			
			Icon icon1 = new ImageIcon(image1);
			Icon icon2 = new ImageIcon(image2);
			Icon icon3 = new ImageIcon(image3);
			Icon icon4 = new ImageIcon(image4);
			Icon icon5 = new ImageIcon(image5);
			
			seekb.setIcon(icon1);
			seekf.setIcon(icon2);
			stop.setIcon(icon3);
			pause.setIcon(icon4);
			play.setIcon(icon5);
			
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		
		PlayWindowModel.setZeit(timeLabel);
		
		playwindow.setSize(700,325);
	    playwindow.setLocation(new Point(0,125));
        playwindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        playwindow.setLayout(null);
        
        seekf.setContentAreaFilled(false);
		seekf.setBorderPainted(false);
		seekf.setFocusPainted(false);
	    
	    seekb.setContentAreaFilled(false);
	    seekb.setBorderPainted(false);
	    seekb.setFocusPainted(false);
	    
	    stop.setContentAreaFilled( false);
	    stop.setBorderPainted(false);
	    stop.setFocusPainted(false);
	    
	    pause.setContentAreaFilled(false);
	    pause.setBorderPainted(false);
	    pause.setFocusPainted(false);
	    
	    play.setContentAreaFilled( false);
	    play.setBorderPainted(false);
	    play.setFocusPainted(false);
	    
        
		  leftPanel.setBounds(5, 5, 225, 50);
		  leftPanel.setBorder(BorderFactory.createLineBorder(Color.black));	
		  left_time.add(timeLabel);
		  left_buttons.add(play);
		  left_buttons.add(pause);
		  left_buttons.add(stop);
		  left_buttons.add(seekb);
		  left_buttons.add(seekf);


		  	
		    timeLabel.setSize(240, 25);
		  
		  leftPanel.add(left_time);
		  leftPanel.add(left_buttons);
		  playwindow.add(leftPanel);
		  
		  rightPanel.setBounds(550,5,150,50);
		  rightPanel.add(showSubtitle);
		  rightPanel.add(changeFont);

		  playwindow.add(rightPanel);

		

	        
	        //comment.setLocation(new Point(0,frame.getHeight()+20));
	        
	        //leftPanel.setBounds(5, 5, 140, 60);
			//leftPanel.setBackground(Color.darkGray);
				
			
			
			table = new JTable(5,3);
			
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			//table.setSize(new Dimension(400,100));
			table.setPreferredScrollableViewportSize(new Dimension(400,100));
			JScrollPane jsp1 = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			//jsp1.setBounds(playwindow.getX(), 70, playwindow.getWidth(),playwindow.getHeight()-70);
			downPanel.setBounds(0, 100, playwindow.getWidth(), playwindow.getHeight());
			downPanel.add(jsp1,BorderLayout.CENTER);
			
			model = (DefaultTableModel)table.getModel();
			playwindow.add(downPanel);			
			playwindow.setVisible(true);
		
	}
	
	public PlayWindow()
	{
		init();
		}
	
public void setListenerButtonShowSubtitle(ActionListener l){
		
		this.showSubtitle.addActionListener(l);
				        
	}	

public void setListenerButtonChangeFont(ActionListener l){
	
	this.changeFont.addActionListener(l);
			        
}	

public void setListenerButtonSeekf(ActionListener l) {
	
	this.seekf.addActionListener(l);
}

public void setListenerButtonSeekb(ActionListener l) {
	
	this.seekb.addActionListener(l);
}

public void setListenerButtonStop(ActionListener l) {
	
	this.stop.addActionListener(l);
}

public void setListenerButtonPause(ActionListener l) {
	
	this.pause.addActionListener(l);
}

public void setListenerButtonPlay(ActionListener l) {
	
	this.play.addActionListener(l);
}

public void setListenerplaywindow(WindowListener w) {
	this.playwindow.addWindowListener(w);
}

//--------------Getter und Setters--------------------//


public static JLabel getTimeLabel() {
	return timeLabel;
}

public static void setTimeLabel(JLabel timeLabel) {
	PlayWindow.timeLabel = timeLabel;
}

public JTable getTable() {
	return table;
}

public void setTable(JTable table) {
	this.table = table;
}

public DefaultTableModel getModel() {
	return model;
}

public void setModel(DefaultTableModel model) {
	this.model = model;
}

}
