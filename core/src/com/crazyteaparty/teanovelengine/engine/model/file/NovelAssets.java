package com.crazyteaparty.teanovelengine.engine.model.file;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.crazyteaparty.teanovelengine.engine.NovelConfig;

public class NovelAssets {
	
	private static AssetManager assetManager = new AssetManager();
	
	public static <T> void load (String pathToFile, Class <T> type) {
		assetManager.load(pathToFile, type);
	}
	
	public static void loadBackground(String pathToFile){
		load(NovelConfig.PATH_TO_IMAGES_BACKGROUNDS + pathToFile, Texture.class);
	}
	
	public static void loadCharacter(String pathToFile){
		load(NovelConfig.PATH_TO_IMAGES_CHARACTERS + pathToFile, Texture.class);
	}
	
	public static void loadTexture(String pathToFile){
		load(pathToFile, Texture.class);
	}
	
	public static void loadGUITexture(String pathToFile){
		load(NovelConfig.PATH_TO_GUI_IMAGE + pathToFile, Texture.class);
	}
	
	public static <T> T get (String pathToFile, Class <T> type) {
		return (T) assetManager.get(pathToFile, type);
	}
	
	public static <T> Texture getTexture (String pathToFile) {
		return assetManager.get(pathToFile, Texture.class);
	}
	
	public static boolean isLoaded (String pathToFile) {
		return assetManager.isLoaded(pathToFile);
	}
	
	public static void dispose () {
		assetManager.dispose();
	}
	
	public static AssetManager getAssetManager () {
		return assetManager;
	}
	
	public static void waitLoadAsset () {
		while(!assetManager.update()) {}
	}
	
}
