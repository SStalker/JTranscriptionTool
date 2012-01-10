package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import model.CommentWindowModel;
import model.TranscriptionWindowModel;
import view.CommentWindow;
import view.Database;
import view.PlayerWindow;

public class CommentWindowControl {

	private CommentWindow commentwindow;
	private CommentWindowModel commentwindowmodel;
	private Database database;
	private int i = 0;
	/* Um den aktuellen Wert der Einagbe zu bekommen */
	private String clickedValue = null;
	private String newValue = null;
	private getTime gt;
	
	public CommentWindowControl() {
		this.commentwindow = new CommentWindow();
		this.commentwindowmodel = new CommentWindowModel();
		this.database = new Database();
		this.gt = new getTime();
		addListener();
	}
	
	private void addListener() {
		
		this.commentwindow.setListenercommentWindow(new commentwindowListener());
		this.commentwindow.setListenerok(new okbutton());
		this.commentwindow.setListenercloseFrame(new closebutton());
		this.commentwindow.setListenerstart(new startbutton());
		this.commentwindow.setListenerbackward(new backwardbutton());
		this.commentwindow.setListenerforward(new forwardbutton());
		this.commentwindow.setListenerend(new endbutton());
		this.commentwindow.setListenerdelete(new deletebutton());
		this.commentwindow.setListenerTimeKey(new timeinsertwithkey());
		this.commentwindow.setListenerPersonKey(new nameinsertwithkey());
		this.commentwindow.setListenerTextKey(new textinsertwithkey());
		this.commentwindow.setListenerTimeMouse(new timeinsertwithmouse());
		this.commentwindow.setListenerPersonMouse(new nameinsertwithmouse());
		this.commentwindow.setListenerTextMouse(new textinsertwithmouse());
	}
	
	
	
	class okbutton implements ActionListener {

		public void actionPerformed(ActionEvent e)
		{		
			try {
				
				database.writeData(commentwindow.getNameEingabe().getText(),commentwindow.getTextEingabe().getText(), CommentWindow.getZeitEingabe().getText(),TranscriptionWindowModel.getCurrentValue());
				i++;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	class closebutton implements ActionListener {

		public void actionPerformed(ActionEvent e)
		{
			commentwindow.getCommentWindow().dispose();			
		}
		
	}
	
	class commentwindowListener implements WindowListener {

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			commentwindowmodel.setWindowOpen(false);
			System.out.println("tot");
			System.out.println(commentwindowmodel.isWindowOpen());
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			commentwindowmodel.setWindowOpen(false);
			
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
			System.out.println("fenster offen");	
			commentwindowmodel.setWindowOpen(true);
			System.out.println(commentwindowmodel.isWindowOpen());
		}
		
	}

	class startbutton implements ActionListener{

		public void actionPerformed(ActionEvent e)
		{
			System.out.println("anfang");
			ArrayList<ArrayList<String>> test;
			try 
			{
				test = database.getData();
				if(test.get(0).size() > 0) {
				commentwindow.getNameEingabe().setText(test.get(0).get(0));
				commentwindow.getTextEingabe().setText(test.get(1).get(0));
				CommentWindow.getZeitEingabe().setText(test.get(2).get(0));
				i = 0;
				}
			}
			catch (Exception e1)
			{
				e1.printStackTrace();
			}						
		}
		
	}
	
	class backwardbutton implements ActionListener{

		public void actionPerformed(ActionEvent e)
		{
			System.out.println("rückwärts");
			ArrayList<ArrayList<String>> test;
			
			
			
			try 
			{
				System.out.println("i vor der schleife: " +i);
				test = database.getData();
				System.out.println("size: " + test.get(0).size());
				if(i > 0) {
				i--;
				commentwindow.getNameEingabe().setText(test.get(0).get(i));
				commentwindow.getTextEingabe().setText(test.get(1).get(i));
				CommentWindow.getZeitEingabe().setText(test.get(2).get(i));
				
				System.out.println("i nach der schleife: " +i);
				}
				//else if(i > 0) {i++;}
			}
			catch (Exception e1)
			{
				e1.printStackTrace();
			}
		  
						
		}
		
	}
	
	class forwardbutton implements ActionListener{

		public void actionPerformed(ActionEvent e)
		{
			System.out.println("vorwärts");
			
			
			System.out.println("i vor der schleife: " +i);
			ArrayList<ArrayList<String>> test;
			
			try 
			{
				test = database.getData();
				if(i < test.get(0).size()-1) {
			
				i++;
				commentwindow.getNameEingabe().setText(test.get(0).get(i));
				commentwindow.getTextEingabe().setText(test.get(1).get(i));
				CommentWindow.getZeitEingabe().setText(test.get(2).get(i));
				System.out.println("i nach der schleife: " +i);
				}
			}
			catch (Exception e1)
			{
				e1.printStackTrace();
			}			
		}
		
	}
	
	class endbutton implements ActionListener{

		public void actionPerformed(ActionEvent e)
		{
			System.out.println("ende");
			ArrayList<ArrayList<String>> test;
			try 
			{
				
				System.out.println("i vor der schleife: " +i);
				test = database.getData();
				System.out.println("size: " + test.get(0).size());
				if(test.get(0).size() > 0) {
				commentwindow.getNameEingabe().setText(test.get(0).get(test.get(0).size()-1));
				commentwindow.getTextEingabe().setText(test.get(1).get(test.get(1).size()-1));
				CommentWindow.getZeitEingabe().setText(test.get(2).get(test.get(2).size()-1));
				i = test.get(0).size()-1;
				}
				
				System.out.println("i nach der schleife: " +i);
			}
			catch (Exception e1)
			{
				e1.printStackTrace();
			}									
		}
		
	}
	
	class deletebutton implements ActionListener{

		public void actionPerformed(ActionEvent e)
		{
			System.out.println("löschen");
			ArrayList<ArrayList<String>> test;
			
			try 
			{
				
				System.out.println("i vor der schleife: " +i);
				test = database.getData();
				if(test.get(0).size() > 0) {
				System.out.println("size vor der schleife: " + test.get(0).size());
				database.deleteRow(CommentWindow.getZeitEingabe().getText());
				 
				System.out.println("size nach dem löschen: " + test.get(0).size());
				if(test.get(0).size()-1 > 0) {
					System.out.println("size vor der if schleife: " + test.get(0).size());
				commentwindow.getNameEingabe().setText(test.get(0).get(test.get(0).size()-2));
				commentwindow.getTextEingabe().setText(test.get(1).get(test.get(1).size()-2));
				CommentWindow.getZeitEingabe().setText(test.get(2).get(test.get(2).size()-2));
				}
				if(test.get(0).size()-1 == 0)
				{
					commentwindow.getNameEingabe().setText("");
					commentwindow.getTextEingabe().setText("");
					CommentWindow.getZeitEingabe().setText("");
				}
				System.out.println("size nach der if schleife: " + test.get(0).size());
				i--;
				System.out.println("i nach der schleife: " +i);
				}
			}
			catch (Exception e1)
			{
				e1.printStackTrace();
			}									
			
		}
		
	}
	
	class timeinsertwithkey implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) 
		{
			newValue = CommentWindow.getZeitEingabe().getText();
			Long test;
			
