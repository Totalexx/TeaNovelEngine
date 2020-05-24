	package com.crazyteaparty.teanovellaengine.model.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.crazyteaparty.teanovellaengine.NovelConfig;

public abstract class NovelSprite {
	
	public Rectangle bounds;
	public Sprite sprite;
	
	public NovelSprite(Texture texture, float x, float y, float width, float height) {
		//float centerX = (float)texture.getWidth() * NovelConfig.CAMERA_WIDTH / (float)Gdx.graphics.getWidth() / 2;
		//float centerY = (float)texture.getHeight() * NovelConfig.CAMERA_HEIGHT / (float)Gdx.graphics.getHeight() / 2;
		bounds = new Rectangle(x, y, width, height);
		sprite = new Sprite(texture); 
	}
	
	public void draw(SpriteBatch batch) {
		sprite.setBounds(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
		sprite.draw(batch);
	}
	
	public void setTexture(Texture texture){
		sprite.setTexture(texture);
	}
	
	public void setBounds(float x, float y, float width, float height){
		bounds.set(x, y, width, height);
		sprite.setBounds(x, y, width, height);
	}
	
	public void setScale(float scaleXY){
		sprite.setScale(scaleXY);
	}
	
	public void setScale(float scaleX, float scaleY){
		sprite.setScale(scaleX, scaleY);
	}
	
	public void setRotation(float degrees){
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
