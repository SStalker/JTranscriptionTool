package model;



public class MainWindowModel {

//Falls es doch gebraucht war
	/*	private String test;
	public void setString(String string) {
		this.test = string;
	}
	
	public String getString() {
		return test;
	}*/
	
	private static String libraryPath;
	
//------------------Getter und Setter----------------------//
	public static String getLibraryPath() {
		return libraryPath;
	}

	public static void setLibraryPath(String libraryPath) {
		MainWindowModel.libraryPath = libraryPath;
	}
}
