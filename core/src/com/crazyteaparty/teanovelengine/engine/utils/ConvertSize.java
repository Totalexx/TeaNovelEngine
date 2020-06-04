package com.crazyteaparty.teanovelengine.engine.utils;

import com.badlogic.gdx.Gdx;
import com.crazyteaparty.teanovelengine.engine.Config;

public abstract class ConvertSize {

	public static float virtualXToReal(float x) {
		return x / Config.VIRTUAL_WIDTH * (float)Gdx.graphics.getWidth();
	}
	
	public static float virtualYToReal(float y) {
		return y / Config.VIRTUAL_HEIGHT * (float)Gdx.graphics.getHeight();
	}
	
	public static float virtualWidthToReal(float width) {
		return virtualXToReal(width);
	}
	
	public static float virtualHeightToReal(float height) {
		return virtualYToReal(height);
	}
	
	public static float realXToVirtual(float x) {
		return x * Config.VIRTUAL_WIDTH / (float)Gdx.graphics.getWidth();
	}
	
	public static float realYToVirtual(float y) {
		return y * Config.VIRTUAL_HEIGHT / (float)Gdx.graphics.getHeight();
	}
	
	public static float realWidthToVirtual(float width) {
		return width * Config.VIRTUAL_WIDTH / (float)Gdx.graphics.getWidth();
	}
	
	public static float realHeightToVirtual(float height) {
		return height * Config.VIRTUAL_HEIGHT / (float)Gdx.graphics.getHeight();
	}
	
}
