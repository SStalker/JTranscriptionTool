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
	 * Gibt den momentanen Pfad zur�ck
	 * Falls keine Videodatei ausgew�hlt ist gibt die Funktion "NULL" zur�ck
	 * @return
	 */
	public String getPlayPath() {
		return PlayWindowModel.playpath;
	}
		
	/**
	 * Gibt einen Label zurück
	 * @return
	 */
	public static JLabel getZeit() {
		
		return Zeit;
	}

	/**
	 * Der übergebene JLabel im Parameter der Funktion wird 
	 * dem statischen JLabel Zeit zugewiesen.
	 * @param zeit
	 */
	public static void setZeit(JLabel zeit) {
		TranscriptionWindowModel.Zeit = zeit;
	}

	
	
}
