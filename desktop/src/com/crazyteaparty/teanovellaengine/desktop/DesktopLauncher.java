package com.crazyteaparty.teanovellaengine.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.crazyteaparty.teanovellaengine.Main;
import com.crazyteaparty.teanovellaengine.NovelConfig;

public class DesktopLauncher {
	
	public static void main (String[] arg) {
	
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = NovelConfig.NOVEL_TITLE;
		config.fullscreen = NovelConfig.FULLSCREEN;
		config.width = NovelConfig.WINDOW_WIDTH;
		config.height = NovelConfig.WINDOW_HEIGHT;
		config.backgroundFPS = NovelConfig.FPS;
		config.foregroundFPS = NovelConfig.FPS;
		new LwjglApplication(new Main(), config);
	
	}
	
}
