package view;

import java.awt.*;
import java.awt.event.ActionListener;

import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeListener;

import model.TranscriptionWindowModel;


public class TranscriptionWindow {
	
		private JButton seekb = new JButton();
	    private JButton seekf = new JButton();
		private JButton stop = new JButton();
	    private JButton pause = new JButton();
	    private JButton play = new JButton();
	    private JSlider audio = new JSlider(JSlider.HORIZONTAL);
	    private static JSlider video = new JSlider(JSlider.HORIZONTAL);
	    private static JFrame transkribieren = new JFrame("Transkribieren");
	    private JButton minus1 = new JButton("-0,1 sek");
	    private JButton minus2 = new JButton("-0,5 sek");
	    private JButton minus3 = new JButton("-1 sek");
	    private JButton minus4 = new JButton("-5 sek");
	    private JButton minus5 = new JButton("-1 min");
	    private JButton plus1 = new JButton("+0,1 sek");
	    private JButton plus2 = new JButton("+0,5 sek");
	    private JButton plus3 = new JButton("+1 sek");
	    private JButton plus4 = new JButton("+5 sek");
	    private JButton plus5 = new JButton("+1 min");
	    private JButton timeget = new JButton("Zeit markieren");
	    private JButton timeset = new JButton("Zeit eintragen");
	    
