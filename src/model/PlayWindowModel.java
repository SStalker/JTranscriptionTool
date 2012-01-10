package model;

import javax.swing.JLabel;

public class PlayWindowModel {

	static  String playpath;
	static JLabel Zeit;
	
	/**
	 * Speichert den Wiedergabepfad in die Klassenvariable "playpath"
	 * @param path
	 */
	public void setPlayPath(String path) {
		playpath = path;
	}
	
	/**
	 * Gibt den momentanen Pfad zurück
	 * Falls keine Videodatei ausgewählt ist gibt die Funktion "NULL" zurück
	 * @return
	 */
	public String getPlayPath() {
		return PlayWindowModel.playpath;
	}
		
	/**
	 * Gibt einen Label zur√ºck
	 * @return
	 */
	public static JLabel getZeit() {
		
		return Zeit;
	}

	/**
	 * Der √ºbergebene JLabel im Parameter der Funktion wird 
	 * dem statischen JLabel Zeit zugewiesen.
	 * @param zeit
	 */
	public static void setZeit(JLabel zeit) {
		TranscriptionWindowModel.Zeit = zeit;
	}

	
	
}
