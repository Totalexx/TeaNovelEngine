package com.crazyteaparty.teanovelengine.engine.sprite;

import com.crazyteaparty.teanovelengine.engine.NovelConfig;

public class NovelBackground extends NovelSprite{

	public NovelBackground(String texturePathFile) {
		super(
				NovelConfig.PATH_TO_IMAGES_BACKGROUNDS + texturePathFile,
				-NovelConfig.CAMERA_WIDTH / 2,
				-NovelConfig.CAMERA_HEIGHT / 2,
				NovelConfig.CAMERA_WIDTH,
				NovelConfig.CAMERA_HEIGHT);	
	}
	
	public NovelBackground(String texturePathFile, float x, float y, float width, float height) {
		super(NovelConfig.PATH_TO_IMAGES_BACKGROUNDS + texturePathFile, x, y, width, height);
	}
	
	public void setTexture(String texturePathFile) {
		super.setTexture(NovelConfig.PATH_TO_IMAGES_BACKGROUNDS + texturePathFile);
	}
	
}