	    private JPanel button_list = new JPanel(new GridLayout(5,1,1/2,1/2));
	    private JPanel timebuttons = new JPanel(new GridLayout(4,0));
	    private JLabel pseudo1 = new JLabel("");
	    private JLabel pseudo2 = new JLabel("");
	    private JPanel timedisplay = new JPanel(new GridLayout(2,1));
	    private JLabel timemark = new JLabel("Zeitmarke:");
	    private static JLabel timemark_time = new JLabel("00:00:00:000");
	    private JLabel videoposition = new JLabel("Videoposition:");
	    private static JLabel videoposition_time = new JLabel("00:00:00:000");
	    private JPanel controlunits = new JPanel(new GridLayout(0,6,0,10));
	    private JPanel positionslider = new JPanel(new BorderLayout());
	    private TranscriptionWindowModel transcriptionmodel;
		

	    
	public TranscriptionWindow(){
		
		/* Bilder setzen für die Jar-file*/
		Image image1;
		Image image2;
		Image image3;
		Image image4;
		Image image5;
		try 
		{
			image1 = ImageIO.read(getClass().getResourceAsStream(("/include/pictures/TranscriptionWindow/media-skip-forward.png")));
			image2 = ImageIO.read(getClass().getResourceAsStream(("/include/pictures/TranscriptionWindow/media-skip-backward.png")));
			image3 = ImageIO.read(getClass().getResourceAsStream(("/include/pictures/TranscriptionWindow/media-playback-stop.png")));
			image4 = ImageIO.read(getClass().getResourceAsStream(("/include/pictures/TranscriptionWindow/media-playback-pause.png")));
			image5 = ImageIO.read(getClass().getResourceAsStream(("/include/pictures/TranscriptionWindow/media-playback-start.png")));
			
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

		transcriptionmodel = new TranscriptionWindowModel();
		transcriptionmodel.setVideo(video);
		/**
		 * Setzt eine Referenz des Labels videoposition_time 
		 * in dem JLabel des Models
		 */
		TranscriptionWindowModel.setZeit(videoposition_time);
		
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
	    
	    
	    audio.setMajorTickSpacing(10);
	    audio.setPaintTrack(true);
	    audio.setPaintTicks(true);
	    audio.setPreferredSize(new Dimension(100,30));
	    
	    
	    
	    transcriptionmodel.getVideo().setPreferredSize(new Dimension(100,30));
	    transcriptionmodel.getVideo().setValue(0);
	    transcriptionmodel.getVideo().setMajorTickSpacing(10);
	    transcriptionmodel.getVideo().setPaintTicks(true);
	
	transkribieren.setLayout(null);	
	transkribieren.setLocation(new Point(0,125));
    transkribieren.setSize(320,375);
    transkribieren.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    transkribieren.setLocation(new Point(0,MainWindow.getMainFrame().getHeight()+23));
    
    button_list.setBounds(5, 5, 165, 150);

    button_list.add(minus1);
    button_list.add(plus1);
    button_list.add(minus2);
    button_list.add(plus2);
    button_list.add(minus3);
    button_list.add(plus3);
    button_list.add(minus4);
    button_list.add(plus4);
    button_list.add(minus5);	        
    button_list.add(plus5);
    transkribieren.add(button_list);
//Time-Buttons	        			
	
	timebuttons.setBounds(170,5, 120, 150);
	
	timebuttons.add(pseudo1);
	timebuttons.add(timeset);
	timebuttons.add(timeget);
	timebuttons.add(pseudo2);
	transkribieren.add(timebuttons);		
//Timedisplay			
	
	timedisplay.setBounds(10, 160, 300, 100);
	
	/*
	videoposition_time.setHorizontalAlignment(JLabel.CENTER);
	timemark_time.setBorder(BorderFactory.createRaisedBevelBorder());
	timemark_time.setHorizontalAlignment(JLabel.CENTER);
	videoposition_time.setBorder(BorderFactory.createRaisedBevelBorder());
	*/
	timedisplay.add(timemark);
	timedisplay.add(timemark_time);
	timedisplay.add(videoposition);
	timedisplay.add(videoposition_time);
	transkribieren.add(timedisplay);
//Controlunits			
	
	controlunits.setBounds(10, 265, 300, 35);
							
	controlunits.add(play);
	controlunits.add(pause);
	controlunits.add(stop);
	controlunits.add(seekf);
	controlunits.add(seekb);
	transkribieren.add(controlunits);
//Positionslider			
	
	positionslider.setBounds(10, 310, 290, 35);
	positionslider.add(transcriptionmodel.getVideo(),BorderLayout.CENTER);
	transkribieren.add(positionslider);
	
	transkribieren.setVisible(true);
	
	}

	public void setListenerMinus1(ActionListener l) {
		this.minus1.addActionListener(l);
	}
	
	public void setListenerMinus2(ActionListener l) {
		this.minus2.addActionListener(l);
	}
	
	public void setListenerMinus3(ActionListener l) {
		this.minus3.addActionListener(l);
	}
	
	public void setListenerMinus4(ActionListener l) {
		this.minus4.addActionListener(l);
	}
	
	public void setListenerMinus5(ActionListener l) {
		this.minus5.addActionListener(l);
	}
	
	public void setListenerPlus1(ActionListener l) {
		this.plus1.addActionListener(l);
	}
	
	public void setListenerPlus2(ActionListener l) {
		this.plus2.addActionListener(l);
	}
	
	public void setListenerPlus3(ActionListener l) {
		this.plus3.addActionListener(l);
	}
	
	public void setListenerPlus4(ActionListener l) {
		this.plus4.addActionListener(l);
	}
	
	public void setListenerPlus5(ActionListener l) {
		this.plus5.addActionListener(l);
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
	
	public void setListenerVideo(ChangeListener p) {
		
		TranscriptionWindow.video.addChangeListener(p);
	}
	
	public  void setListenerTimeget(ActionListener l) {
		
		this.timeget.addActionListener(l);
	}
	
	public void setListenerTimeset(ActionListener l) {
		
		this.timeset.addActionListener(l);
	}
	

//------------------------Setter und Getters---------------------------//
	public static JLabel getVideoposition_time() {
		return videoposition_time;
	}

	public static void setVideoposition_time(JLabel videoposition_time) {
		TranscriptionWindow.videoposition_time = videoposition_time;
	}

	public static JSlider getVideo() {
		return video;
	}

	public static void setVideo(JSlider video) {
		TranscriptionWindow.video = video;
	}

	public static JLabel getTimemark_time() {
		return timemark_time;
	}

	public static void setTimemark_time(JLabel timemark_time) {
		TranscriptionWindow.timemark_time = timemark_time;
	}

	public static JFrame getTranskribieren() {
		return transkribieren;
	}

	public static void setTranskribieren(JFrame transkribieren) {
		TranscriptionWindow.transkribieren = transkribieren;
	}

}

