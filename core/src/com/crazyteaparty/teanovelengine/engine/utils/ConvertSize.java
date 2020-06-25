package com.crazyteaparty.teanovelengine.engine.utils;

import com.crazyteaparty.teanovelengine.game.Config;

public abstract class ConvertSize {

	public static float virtualXToReal (float x) {
		return (float) Config.SCENE_WIDTH * x / (float) Config.VIRTUAL_WIDTH;
	}
	
	public static float virtualYToReal (float y) {
		return (float) Config.SCENE_HEIGHT * y / (float) Config.VIRTUAL_HEIGHT;
	}
	
	public static float virtualWidthToReal (float width) {
		return virtualXToReal(width);
	}
	
	public static float virtualHeightToReal (float height) {
		return virtualYToReal(height);
	}
	
	public static float realXToVirtual (float x) {
		return (float) Config.VIRTUAL_WIDTH * x / (float) Config.SCENE_WIDTH;
	}
	
	public static float realYToVirtual (float y) {
		return (float) Config.VIRTUAL_HEIGHT * y / (float) Config.SCENE_HEIGHT;
	}
	
	public static float realWidthToVirtual (float width) {
		return realXToVirtual(width);
	}
	
	public static float realHeightToVirtual (float height) {
		return realXToVirtual(height);
	}
	
}
