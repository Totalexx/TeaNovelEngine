package com.crazyteaparty.teanovelengine.engine.sprite;

import com.crazyteaparty.teanovelengine.engine.Config;

public class Background extends Sprites{

	public Background(String texturePathFile) {
		super(
				Config.PATH_TO_IMAGES_BACKGROUNDS + texturePathFile,
				0,
				0,
				Config.VIRTUAL_WIDTH,
				Config.VIRTUAL_HEIGHT);	
	}
	
	public Background(String texturePathFile, int x, int y, int width, int height) {
		super(Config.PATH_TO_IMAGES_BACKGROUNDS + texturePathFile, x, y, width, height);
	}
	
	public void setTexture(String texturePathFile) {
		super.setTexture(Config.PATH_TO_IMAGES_BACKGROUNDS + texturePathFile);
	}
	
}
