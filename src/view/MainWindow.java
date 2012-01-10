package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainWindow {

	
	
		private static JFrame mainFrame = new JFrame();
//Buttons zum �ffnen und Labels
		private JLabel databaseLabel = new JLabel("");
		private JLabel videoLabel = new JLabel("");
		
		private JButton databaseButton = new JButton("Datenbank:");
		private JButton videoButton = new JButton("Video:");

		//Men� erstellen	      
		private JMenuBar leiste = new JMenuBar();
		private JMenu menu1 = new JMenu("Datei");
		private JMenu menu2 = new JMenu("Modus");
		private JMenu menu3 = new JMenu("Extras");
		private JMenu menu4 = new JMenu("Hilfe");
//Men�1		
		private JMenuItem dateiItem1 = new JMenuItem("Video \u00F6ffnen");
		private JMenuItem dateiItem2 = new JMenuItem("Datenbank \u00F6ffnen");
		private JMenuItem dateiItem3 = new JMenuItem("Datenbank anlegen");
		private JMenuItem dateiItem4 = new JMenuItem("VLC Library einstellen");
		private JMenuItem dateiItem5 = new JMenuItem("Beenden");

//Men�2
		private JMenuItem modusItem1 = new JMenuItem("Wiedergabe");
		private JMenuItem modusItem2 = new JMenuItem("Transkribieren");	
		
//Men�3
		private JMenuItem extraItem1 = new JMenuItem("Datenbank konvertieren");
		private JMenuItem extraItem2 = new JMenuItem("Einen Teil exportieren");
		
//Men�4
		private JMenuItem helpItem1 = new JMenuItem("\u00DCber");

		private void init() {
			
			leiste.add(menu1);
			leiste.add(menu2);
			leiste.add(menu3);
			leiste.add(menu4);
	//Men�1
			menu1.add(dateiItem1);
			menu1.add(dateiItem2);
			menu1.add(dateiItem3);
			menu1.add(dateiItem4);
			menu1.add(dateiItem5);
	//Men�2
			menu2.add(modusItem1);
			menu2.add(modusItem2);
	//Men�3
			menu3.add(extraItem1);
			menu3.add(extraItem2);
	//Men�4
			menu4.add(helpItem1);
			
	// Hauptfenster erstellen	
			mainFrame.setLayout(null);//Zeile:Spalte(3,2)
			mainFrame.setSize(300, 110);
		    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    
	// Buttons und Label hinzuf�gen mitsamt absolut positionieren
		    
		    databaseButton.setBounds(5, 3, 100, 25);
		    mainFrame.add(databaseButton);
		    databaseLabel.setBounds(105, 3, 195, 25);
		    mainFrame.add(databaseLabel);	
		    videoButton.setBounds(5, 30, 100, 25);
		    mainFrame.add(videoButton);
		    videoLabel.setBounds(105, 30, 195, 25);
		    mainFrame.add(videoLabel);
		   
	//Hauptfenster sichtbar machen	    
			mainFrame.setJMenuBar(leiste);
			mainFrame.setVisible(true);
		}
		
	public MainWindow() {
		
		init();

	}	
	
	public void setListenerMenuDatei1(ActionListener l){
		
		this.dateiItem1.addActionListener(l);
				        
	}	
	public void setListenerMenuDatei2(ActionListener l){
		
		this.dateiItem2.addActionListener(l);
	}
	public void setListenerMenuDatei3(ActionListener l){
		
		this.dateiItem3.addActionListener(l);
	}
	public void setListenerMenuDatei4(ActionListener l){
		
		this.dateiItem4.addActionListener(l);
	}
	public void setListenerMenuDatei5(ActionListener l){
		
		this.dateiItem5.addActionListener(l);
	}
	public void setListenerMenuModus1(ActionListener l){
		
		this.modusItem1.addActionListener(l);
	}
	public void setListenerMenuModus2(ActionListener l){
		
		this.modusItem2.addActionListener(l);
	}
	public void setListenerMenuExtra1(ActionListener l){
		
		this.extraItem1.addActionListener(l);
	}
	public void setListenerMenuExtra2(ActionListener l){
		
		this.extraItem2.addActionListener(l);
	}
	public void setListenerMenuHelp1(ActionListener l){
		
		this.helpItem1.addActionListener(l);
	}
	public void setListenerButtonVideo(ActionListener l){
		
		this.videoButton.addActionListener(l);
	}
	public void setListenerButtonDatabase(ActionListener l){
		
		this.databaseButton.addActionListener(l);
	}
//---------------Getter und Setters------------------------//
	public void setTextVideo(String text) {
		this.videoLabel.setText(text);
	}
	
	public void setTextDatabase(String text) {
		this.databaseLabel.setText(text);
	}

	public static JFrame getMainFrame() {
		return mainFrame;
	}

	public static void setMainFrame(JFrame mainFrame) {
		MainWindow.mainFrame = mainFrame;
	}
	
	
}
