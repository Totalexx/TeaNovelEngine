package com.crazyteaparty.teanovelengine.engine.sprite;

import com.crazyteaparty.teanovelengine.engine.Config;

public class GUI extends Sprites{

	public GUI(String texturePathFile, int x, int y, int width, int height) {
	
		super(Config.PATH_TO_GUI_IMAGE + texturePathFile, x, y, width, height);

	}

}
