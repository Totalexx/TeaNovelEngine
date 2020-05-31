package com.crazyteaparty.teanovelengine.engine.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.crazyteaparty.teanovelengine.engine.NovelConfig;
import com.crazyteaparty.teanovelengine.engine.file.NovelAssets;

public abstract class NovelSprite {
	
	public Rectangle bounds;
	public Sprite sprite;
	
	//public static Texture emptyTexture = new Texture(Gdx.files.internal(NovelConfig.PATH_TO_GUI_IMAGE + "empty.jpg"));
	
	public NovelSprite(String texturePathFile, float x, float y, float width, float height) {
		//NovelAssets.loadTexture(texturePathFile);
		bounds = new Rectangle(x, y, width, height);
		sprite = new Sprite(NovelAssets.getTexture(texturePathFile)); 
	}
	
	public NovelSprite(String texturePathFile, float x, float y) {
		NovelAssets.loadTexture(texturePathFile);
		float virtualWidthTexture = (float)NovelAssets.getTexture(texturePathFile).getWidth()
				* NovelConfig.CAMERA_WIDTH / (float)Gdx.graphics.getWidth();
		float virtualHeightTexture = (float)NovelAssets.getTexture(texturePathFile).getHeight()
				* NovelConfig.CAMERA_HEIGHT / (float)Gdx.graphics.getHeight();
		bounds = new Rectangle(x - virtualWidthTexture / 2, y - virtualHeightTexture / 2, virtualWidthTexture, virtualHeightTexture);
		sprite = new Sprite(NovelAssets.getTexture(texturePathFile)); 
	}
	
	public void draw(SpriteBatch batch) {
		sprite.setBounds(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
		sprite.draw(batch);
	}
	
	public void setTexture(String texturePathFile){
		//NovelAssets.loadTexture(texturePathFile);
		//NovelAssets.getAssetManager().finishLoadingAsset(texturePathFile);
		//sprite.setTexture(emptyTexture);
		sprite.setTexture(NovelAssets.getTexture(texturePathFile));
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
