package model;

import java.text.DateFormat;

import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;


public class PlayerWindowModel {

	static String time;
	static long playtime;
	static DateFormat fulltime;
	static String playtimeFull;
	static boolean playing;
	static EmbeddedMediaPlayer player;
	
	/**
	 * Gibt den aktuellen Modus des Mediaplayers zurück
	 * @return
	 */
	public static boolean getIsPlaying() {
		return playing;
	}
	
	/**
	 * Hier wird der Mediaplayermodus gesetzt
	 * @param playing
	 */
	public static void setIsPlaying(boolean playing) {
		PlayerWindowModel.playing = playing;
	}
	
	public static String getPlayTimeFull() {
		return playtimeFull;
	}
	public static void setPlayTimeFull(String playtimeFull) {
		PlayerWindowModel.playtimeFull = playtimeFull;
	}
	
	public static  DateFormat getFulltime() {
		return fulltime;
	}
	public  void setFulltime(DateFormat fulltime) {
		PlayerWindowModel.fulltime = fulltime;
	}
	
	
	
	
	public long getPlayTime() {
		return playtime;
	}
	
	public static void  setPlayTime(long time) {
		PlayerWindowModel.playtime = time;
	}
	
	public EmbeddedMediaPlayer getPlayer() {
		return player;
	}
	public void setPlayer(EmbeddedMediaPlayer Player) {
		player = Player;
	}
}
