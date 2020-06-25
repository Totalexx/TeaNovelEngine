package com.crazyteaparty.teanovelengine.engine.sprite;

import com.crazyteaparty.teanovelengine.engine.GameManager;
import com.crazyteaparty.teanovelengine.engine.utils.ConvertSize;
import com.crazyteaparty.teanovelengine.game.Config;

public class Character extends Sprites{ 
	
	public Character(String texturePathFile, float x, float y) {
		super(Config.PATH_TO_IMAGES_CHARACTERS + texturePathFile,
				(float) x - ConvertSize.realWidthToVirtual(GameManager.assets.getTexture(Config.PATH_TO_IMAGES_CHARACTERS + texturePathFile).getWidth()) / 2,
				(float) y - ConvertSize.realHeightToVirtual(GameManager.assets.getTexture(Config.PATH_TO_IMAGES_CHARACTERS + texturePathFile).getHeight()) / 2, 
				(float) GameManager.assets.getTexture(Config.PATH_TO_IMAGES_CHARACTERS + texturePathFile).getWidth(),
				(float) GameManager.assets.getTexture(Config.PATH_TO_IMAGES_CHARACTERS + texturePathFile).getHeight());
		float width = getWidth() / 2;
		float height = getHeight() / 2;
		setOrigin(width, height);
		sprite.setOrigin(width, height);
	}
	
	public void setTexture(String texturePathFile) {
		super.setTexture(Config.PATH_TO_IMAGES_CHARACTERS + texturePathFile);
	}
	
}
