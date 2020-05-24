package com.crazyteaparty.teanovellaengine.model.images;

import com.badlogic.gdx.graphics.Texture;
import com.crazyteaparty.teanovellaengine.Main;
import com.crazyteaparty.teanovellaengine.NovelConfig;

public class NovelBackground extends NovelSprite{

	public NovelBackground(Texture texture) {
		super(texture, -NovelConfig.CAMERA_WIDTH / 2, -NovelConfig.CAMERA_HEIGHT / 2, NovelConfig.CAMERA_WIDTH, NovelConfig.CAMERA_HEIGHT);	
	}
	
	public NovelBackground(Texture texture, float x, float y, float width, float height) {
		super(texture, x, y, width, height);
	}
	
}
