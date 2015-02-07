package at.hakkon.performancetest.desktop;

import java.awt.Dimension;
import java.awt.Toolkit;

import at.hakkon.performancetest.PerformanceTest;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();		
		config.width = (int) screenSize.getWidth();
		config.height = (int) screenSize.getHeight();
////		
//		config.width = (int)800;
//		config.height = (int) 480;
		config.fullscreen = true;
		config.vSyncEnabled = true;
		new LwjglApplication(new PerformanceTest(), config);
	}
}
