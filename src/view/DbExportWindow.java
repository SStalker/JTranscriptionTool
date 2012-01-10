package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DbExportWindow {
	
	JFrame fenster = new JFrame("Export");
	JLabel stzp = new JLabel("Start:");
	JLabel edzp = new JLabel("Ende:");
	JTextField eingabeStart = new JTextField("00:00:00:000");
	JTextField eingabeEnde = new JTextField();
	JButton Nameexportbutton = new JButton("Name:");
	JLabel Namevondb = new JLabel();
	JPanel exportunten = new JPanel();
	JButton exportbutton = new JButton("Export!");
	JPanel RechtsZeit = new JPanel(new FlowLayout());
	JButton end = new JButton(new ImageIcon("bin/include/pictures/DBExportWindow/arrow-right-double.png"));
	JButton forward = new JButton(new ImageIcon("bin/include/pictures/DBExportWindow/arrow-right.png"));
	JButton backward = new JButton(new ImageIcon("bin/include/pictures/DBExportWindow/arrow-left.png"));
	JButton start = new JButton(new ImageIcon("bin/include/pictures/DBExportWindow/arrow-left-double.png"));
	
	
	
	private void init(){
		
		/* Bilder setzen für die Jar-file*/
		Image image1;
		Image image2;
		Image image3;
		Image image4;
		
		try {
			image1 = ImageIO.read(getClass().getResourceAsStream(("/include/pictures/DBExportWindow/arrow-right-double.png")));
			image2 = ImageIO.read(getClass().getResourceAsStream(("/include/pictures/DBExportWindow/arrow-right.png")));
			image3 = ImageIO.read(getClass().getResourceAsStream(("/include/pictures/DBExportWindow/arrow-left.png")));
			image4 = ImageIO.read(getClass().getResourceAsStream(("/include/pictures/DBExportWindow/arrow-left-double.png")));
			
			
			Icon icon1 = new ImageIcon(image1);
			Icon icon2 = new ImageIcon(image2);
			Icon icon3 = new ImageIcon(image3);
			Icon icon4 = new ImageIcon(image4);
			
			
			end.setIcon(icon1);
			forward.setIcon(icon2);
			backward.setIcon(icon3);
			start.setIcon(icon4);
			
			
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	fenster.setSize(new Dimension(420,200));
	fenster.setLayout(null);
	stzp.setBounds(12, 5,35, 25);
	fenster.add(stzp);
	edzp.setBounds(12, 35,35, 25);
	fenster.add(edzp);
	
	eingabeStart.setBounds(50, 5, 150, 30);
	fenster.add(eingabeStart);
	
	eingabeEnde.setBounds(50, 35, 150, 30);
	eingabeEnde.setEditable(false);
    eingabeEnde.setForeground(Color.LIGHT_GRAY);
    eingabeEnde.setDisabledTextColor(Color.YELLOW);
	fenster.add(eingabeEnde);
	
	Nameexportbutton.setBorder(BorderFactory.createRaisedBevelBorder());
	Nameexportbutton.setBounds(5, 70, 45, 25);
	fenster.add(Nameexportbutton);
	Namevondb.setBounds(25, 70, 35, 25);
	fenster.add(Namevondb);
	
	exportunten.setBounds(110, 100, 75, 70);
	exportunten.add(exportbutton);
	fenster.add(exportunten,FlowLayout.LEFT);

	RechtsZeit.setBounds(150,31,320,100);

	RechtsZeit.add(start);
	RechtsZeit.add(backward);
	RechtsZeit.add(forward);
	RechtsZeit.add(end);
	fenster.add(RechtsZeit);	
	fenster.setVisible(true);	
}	
	
	public DbExportWindow()
	{
	init();		
	}
	
public void setListenerNameSave(ActionListener l){
		
		this.Nameexportbutton.addActionListener(l);
				        
	}	
	public void setListenerExport(ActionListener l){
		
		this.exportbutton.addActionListener(l);
	}	
	public void setListenerFrame(WindowListener l)
	{
		this.fenster.addWindowListener(l);
	}
	public JTextField getEingabeEnde() {
		return eingabeEnde;
	}
	public void setEingabeEnde(JTextField eingabeEnde) {
		this.eingabeEnde = eingabeEnde;
	}
	
	public void setListenerStart(ActionListener l)
	{
		this.start.addActionListener(l);
	}
	
	public void setListenerBackward(ActionListener l)
	{
		this.backward.addActionListener(l);
	}
	
	public void setListenerForward(ActionListener l)
	{
		this.forward.addActionListener(l);
	}
	public void setListenerEnd(ActionListener l)
	{
		this.end.addActionListener(l);
	}
	public JTextField getEingabeStart() {
		return eingabeStart;
	}
	public void setEingabeStart(JTextField eingabeStart) {
		this.eingabeStart = eingabeStart;
	}

	
}