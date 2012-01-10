package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import specialclasses.*;

//import model.MainWindowModel;
import model.DatabaseModel;
import model.MainWindowModel;
import model.PlayWindowModel;

import view.Database;
import view.HelpWindow;



import view.MainWindow;

public class MainWindowControl{

	private MainWindow mainwindow;
	//private MainWindowModel mainwindowmodel;
	private DatabaseModel databasemodel;
	public PlayWindowModel pwm;
	
	
	private String libraryPath;
	private String playFile;
	private String dbfFile;
	private String dbfPath;
	private String dbFile;
	private String dbPath;
	private String cache;
	Database db = new Database();
	
	
	public MainWindowControl() {
		
		this.mainwindow = new MainWindow();
		//this.mainwindowmodel = new MainWindowModel();
		this.databasemodel = new DatabaseModel();
		this.pwm = new PlayWindowModel();
		
		
		addListener();
	}
	
			/**
		     * Die Listener, die wir aus den Internen Klassen generieren
		     * werden der View bekannt gemacht, sodass diese mit
		     * uns (dem Controller) kommunizieren kann
		     */
		    private void addListener(){
		        
		        this.mainwindow.setListenerMenuDatei1(new VideoOpen());
		        this.mainwindow.setListenerMenuDatei2(new Databaseopen());
		        this.mainwindow.setListenerMenuDatei3(new CreateDatabase());
		        this.mainwindow.setListenerMenuDatei4(new LibraryPath());
		        this.mainwindow.setListenerMenuDatei5(new QuitProgram());
		        this.mainwindow.setListenerMenuModus1(new Play());
		        this.mainwindow.setListenerMenuModus2(new Transcription());
		        this.mainwindow.setListenerMenuExtra1(new ConvertDbase());
		        this.mainwindow.setListenerMenuExtra2(new ExportDatabase());
		        this.mainwindow.setListenerMenuHelp1(new Info());
		        this.mainwindow.setListenerButtonVideo(new buttonvideo());
		        this.mainwindow.setListenerButtonDatabase(new buttondatabase());
		        
		    }
		 
		    /**
		     * Inneren Listener Klassen implementieren das Interface ActionListener
		     *
		     * 1: Hier wird erst der eingegebene Wert aus der View geholt
		     * 2: Der Wert wird dem Model übergeben und die Wurzel berechnet
		     * 3: Die berechnete Wurzel wird aus dem Model geladen und
		     * 4: Wieder der View zum Darstellen übergeben
		     *
		     * ACHTUNG: Fehlerprüfung muss noch implementeirt werden
		     */
	class VideoOpen implements ActionListener{
				
			public void actionPerformed(ActionEvent e) 
			{					
				JFileChooser chooser = new JFileChooser();
				FileFilter mediaFilter = new ExtensionFileFilter(null, new String[] { "Medien","MP4", "MP3","AVI","FLV" });

			    chooser.addChoosableFileFilter(mediaFilter);
				chooser.setMultiSelectionEnabled(false);
	            int rueckgabeWert = chooser.showDialog(null, "\u00d6ffnen");
	            if(rueckgabeWert == JFileChooser.APPROVE_OPTION) 
	            {                 
	                File f = new File(chooser.getSelectedFile(),"");
	                                
	                playFile = f.getName();
	                mainwindow.setTextVideo(playFile);
	                pwm.setPlayPath(f.getPath());
	                //Eigentlich sinnlos da ja mit dem Datenbank button der dbname ausgewählt wird
	                //playFile = playFile.substring(0,playFile.indexOf('.'));
	                //databasemodel.setDbname(playFile);
	            }  
			}		    	
}
	
	class Databaseopen implements ActionListener{
		
		public void actionPerformed(ActionEvent e) 
		{					
			JFileChooser chooser = new JFileChooser();
			FileFilter sqlFilter = new ExtensionFileFilter(null, new String[] { "SQLite" });

		    chooser.addChoosableFileFilter(sqlFilter);
			chooser.setMultiSelectionEnabled(false);
			chooser.setAcceptAllFileFilterUsed(false);
            int rueckgabeWert = chooser.showOpenDialog(null);
            if(rueckgabeWert == JFileChooser.APPROVE_OPTION)
            {                 
                File f = new File(chooser.getSelectedFile(),"");  
                File ff = chooser.getCurrentDirectory();
                dbFile = f.getName();
                dbPath = ff.getPath();
                System.out.println("Database open: " + dbPath + dbFile);
                databasemodel.setDbname(dbFile);
                DatabaseModel.setDbpath(dbPath);
                mainwindow.setTextDatabase(dbFile);                        
            }  
		}		    	
}
	class CreateDatabase implements ActionListener{
		
