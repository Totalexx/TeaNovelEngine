package com.crazyteaparty.teanovelengine.engine.sprite;

import com.crazyteaparty.teanovelengine.engine.NovelConfig;

public class NovelGUI extends NovelSprite{

	public NovelGUI(String texturePathFile, float x, float y, float width, float height) {
	
		super(NovelConfig.PATH_TO_GUI_IMAGE + texturePathFile, x, y, width, height);

	}

}
