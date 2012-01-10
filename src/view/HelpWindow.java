package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;


import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelpWindow {
	
	JFrame helpwindow = new JFrame("Über");
	JLabel playername = new JLabel("Transcription Player");
	JLabel datum      = new JLabel("nachprogrammiert vom 31. Oktober 2011 ");
	JLabel datum1     = new JLabel();
	JLabel name1      = new JLabel("von Raphael Grewe &");
	JLabel name2      = new JLabel("Dennis Stiefelmann");
	JLabel email      = new JLabel();
	JLabel sprache    = new JLabel("geschrieben in JAVA");
	JLabel auftr      = new JLabel("im Auftrag der Universität Osnabrück");
	JLabel auftr1     = new JLabel("& der BBS Brinkstraße Osnabrück");

public void init(){
	
	helpwindow.setSize(new Dimension(450,300));
	helpwindow.setResizable(false);
	helpwindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	/**
	 * Setzt das Frame je nach Bildschirmgrš§e mittig
	 */
	helpwindow.setLocation(
				(Toolkit.getDefaultToolkit().getScreenSize().width-helpwindow.getSize().width) / 2,
					(Toolkit.getDefaultToolkit().getScreenSize().height-helpwindow.getSize().height) / 2);
	helpwindow.setLayout(null);
	
	//Playername
	playername.setFont(new Font("sansserif", Font.BOLD, 30));
	playername.setPreferredSize(new Dimension(50,10));
	playername.setBounds(80, 10, 300, 50);
	helpwindow.add(playername);

	//Datum
	datum.setPreferredSize(new Dimension(50,10));
	datum.setBounds(110, 50, 250, 20);
	helpwindow.add(datum);
	datum1.setText("bis 23. Dezember 2011");
	datum1.setPreferredSize(new Dimension(50,10));
	datum1.setBounds(160, 70, 250, 20);
	helpwindow.add(datum1);
	
	//Name des Programmierers1
	name1.setFont(new Font("sansserif", Font.BOLD, 24));
	name1.setPreferredSize(new Dimension(50,10));
	name1.setBounds(100, 90, 260, 40);
	helpwindow.add(name1);
	
	//Name des Programmierers2
	name2.setFont(new Font("sansserif", Font.BOLD, 24));
	name2.setPreferredSize(new Dimension(50,10));
	name2.setBounds(115, 130, 250, 20);
	helpwindow.add(name2);
	
	//email
	email.setText("(d.stiefelmann@web.de)");
	email.setPreferredSize(new Dimension(50,10));
	email.setBounds(150, 160, 140, 20);
	helpwindow.add(email);
	
	//sprache
	sprache.setFont(new Font("sansserif", Font.BOLD, 15));
	sprache.setPreferredSize(new Dimension(50,10));
	sprache.setBounds(145, 180, 200, 20);
	helpwindow.add(sprache);
	
	//Auftrag
	auftr.setFont(new Font("sansserif", Font.BOLD, 15));
	auftr.setPreferredSize(new Dimension(50,10));
	auftr.setBounds(95, 200, 270, 20);
	helpwindow.add(auftr);
	auftr1.setFont(new Font("sansserif", Font.BOLD, 15));
	auftr1.setPreferredSize(new Dimension(50,10));
	auftr1.setBounds(105, 220, 250, 20);
	helpwindow.add(auftr1);
	

	helpwindow.setVisible(true);
}
	
	public HelpWindow() {
		
		init();
	}
}