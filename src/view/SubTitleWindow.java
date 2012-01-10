package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.WindowListener;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SubTitleWindow {
	
	 private 		JFrame subtitleWindow   = new JFrame("Untertitel");
	 private static JTextArea textEingabe  = new JTextArea();
	 private 		JLabel name            = new JLabel();
	 private static JTextField nameEingabe = new JTextField();
	 private 		JLabel text        = new JLabel();
	 private 		JScrollPane jsp    = new JScrollPane(textEingabe,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	   
	 private void init() {
			/** UntertitelFenster */

			subtitleWindow.setSize(new Dimension(600,300));
			subtitleWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			subtitleWindow.setLocation(new Point(0,450));
			subtitleWindow.setLayout(null);

		//Personenlabel			
			name.setText("Person:");
			name.setPreferredSize(new Dimension(70,10));
			name.setBounds(5, 30, 100, 20);
			subtitleWindow.add(name);
		//Personausgabe			
			nameEingabe.setPreferredSize(new Dimension(400,20));
			nameEingabe.setText("");
			nameEingabe.setBounds(100, 30, 300,30);
			subtitleWindow.add(nameEingabe);
		//TextLabel			
			text.setText("Kommentar:");
			text.setBounds(5, 60, 100,20);
			subtitleWindow.add(text);
		//Textein- und Ausgabe						
			textEingabe.setOpaque(true);//Damit jeder Pixel "komplett" gezeichenet wird
			textEingabe.setLineWrap(true);				
			textEingabe.setWrapStyleWord(true);
			textEingabe.setBackground(Color.white);
			jsp.setBounds(100,60, 450, 200);
			subtitleWindow.add(jsp);
					

			subtitleWindow.setVisible(true);
	 }
	  public SubTitleWindow()
	  {
		 init();			
	  }  
	  public void addFrameListener(WindowListener w) {
		  this.subtitleWindow.addWindowListener(w);
	  }
//----------------Setter und Getters-------------------------//
	public static JTextArea getTextEingabe() {
		return textEingabe;
	}
	public void setTextEingabe(JTextArea textEingabe) {
		SubTitleWindow.textEingabe = textEingabe;
	}
	public static JTextField getNameEingabe() {
		return nameEingabe;
	}
	public void setNameEingabe(JTextField nameEingabe) {
		SubTitleWindow.nameEingabe = nameEingabe;
	}
	  
}
