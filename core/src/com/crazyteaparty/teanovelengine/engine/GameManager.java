package com.crazyteaparty.teanovelengine.engine;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.crazyteaparty.teanovelengine.engine.file.Assets;

public abstract class GameManager {

	public static Assets assetManager = new Assets();
	public static OrthographicCamera camera = new OrthographicCamera(Config.CAMERA_WIDTH, Config.CAMERA_HEIGHT);
	
	public static void dispose () {
		Assets.dispose();
	}
	
}
