package view;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.Vector;

import org.xBaseJ.DBF;
import org.xBaseJ.fields.CharField;
import org.xBaseJ.fields.MemoField;



import model.DatabaseModel;

public class Database {

	DatabaseModel databasemodel = new DatabaseModel();
	
	
	/**
	 * Erstellt eine SQLite Datenbank mit folgenden Inhalt<br>
	 * Tabelle: information<br>
	 * Tupel: ID, name, text, rtime, vtime<br>
	 * ID: 		Index der Datensätze<br>
	 * name: 	Name der Person, die im Video spricht<br>
	 * text:	Text der von der Person gesprochen wird<br>
	 * time:	Zeitpunkt im Video wo die Person anfängt zu reden<br><br>
	 * 
	 * Die SQLite wird an einem bestimmten Ort mit einem bestimmten Namen gespeichert<br><br>
	 * DatabaseModel.getDbPath beinhaltet den momentanen Pfad<br>
	 * DatabaseModel.getDbName beinhaltet nur den Namen ohne Typbezeichnung<br>
	 * @throws Exception
	 */
	public void createDatabase() throws Exception {
				
		Class.forName("org.sqlite.JDBC");
        Connection conn =
        		//habe .sqlite entfernt da es meiner Meinung gar nicht nötig ist
          DriverManager.getConnection("jdbc:sqlite:" + DatabaseModel.getDbpath() + DatabaseModel.getDbname());
        Statement stat = conn.createStatement();
        
        stat.executeUpdate("CREATE TABLE IF NOT EXISTS information (ID INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, text TEXT NOT NULL, time VARCHAR(12) NOT NULL, playertime LONG)");
        
        conn.close();
	}
	
	public void updateTableTime(String oldtime ,String newtime, long rtime) throws Exception{
		
		Class.forName("org.sqlite.JDBC");
        Connection conn =
        		//habe .sqlite entfernt da es meiner Meinung gar nicht nötig ist
          DriverManager.getConnection("jdbc:sqlite:" + DatabaseModel.getDbpath() + DatabaseModel.getDbname());
		
        Statement stat = conn.createStatement();
        
        stat.executeUpdate("UPDATE 'information' set 'time'= '" + newtime + "','playertime'='" + rtime + "' where time= '"+ oldtime + "'");
        
        conn.close();
	}
	
public void updateTableName(String oldtime, String name) throws Exception{
		
		Class.forName("org.sqlite.JDBC");
        Connection conn =
        		//habe .sqlite entfernt da es meiner Meinung gar nicht nötig ist
          DriverManager.getConnection("jdbc:sqlite:" + DatabaseModel.getDbpath() + DatabaseModel.getDbname());
		
        Statement stat = conn.createStatement();
        
        stat.executeUpdate("UPDATE 'information' set 'name'= '" + name + "' where time= '"+ oldtime + "'");
        
        conn.close();
	}
	
	public void updateTableText(String oldtime, String text) throws Exception{
		
		Class.forName("org.sqlite.JDBC");
        Connection conn =
        		//habe .sqlite entfernt da es meiner Meinung gar nicht nötig ist
          DriverManager.getConnection("jdbc:sqlite:" + DatabaseModel.getDbpath() + DatabaseModel.getDbname());
		
        Statement stat = conn.createStatement();
        
        stat.executeUpdate("UPDATE 'information' set 'text'= '" + text + "' where time= '"+ oldtime + "'");
        
        conn.close();
	}
	
	/**
	 * Es wird eine Verbindung zu einer SQLite Datenbank erstellt<br>
	 * Der Name der Datenbank kommt aus der <code>DatabaseModel.getDbName</code> mit Typbezeichnung ".sqlite"<br>
	 * Durch eine Datanbankabfrage("SELECT * FROM tabname;") werden alle Daten abgerufen<br>
	 * Für jede Tabellenspalte wird eine ArrayList benötigt<br>
	 * Die Daten werden dann in einer while() Schleife in das jeweilige ArrayList geschrieben<br>
	 * Anschließend werden alle Listen in eine weitere ArrayList geschrieben.<br>
	 * Diese letzte Liste wird zum Schluss an die Funktion zurückgegeben. <br>
	 *
	 * @return
	 * @throws Exception
	 */
	public ArrayList<ArrayList<String>> getData() throws Exception{
		
		Class.forName("org.sqlite.JDBC");
        Connection conn =
          DriverManager.getConnection("jdbc:sqlite:" + DatabaseModel.getDbpath() + DatabaseModel.getDbname());
        Statement stat = conn.createStatement();
        
        ResultSet rs = stat.executeQuery("select * from information;");
		
		ArrayList<String> namelist = new ArrayList<String>();
		ArrayList<String> textlist = new ArrayList<String>();
		ArrayList<String> timelist = new ArrayList<String>();
		ArrayList<ArrayList<String>> outerlist = new ArrayList<ArrayList<String>>();
		
        while (rs.next()) {

        	namelist.add(rs.getString("Name"));
        	textlist.add(rs.getString("text"));
        	timelist.add(rs.getString("time"));
        	
        }
		outerlist.add(namelist);
		outerlist.add(textlist);
		outerlist.add(timelist);
		
        rs.close();
        conn.close();
        return outerlist;
	}
	
	
	/**
	 * Es wird eine Verbindung zu einer SQLite Datenbank erstellt<br>
	 * Der Name der Datenbank kommt aus der <code>DatabaseModel.getDbName</code> mit Typbezeichnung ".sqlite"<br>
	 * Durch eine Datanbankabfrage("SELECT * FROM tabname;") werden alle Daten abgerufen.<br>
	 * Bei jedem Schleifendurchlauf der While() Schleife wird ein neuer Vector<Object> erzeugt<br>
	 * In diesem wird ein ganzer Datensatz geschrieben.<br>
	 * Am Ende der Schleife wird der Vector wiederum in einen Vector geschrieben.<br>
	 * Dieser wird anschließen zurückgegeben.<br>
	 * @return
	 * @throws Exception
	 */
	public Vector<Vector<Object>> getDataVector() throws Exception{
		
		Class.forName("org.sqlite.JDBC");
        Connection conn =
          DriverManager.getConnection("jdbc:sqlite:" + DatabaseModel.getDbpath() + DatabaseModel.getDbname());
        Statement stat = conn.createStatement();
        
        ResultSet rs = stat.executeQuery("select * from information order by 'playertime' ASC;");
		
		Vector<Vector<Object>> vectorbox = new Vector<Vector<Object>>();
		
		
        while (rs.next()) {
        	
        	Vector<Object> data = new Vector<Object>();
        	data.add(rs.getString("Name"));
        	data.add(rs.getString("text"));
        	data.add(rs.getString("time"));
        	data.add(rs.getLong("playertime"));
        	vectorbox.add(data);
        }
		
		
        rs.close();
        conn.close();
        return vectorbox;
	}
	
	
	/**
	 * 
	 * @param name
	 * @param text
	 * @param time
	 * @param playertime
	 * @throws Exception
	 */
	public void writeData(String name, String text, String time, long playertime) throws Exception {
		
		System.out.println("writeData: " + DatabaseModel.getDbpath() + DatabaseModel.getDbname());
		Class.forName("org.sqlite.JDBC");
        Connection conn =
          DriverManager.getConnection("jdbc:sqlite:" + DatabaseModel.getDbpath() + DatabaseModel.getDbname());

        PreparedStatement prep = conn.prepareStatement(
                "insert into information values (?, ?, ?, ?, ?);");

              
              prep.setString(2, name);
              prep.setString(3, text);
              prep.setString(4, time);
              prep.setLong(5, playertime);
              prep.addBatch();

              conn.setAutoCommit(false);
              prep.executeBatch();
              conn.setAutoCommit(true);
              
              conn.close();
               
	}
	