		public void actionPerformed(ActionEvent e) 
		{					
			JFileChooser creater = new JFileChooser();// JFileChooser-Objekt erstellen
			creater.setDialogTitle("Datenbank erstellen");			
			creater.setAcceptAllFileFilterUsed(false);
			FileFilter jpegFilter = new ExtensionFileFilter(null, new String[] { "sqlite" });

		    creater.addChoosableFileFilter(jpegFilter);
			int result = creater.showSaveDialog(null);
			if(result == JFileChooser.APPROVE_OPTION)
			{
				
							
				File ff = creater.getSelectedFile();
				File f = creater.getCurrentDirectory();
				
				dbPath = f.getPath() + "/";
				dbFile = ff.getName();
				databasemodel.setDbname(dbFile);
                DatabaseModel.setDbpath(dbPath);
                System.out.println(dbPath + dbFile);
                try {
					db.createDatabase();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	
		}		    	
}
	
	class LibraryPath implements ActionListener{

		
		public void actionPerformed(ActionEvent e)
		{
			
			JFileChooser chooser = new JFileChooser();						
			chooser.setAcceptAllFileFilterUsed(false);
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int result = chooser.showSaveDialog(null);
			if(result == JFileChooser.APPROVE_OPTION)
			{
					
				File f = chooser.getCurrentDirectory();				
				libraryPath = f.getPath();
				System.out.println(libraryPath);
				MainWindowModel.setLibraryPath(libraryPath);
			}
	
						
		}
		
	}
	class QuitProgram implements ActionListener{
		
		public void actionPerformed(ActionEvent e) 
		{					
			System.exit(0);
		}		    	
}
	class Play implements ActionListener{
		
		public void actionPerformed(ActionEvent e) 
		{					
			System.out.println("Modus1");
			new PlayWindowControl();
			
		}		    	
}
	class Transcription implements ActionListener{
		
		public void actionPerformed(ActionEvent e) 
		{					
			System.out.println("Modus2");
			new TranscriptionWindowControl();
		}		    	
}
	class ConvertDbase implements ActionListener{
		
		public void actionPerformed(ActionEvent e) 
		{	
			JFileChooser chooser = new JFileChooser();
			
				
				FileFilter dbfFilter = new ExtensionFileFilter(null, new String[] { "dbf" });
					chooser.addChoosableFileFilter(dbfFilter);
					chooser.setAcceptAllFileFilterUsed(false);
					
            int rueckgabeWert = chooser.showSaveDialog(null);
            	if(rueckgabeWert == JFileChooser.APPROVE_OPTION) 
            	{       
	            	File f = chooser.getCurrentDirectory();
	            	
	            		dbfPath = f.getPath() + "/";
	            	
		            	//System.out.println("Extra1: " + dbfPath);
		            	dbfFile = chooser.getSelectedFile().getName();
		            	//System.out.println(dbfFile);
		            	DatabaseModel.setDbfpath(dbfPath);
		            	dbfFile = dbfFile.substring(0,dbfFile.indexOf('.'));
		                DatabaseModel.setDbfname(dbfFile);
		                //System.out.println("Pfad: " + DatabaseModel.getDbfpath());
		                //System.out.println("file: " + DatabaseModel.getDbfname());
		            	Vector<Vector<String>> olddata = db.readDBF(dbfPath);
		            	//System.out.println(" länge 1: " + olddata.get(0).size());
	            	try 
	            	{
	            		db.newDB(olddata);
					} 
	            	catch (Exception e1)
	            	{
						e1.printStackTrace();
					}
            }  
		}		    	
}
	class ExportDatabase implements ActionListener{
		
		public void actionPerformed(ActionEvent e) 
		{					
			new DbExportWindowControl();
		}		    	
}
	class Info implements ActionListener{
		
		public void actionPerformed(ActionEvent e) 
		{					
			new HelpWindow();
		}		    	
}
	class buttonvideo implements ActionListener{
		
		public void actionPerformed(ActionEvent e) 
		{					
			JFileChooser chooser = new JFileChooser();// JFileChooser-Objekt erstellen
			FileFilter mediaFilter = new ExtensionFileFilter(null, new String[] { "Medien","MP4", "MP3","AVI","FLV" });

		    chooser.addChoosableFileFilter(mediaFilter);
			chooser.setMultiSelectionEnabled(false);
            int rueckgabeWert = chooser.showOpenDialog(null);// Dialog zum Oeffnen von Dateien anzeigen
            if(rueckgabeWert == JFileChooser.APPROVE_OPTION)//Abfrage, ob auf "√ñffnen" geklickt wurde 
            {                 
                File f = new File(chooser.getSelectedFile(),"");
                //String text = f.getName();    
                
                playFile = f.getName();
                mainwindow.setTextVideo(playFile);
                pwm.setPlayPath(f.getPath());
                //name_datei = new String();
                //name_datei = text.substring(0, text.indexOf('.')); 
                //playFile = playFile.substring(0,playFile.indexOf('.'));
                //databasemodel.setDbname(playFile);                      
            }  
		}		    	
}
	class buttondatabase implements ActionListener{
		
		public void actionPerformed(ActionEvent e) 
		{					
			JFileChooser chooser = new JFileChooser();// JFileChooser-Objekt erstellen
			FileFilter jpegFilter = new ExtensionFileFilter(null, new String[] { "SQLite" });

		    chooser.addChoosableFileFilter(jpegFilter);
			chooser.setMultiSelectionEnabled(false);
			chooser.setAcceptAllFileFilterUsed(false);
            int rueckgabeWert = chooser.showOpenDialog(null);// Dialog zum Oeffnen von Dateien anzeigen
            if(rueckgabeWert == JFileChooser.APPROVE_OPTION)//Abfrage, ob auf "√ñffnen" geklickt wurde 
            {                 
            	File f = new File(chooser.getSelectedFile(),"");  
                File ff = chooser.getCurrentDirectory();
                dbFile = f.getName();
                dbPath = ff.getPath() + "/";
                System.out.println("Database open: " + dbPath + dbFile);
                databasemodel.setDbname(dbFile);
                DatabaseModel.setDbpath(dbPath);
                mainwindow.setTextDatabase(dbFile);                           
            }  
		}		    	
}
	
}	