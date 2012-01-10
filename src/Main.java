import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import com.sun.jna.NativeLibrary;

import specialclasses.Troubleshooter;

import controller.MainWindowControl;




public class Main {

	static MainWindowControl mainwindowcontrol;
	
	
	
	public static void main(String[] args) {
		
		/**
		 * Linux 32Bit
		 * Windows 32Bit
		 * MacOS 64Bit
		 */
		//NativeLibrary.addSearchPath("libvlc","/usr/lib");
		//NativeLibrary.addSearchPath("libvlc","C:\\Users\\SStalker\\workspace\\vlc-1.2.0-nightly");
		//NativeLibrary.addSearchPath("vlc","/Users/grewe/Documents/MacOS_64_14_DEZ_STABLE/lib");
		Troubleshooter.getInfo();
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
			System.out.println("Geht nicht");
		}
		mainwindowcontrol = new MainWindowControl();
	
		
		
		
	}

}
