package com.crazyteaparty.teanovelengine.engine.sprite;

import com.crazyteaparty.teanovelengine.engine.Config;
import com.crazyteaparty.teanovelengine.engine.file.Assets;
import com.crazyteaparty.teanovelengine.engine.utils.ConvertSize;

public class Character extends Sprites{ 
	
	public Character(String texturePathFile, float x, float y) {
		super(Config.PATH_TO_IMAGES_CHARACTERS + texturePathFile,
				(float) x - ConvertSize.realWidthToVirtual(Assets.getTexture(Config.PATH_TO_IMAGES_CHARACTERS + texturePathFile).getWidth()) / 2,
				(float) y - ConvertSize.realHeightToVirtual(Assets.getTexture(Config.PATH_TO_IMAGES_CHARACTERS + texturePathFile).getHeight()) / 2, 
				(float) Assets.getTexture(Config.PATH_TO_IMAGES_CHARACTERS + texturePathFile).getWidth(),
				(float) Assets.getTexture(Config.PATH_TO_IMAGES_CHARACTERS + texturePathFile).getHeight());
		setOrigin(getWidth() / 2, getHeight() / 2);
		sprite.setOrigin(getWidth() / 2, getHeight() / 2);
	}
	
	public void setTexture(String texturePathFile) {
		super.setTexture(Config.PATH_TO_IMAGES_CHARACTERS + texturePathFile);
	}

}
