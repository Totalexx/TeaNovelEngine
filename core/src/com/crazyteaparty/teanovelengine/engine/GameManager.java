package com.crazyteaparty.teanovelengine.engine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.crazyteaparty.teanovelengine.engine.file.Assets;
import com.crazyteaparty.teanovelengine.game.Config;

public class GameManager {

	public static Assets assets = new Assets();
	public static OrthographicCamera camera = new OrthographicCamera();
	public static Viewport viewport = new FitViewport(Config.SCENE_WIDTH, Config.SCENE_HEIGHT, camera);
	
	public static void init () {
		assets.init();
		viewport.apply();
	}
	
	/** Sets the title*/
	public static void setTitle (String title) {
		Gdx.graphics.setTitle(title);
	}
	
	/** Sets fullscreen*/
	public static void setFullScreen (boolean fullscreen) {
		if (fullscreen) {
			
		} else {
			
		}
	}
	
	public static void resize (float width, float height) {
	}
	
	public static void dispose () {
		assets.dispose();
	}
	
}
