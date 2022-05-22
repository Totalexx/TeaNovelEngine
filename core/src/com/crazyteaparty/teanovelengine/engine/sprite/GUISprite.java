package com.crazyteaparty.teanovelengine.engine.sprite;

import com.crazyteaparty.teanovelengine.game.Config;

public class GUISprite extends Sprites{

	public GUISprite(String texturePathFile, int x, int y, int width, int height) {
	
		super(Config.PATH_TO_GUI_IMAGE + texturePathFile, x, y, width, height);

	}

}
