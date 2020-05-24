	package com.crazyteaparty.teanovellaengine.model.images;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class NovelSprite {
	
	public Rectangle bounds;
	public Sprite object;
	
	public NovelSprite(Texture texture, float x, float y, float width, float height) {
		
		bounds = new Rectangle(x, y, width, height);
		object = new Sprite(texture); 
		
	}
	
	public void draw(SpriteBatch batch) {
		
		object.setBounds(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
		object.draw(batch);
		
	}
	
	public void setTexture(Texture texture){
		
		object.setTexture(texture);
		
	}
	
	public void setBounds(float x, float y, float width, float height){
	
		bounds.set(x, y, width, height);
		object.setBounds(x, y, width, height);
	}
	
}
