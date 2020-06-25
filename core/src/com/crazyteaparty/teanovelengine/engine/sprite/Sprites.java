package com.crazyteaparty.teanovelengine.engine.sprite;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.crazyteaparty.teanovelengine.engine.GameManager;
import com.crazyteaparty.teanovelengine.engine.utils.ConvertSize;

public abstract class Sprites extends Actor{
	
	protected Sprite sprite;
	
	public Sprites(String texturePathFile) {
		sprite = new Sprite(GameManager.assets.getTexture(texturePathFile));
	}
	
	public Sprites(String texturePathFile, int x, int y, int width, int height) {
		sprite = new Sprite(GameManager.assets.getTexture(texturePathFile));
		setBounds(x, y, width, height);
		sprite.setOrigin(0, 0);
	}
	
	public Sprites(String texturePathFile, float x, float y, float width, float height) {
		sprite = new Sprite(GameManager.assets.getTexture(texturePathFile));
		x = ConvertSize.virtualXToReal(x);
		y = ConvertSize.virtualYToReal(y);
		super.setBounds(x, y, width, height);
		sprite.setBounds(x, y, width, height);
		sprite.setOrigin(0, 0);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		sprite.draw(batch);
	}
	
	public void setTexture(String texturePathFile){
		sprite.setTexture(GameManager.assets.getTexture(texturePathFile));
	}
	
	@Override
	public void setBounds(float x, float y, float width, float height){
		x = ConvertSize.virtualXToReal(x);
		y = ConvertSize.virtualYToReal(y);
		width = ConvertSize.virtualWidthToReal(width);
		height = ConvertSize.virtualHeightToReal(height);
		super.setBounds(x, y, width, height);
		sprite.setBounds(x, y, width, height);
	}
	
	@Override
	public void setScale(float scaleXY){
		super.setScale(scaleXY);
		sprite.setScale(scaleXY);
	}
	
	@Override
	public void setScale(float scaleX, float scaleY){
		super.setScale(scaleX, scaleY);
		sprite.setScale(scaleX, scaleY);
	}
	
	@Override
	public void setPosition(float x, float y) {
		x = ConvertSize.virtualXToReal(x);
		y = ConvertSize.virtualYToReal(y);
		super.setPosition(x, y);
		sprite.setPosition(x, y);
	}
	
	@Override
	public void setRotation(float degrees){
		super.setRotation(degrees);
		sprite.setRotation(degrees);
	}
	
	public void setFlip(boolean flipX, boolean flipY){
		sprite.setFlip(flipX, flipY);
	}
	
	public void setFlipX(boolean flipX){
		sprite.setFlip(flipX, sprite.isFlipY());
	}
	
	public void setFlipY(boolean flipY){
		sprite.setFlip(sprite.isFlipX(), flipY);
	}
	
}
