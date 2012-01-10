package model;

import javax.swing.JLabel;
import javax.swing.JSlider;

public class TranscriptionWindowModel {

	static JLabel Zeit;
	static JSlider Video;
	static String wert;
	static long currentValue;
	
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

	public JSlider getVideo() {
		return Video;
	}

	public void setVideo(JSlider video) {
		TranscriptionWindowModel.Video = video;
	}
	
	public void setZeitValue(String time) {
		
		wert = time;
	}
	
	public String getZeitvalue() {
		
		return Zeit.getText();
	}

	public static String getWert() {
		return wert;
	}

	public static void setWert(String wert) {
		TranscriptionWindowModel.wert = wert;
	}

	public static long getCurrentValue() {
		return currentValue;
	}

	public static void setCurrentValue(long currentValue) {
		TranscriptionWindowModel.currentValue = currentValue;
	}
	
	
}
