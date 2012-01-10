package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import model.DatabaseModel;
import view.DbExportWindow;
import view.Database;

public class DbExportWindowControl {
	private String exportFile;
	private String exportPath;
	private int i = 0;
	private DbExportWindow dbexportwindow;
	private Database database;
	private DatabaseModel databasemodel;
	
	public DbExportWindowControl()
	{
		this.dbexportwindow = new DbExportWindow();
		this.database = new Database();
		this.databasemodel= new DatabaseModel();
		addListener();
	}



	private void addListener() 
	{
    this.dbexportwindow.setListenerNameSave(new DBexportWindowListener1());
	this.dbexportwindow.setListenerFrame(new FrameListener());
	this.dbexportwindow.setListenerStart(new StartButtonListener());
	this.dbexportwindow.setListenerBackward(new BackwardButtonListener());
	this.dbexportwindow.setListenerForward(new ForwardButtonListener());
	this.dbexportwindow.setListenerEnd(new EndButtonListener());
	}
	
	
	
	class DBexportWindowListener1 implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			
			
			
		
			JFileChooser saver = new JFileChooser();// JFileChooser-Objekt erstellen
			int result = saver.showSaveDialog(null);
			saver.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			if(result ==JFileChooser.APPROVE_OPTION)
			{
				
			try {
				ArrayList<ArrayList<String>> copy = database.getData();
				 
				 
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
				
				File f = saver.getSelectedFile();
				File ff = saver.getCurrentDirectory();
				
				exportFile = f.getName();
                exportPath = ff.getPath() + "\\";

				exportFile = exportFile.substring(0,exportFile.indexOf('.'));
				databasemodel.setDbname(exportFile);
                DatabaseModel.setDbpath(exportPath);
                try {
					database.createDatabase();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	
			}	
		}
	}
	
	
	
class FrameListener implements WindowListener{


	public void windowActivated(WindowEvent arg0) 
	{
	
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
	
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		try {
			ArrayList<ArrayList<String>> arr = database.getData();
			arr.get(0);
			System.out.println(arr.get(2).get(0));
			dbexportwindow.getEingabeEnde().setText(arr.get(2).get(0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class StartButtonListener implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("anfang");
		ArrayList<ArrayList<String>> test;
		try 
		{
			test = database.getData();
			if(test.get(0).size() > 0) {
				dbexportwindow.getEingabeEnde().setText(test.get(2).get(0));
			i = 0;
			}
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}						
	}
}
class BackwardButtonListener implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent arg0)
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
			dbexportwindow.getEingabeEnde().setText(test.get(2).get(i));
			
			System.out.println("i nach der schleife: " +i);
			}
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
	}
}
class ForwardButtonListener implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		System.out.println("vorwŠrts");
		System.out.println("i vor der schleife: " +i);
		ArrayList<ArrayList<String>> test;
		
		try 
		{
			test = database.getData();
			if(i < test.get(0).size()-1) {
		
			i++;
			
			dbexportwindow.getEingabeEnde().setText(test.get(2).get(i));
			System.out.println("i nach der schleife: " +i);
			}
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}	
	}
}
class EndButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ende");
		ArrayList<ArrayList<String>> test;
		try 
		{
			System.out.println("i vor der schleife: " +i);
			test = database.getData();
			System.out.println("size: " + test.get(0).size());
			if(test.get(0).size() > 0) 
			{
			dbexportwindow.getEingabeEnde().setText(test.get(2).get(test.get(2).size()-1));
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
}