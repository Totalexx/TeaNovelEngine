package com.crazyteaparty.teanovelengine.engine.sprite;

import com.crazyteaparty.teanovelengine.engine.Config;

public class Background extends Sprites{

	public Background(String texturePathFile) {
		super(
				Config.PATH_TO_IMAGES_BACKGROUNDS + texturePathFile,
				-Config.CAMERA_WIDTH / 2,
				-Config.CAMERA_HEIGHT / 2,
				Config.CAMERA_WIDTH,
				Config.CAMERA_HEIGHT);	
	}
	
	public Background(String texturePathFile, float x, float y, float width, float height) {
		super(Config.PATH_TO_IMAGES_BACKGROUNDS + texturePathFile, x, y, width, height);
	}
	
	public void setTexture(String texturePathFile) {
		super.setTexture(Config.PATH_TO_IMAGES_BACKGROUNDS + texturePathFile);
	}
	
}
