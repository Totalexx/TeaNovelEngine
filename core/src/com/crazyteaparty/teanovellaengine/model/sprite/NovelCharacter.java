package com.crazyteaparty.teanovellaengine.model.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.crazyteaparty.teanovellaengine.NovelConfig;

public class NovelCharacter extends NovelSprite{ 
	
	public NovelCharacter(Texture texture, float x, float y) {
		super(
				texture, 
				x - (float)texture.getWidth() * NovelConfig.CAMERA_WIDTH / (float)Gdx.graphics.getWidth() / 2, 
				y - (float)texture.getHeight() * NovelConfig.CAMERA_HEIGHT / (float)Gdx.graphics.getHeight() / 2,
				(float)texture.getWidth() * NovelConfig.CAMERA_WIDTH / (float)Gdx.graphics.getWidth(),
				(float)texture.getHeight() * NovelConfig.CAMERA_HEIGHT / (float)Gdx.graphics.getHeight());
	}
	
}
