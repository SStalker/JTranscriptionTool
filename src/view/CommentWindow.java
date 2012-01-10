package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.URL;


import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CommentWindow {

	JFrame commentWindow = new JFrame("EingabeFormular");
	JLabel zeit_label = new JLabel();
	static JTextField zeitEingabe = new JTextField();
	JLabel name = new JLabel();
	static JTextField nameEingabe = new JTextField();
	JLabel text = new JLabel();
	static JTextArea textEingabe = new JTextArea();
	JPanel buttonPanel = new JPanel(new FlowLayout(0,0,0));
	
	JButton end = new JButton();
	JButton forward = new JButton();
	JButton backward = new JButton();
	JButton start = new JButton();
	JButton delete = new JButton();
	
	JButton ok = new JButton("OK");
	JButton closeFrame = new JButton("Formular schlie\u00dfen");
	
	
	public CommentWindow() {
		
		init();
	}
	
	private void init() {
		
		/* KommentarFenster */
		
		
		/* Bilder setzen für die Jar-file*/
		Image image1;
		Image image2;
		Image image3;
		Image image4;
		Image image5;
		try {
			image1 = ImageIO.read(getClass().getResourceAsStream(("/include/pictures/CommentWindow/arrow-right-double.png")));
			image2 = ImageIO.read(getClass().getResourceAsStream(("/include/pictures/CommentWindow/arrow-right.png")));
			image3 = ImageIO.read(getClass().getResourceAsStream(("/include/pictures/CommentWindow/arrow-left.png")));
			image4 = ImageIO.read(getClass().getResourceAsStream(("/include/pictures/CommentWindow/arrow-left-double.png")));
			image5 = ImageIO.read(getClass().getResourceAsStream(("/include/pictures/CommentWindow/arrow-up.png")));
			
			Icon icon1 = new ImageIcon(image1);
			Icon icon2 = new ImageIcon(image2);
			Icon icon3 = new ImageIcon(image3);
			Icon icon4 = new ImageIcon(image4);
			Icon icon5 = new ImageIcon(image5);
			
			end.setIcon(icon1);
			forward.setIcon(icon2);
			backward.setIcon(icon3);
			start.setIcon(icon4);
			delete.setIcon(icon5);
			
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
		
		commentWindow.setSize(new Dimension(600,400));
		commentWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		commentWindow.setLocation(new Point(0,MainWindow.getMainFrame().getHeight()+TranscriptionWindow.getTranskribieren().getHeight()+24));
		commentWindow.setLayout(null);
//Zeitlabel			
		
		zeit_label.setText("Zeit:");
		//zeit.setPreferredSize(new Dimension(70,10));
		zeit_label.setBounds(5, 10, 100, 20);
		commentWindow.add(zeit_label);
//Zeiteingabe			
		
		zeitEingabe.setPreferredSize(new Dimension(400,20));
		//name_eingabe.setMaximumSize(new Dimension(200,60));
		zeitEingabe.setText("");
		zeitEingabe.setBounds(100, 10, 120,30);
		commentWindow.add(zeitEingabe);
//Personenlabel			
		
		name.setText("Person:");
		name.setPreferredSize(new Dimension(70,10));
		name.setBounds(5, 60, 100, 20);
		commentWindow.add(name);
//Personeneingabe			
		
		nameEingabe.setPreferredSize(new Dimension(400,20));
		//name_eingabe.setMaximumSize(new Dimension(200,60));
		nameEingabe.setText("");
		nameEingabe.setBounds(100, 60, 260,30);
		commentWindow.add(nameEingabe);
//TextLabel			
		
		text.setText("Kommentar:");
		text.setBounds(5, 110, 100,20);
		commentWindow.add(text);
//Texteingabe						
		
		textEingabe.setOpaque(true);//Damit jeder Pixel "komplett" gezeichenet wird
		textEingabe.setLineWrap(true);				
		textEingabe.setWrapStyleWord(true);
		textEingabe.setBackground(Color.white);
		//textEingabe.setBounds(100,125, 300, 300);
		JScrollPane jsp = new JScrollPane(textEingabe,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jsp.setBounds(100,110, 450, 200);
		commentWindow.add(jsp);
		
		//JPanel f�r die Navigationsbuttons			
		
		buttonPanel.setBounds(370, 60, 240, 40);
		
		
		
		buttonPanel.add(delete,FlowLayout.LEFT);			
		buttonPanel.add(end,FlowLayout.LEFT);			
		buttonPanel.add(forward,FlowLayout.LEFT);
		buttonPanel.add(backward,FlowLayout.LEFT);
		buttonPanel.add(start,FlowLayout.LEFT);		
		commentWindow.add(buttonPanel);
		
		ok.setBounds(460, 10, 45, 20);
		commentWindow.add(ok);
		closeFrame.setBounds(410, 35, 145, 20);
		commentWindow.add(closeFrame);
		
		commentWindow.setVisible(true);
	}
//------------------Listener-------------------------//	
	public void setListenerok(ActionListener l) {
		this.ok.addActionListener(l);
	}
	
	public void setListenercloseFrame(ActionListener l) {
		this.closeFrame.addActionListener(l);
	}
	
	public void setListenercommentWindow(WindowListener w) {
		this.commentWindow.addWindowListener(w);
	}
	
	public void setListenerend(ActionListener l) {
		this.end.addActionListener(l);
	}
	
	public void setListenerstart(ActionListener l) {
		this.start.addActionListener(l);
	}
	
	public void setListenerforward(ActionListener l) {
		this.forward.addActionListener(l);
	}
	
	public void setListenerbackward(ActionListener l) {
		this.backward.addActionListener(l);
	}
	
	public void setListenerdelete(ActionListener l) {
		this.delete.addActionListener(l);
	}
//----------------KeyListener------------------------//	
	public void setListenerTimeKey(KeyListener k) {
		CommentWindow.zeitEingabe.addKeyListener(k);
	}
	
	public void setListenerPersonKey(KeyListener k) {
		this.nameEingabe.addKeyListener(k);
	}
	
	public void setListenerTextKey(KeyListener k) {
		this.textEingabe.addKeyListener(k);
	}
//------------------MouseListener------------------------//	
	public void setListenerTimeMouse(MouseListener m) {
		CommentWindow.zeitEingabe.addMouseListener(m);
	}
	
	public void setListenerPersonMouse(MouseListener m) {
		this.nameEingabe.addMouseListener(m);
	}
	
	public void setListenerTextMouse(MouseListener m) {
		this.textEingabe.addMouseListener(m);
	}
//------------------Getter und Setters----------------//

	public JFrame getCommentWindow() {
		return commentWindow;
	}

	public void setCommentWindow(JFrame commentWindow) {
		this.commentWindow = commentWindow;
	}

	public static JTextField getZeitEingabe() {
		return zeitEingabe;
	}

	public static void setZeitEingabe(JTextField zeitEingabe) {
		CommentWindow.zeitEingabe = zeitEingabe;
	}

	public static JTextField getNameEingabe() {
		return nameEingabe;
	}

	public static void setNameEingabe(JTextField nameEingabe) {
		CommentWindow.nameEingabe = nameEingabe;
	}

	public static JTextArea getTextEingabe() {
		return textEingabe;
	}

	public static void setTextEingabe(JTextArea textEingabe) {
		CommentWindow.textEingabe = textEingabe;
	}
	
}