			/**
			 * Löst die Funktion erst bei "Enter" aus
			 */
	        if(e.getKeyCode() == 10) 
	        {
	        	
	        	try 
	        	{
	        		 test = calculateString(newValue);
					database.updateTableTime(clickedValue, newValue, test);
				} 
	        	catch (Exception e1)
				{
					e1.printStackTrace();
				}
	        }
            
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
		
			
		}
		
	}
	
	class nameinsertwithkey implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e)
		{
			newValue = CommentWindow.getNameEingabe().getText();
			System.out.println(newValue);
			System.out.println(clickedValue);
			
			
			/**
			 * Löst die Funktion erst bei "Enter" aus
			 */
	        if(e.getKeyCode() == 10) 
	        {
	        	
	        	try 
	        	{
	        		
					database.updateTableName(clickedValue, newValue);
				} 
	        	catch (Exception e1)
				{
					e1.printStackTrace();
				}
	        }
            			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class textinsertwithkey implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) 
		{
			newValue = CommentWindow.getTextEingabe().getText();
			System.out.println(newValue);
			
			
			/**
			 * Löst die Funktion erst bei "Enter" aus
			 */
	        if(e.getKeyCode() == 10) 
	        {
	        	
	        	try 
	        	{
	        		 /* Momentane Zeit, Neuer Wert */
					database.updateTableText(clickedValue, newValue);
				} 
	        	catch (Exception e1)
				{
					e1.printStackTrace();
				}
	        }
            			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class timeinsertwithmouse implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e)
		{
			clickedValue = CommentWindow.getZeitEingabe().getText();
			System.out.println(clickedValue);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class nameinsertwithmouse implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) 
		{
			clickedValue = CommentWindow.getZeitEingabe().getText();			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class textinsertwithmouse implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e)
		{
			clickedValue = CommentWindow.getZeitEingabe().getText();			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	/**
	 * Berechnet einen String mit Zeitwerten in um in einer long Variablen mit dem Zeitwert in Millisekunden
	 * @param string
	 * @return
	 */
	public long calculateString(String string) 
	{
		long[] array = new long[5];
		long result;
		String test;
		/**
		 * Berechnet die Stunden in Millisekunden
		 */
		test = string.substring(0, 2);
		array[0] = Long.decode(test); 
		System.out.println(array[0]);
		array[0] = array[0]*60*60*1000;		
		/**
		 * Berechnet die Minuten in Millisekunden
		 */
		test = string.substring(3, 5);
		array[1] = Long.decode(test);
		System.out.println(array[1]);
		array[1] = array[1]*60*1000;
		/**
		 * Berechnet die Sekunden in Millisekunden
		 */
		test = string.substring(6, 8);
		array[2] = Long.decode(test);
		System.out.println(array[2]);
		array[2] = array[2]*1000;
		/**
		 * Setzt die Millisekunden in vierten Element des Arrays
		 */
		test = string.substring(9, 12);
		array[3] = Long.decode(test);
		System.out.println(array[3]);
		/**
		 * Addiert alle 4 Elemente des Arrays zusammen, schreibt es in einer long Variable und
		 * wird anschließend zurückgegeben
		 */
		array[4] = array[0]+ array[1]+ array[2] +array[3];
		System.out.println("Endergebnis: " + array[4]);
		result = array[4];
		return result;
	}
}
