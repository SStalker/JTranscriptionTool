package model;



public class DatabaseModel {

	static String dbname;
	static String dbpath;
	static String dbfname;
	static String dbfpath;

	
//---------Getter und Setters-----------//

	public static String getDbname() {
		return dbname;
	}

	public static void setDbname(String dbname) {
		DatabaseModel.dbname = dbname;
	}

	public static String getDbpath() {
		return dbpath;
	}

	public static void setDbpath(String dbpath) {
		DatabaseModel.dbpath = dbpath;
	}
	
	public static String getDbfname() {
		return dbfname;
	}

	public static void setDbfname(String dbfname) {
		DatabaseModel.dbfname = dbfname;
	}

	public static String getDbfpath() {
		return dbfpath;
	}

	public static void setDbfpath(String dbfpath) {
		DatabaseModel.dbfpath = dbfpath;
	}
	
	
	
	
}
