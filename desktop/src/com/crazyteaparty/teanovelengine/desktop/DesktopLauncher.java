package com.crazyteaparty.teanovelengine.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.crazyteaparty.teanovelengine.engine.Main;
import com.crazyteaparty.teanovelengine.game.Config;

public class DesktopLauncher {
	
	public static void main (String[] arg) {
	
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = Config.NOVEL_TITLE;
		config.fullscreen = Config.FULLSCREEN;
		config.width = Config.WINDOW_WIDTH;
		config.height = Config.WINDOW_HEIGHT;
		config.backgroundFPS = Config.FPS;
		config.foregroundFPS = Config.FPS;
		//config.addIcon(path, fileType);
		new LwjglApplication(new Main(), config);
	
	}
	
}
