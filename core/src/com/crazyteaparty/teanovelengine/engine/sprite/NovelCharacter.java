package com.crazyteaparty.teanovelengine.engine.sprite;

import com.crazyteaparty.teanovelengine.engine.NovelConfig;

public class NovelCharacter extends NovelSprite{ 
	
	public NovelCharacter(String texturePathFile, float x, float y) {
		super(NovelConfig.PATH_TO_IMAGES_CHARACTERS + texturePathFile, x, y);
	}
	
	public void setTexture(String texturePathFile) {
		super.setTexture(NovelConfig.PATH_TO_IMAGES_CHARACTERS + texturePathFile);
	}
}