	public void deleteRow(String wert) throws Exception{
		
		Class.forName("org.sqlite.JDBC");
        Connection conn =
          DriverManager.getConnection("jdbc:sqlite:" + DatabaseModel.getDbpath() + DatabaseModel.getDbname());

        PreparedStatement prep = conn.prepareStatement("DELETE FROM information WHERE time = '" + wert + "'");
		prep.execute();
		conn.close();
	}
	
	public Vector<Vector<String>> readDBF(String file) {
		
		Vector<String> data = new Vector<String>();
		Vector<Vector<String>> vectorbox = new Vector<Vector<String>>();
		try{
			String path = DatabaseModel.getDbfpath() + DatabaseModel.getDbfname() + ".dbf";
			System.out.println("ppp " + path);
            //Open dbf file
            DBF classDB=new DBF(path);
            
            
            
            //Define fields
            CharField videotime  = (CharField) classDB.getField("VIDEOZEIT");
            CharField realtime  = (CharField) classDB.getField("REALZEIT");
            CharField person = (CharField) classDB.getField("PERSON");
            MemoField transcription = (MemoField) classDB.getField("TRANSKRIPT");
            

            for (int i = 1; i <= classDB.getRecordCount(); i++)
              {
                   classDB.read();
                   
                   		 System.out.println("VideoTime: " + videotime.get());
                         System.out.println("RealTime " + realtime.get());
                         System.out.print("Person " + person.get());
                         System.out.println("Text " + transcription.get());
                         data.add(person.get());
                         data.add(transcription.get());
                         data.add(realtime.get());
                            // this is not perfect for two reasons
                            // first,  not catching record not found exception
                            // second,  dbase logic requires returning a record with an equal or greater than key value
                        
                    } // end if undergrad test
               

    }catch(Exception e){
            e.printStackTrace();
    }
		vectorbox.add(data);
		      
		      
		      
		    
		return vectorbox;
	}
	
	public void newDB(Vector<Vector<String>> rowData) throws Exception {
		
		System.out.println("datenbankname: " + DatabaseModel.getDbfname());
		Class.forName("org.sqlite.JDBC");
        Connection conn =
          DriverManager.getConnection("jdbc:sqlite:" + DatabaseModel.getDbfpath() + DatabaseModel.getDbfname() + ".sqlite");

        
        Statement stat = conn.createStatement(); 
        stat.executeUpdate("DROP TABLE IF EXISTS information");
        stat.executeUpdate("CREATE TABLE IF NOT EXISTS information (ID INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, text TEXT NOT NULL, time VARCHAR(12) NOT NULL)");
        System.out.println("länge: " + rowData.get(0).size()/3);
        System.out.println("Inhalt: " + rowData.get(0));
        
        
        int a = 0;
        PreparedStatement prep;
              for(int i = 0; i < rowData.get(0).size()/3;i++) {
            	  
            	  prep = conn.prepareStatement(
                          "insert into information values (NULL, ?, ?, ?);");
            	  
              prep.setString(1, rowData.get(0).get(a));
              System.out.println(rowData.get(0).get(a));
              a++;
              prep.setString(2, rowData.get(0).get(a));
              System.out.println(rowData.get(0).get(a));
              a++;
              prep.setString(3, rowData.get(0).get(a));
              System.out.println(rowData.get(0).get(a));
              a++;
              try {
              prep.addBatch();
              conn.setAutoCommit(false);
              prep.executeBatch();
              conn.setAutoCommit(true);
              } catch(Exception e) {
            	  System.out.println(e.getMessage());
              }
              
              }
              

              
              
              conn.close();
	}
}
