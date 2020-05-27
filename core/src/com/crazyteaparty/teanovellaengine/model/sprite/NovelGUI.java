package com.crazyteaparty.teanovellaengine.model.sprite;

import com.crazyteaparty.teanovellaengine.NovelConfig;

public class NovelGUI extends NovelSprite{

	public NovelGUI(String texturePathFile, float x, float y, float width, float height) {
	
		super(NovelConfig.PATH_TO_GUI_IMAGE + texturePathFile, x, y, width, height);

	}

}
