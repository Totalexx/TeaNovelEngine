package com.crazyteaparty.teanovelengine.engine.sprite;

import com.crazyteaparty.teanovelengine.engine.Config;

public class Character extends Sprites{ 
	
	public Character(String texturePathFile, float x, float y) {
		super(Config.PATH_TO_IMAGES_CHARACTERS + texturePathFile, x, y);
	}
	
	public void setTexture(String texturePathFile) {
		super.setTexture(Config.PATH_TO_IMAGES_CHARACTERS + texturePathFile);
	}
}
