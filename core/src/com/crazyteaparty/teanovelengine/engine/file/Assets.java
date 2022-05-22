package com.crazyteaparty.teanovelengine.engine.file;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.DistanceFieldFont;
import com.crazyteaparty.teanovelengine.engine.text.DistanceFieldFontLoader;
import com.crazyteaparty.teanovelengine.game.Config;

public class Assets extends AssetManager{
	
	FileHandleResolver resolver;
	public void init () {
		resolver = getFileHandleResolver();
		setLoader(DistanceFieldFont.class, new DistanceFieldFontLoader(resolver));
		
	}

	public void loadBackground (String pathToFile) {
		load(Config.PATH_TO_IMAGES_BACKGROUNDS + pathToFile, Texture.class);
	}
	
	public void loadCharacter (String pathToFile) {
		load(Config.PATH_TO_IMAGES_CHARACTERS + pathToFile, Texture.class);
	}
	
	public void loadTexture (String pathToFile) {
		load(pathToFile, Texture.class);
	}
	
	public void loadFont (String pathToFile) {
		load(pathToFile, DistanceFieldFont.class);
	}
	
	public void loadGUITexture (String pathToFile) {
		load(Config.PATH_TO_GUI_IMAGE + pathToFile, Texture.class);
	}
	
	public void loadMusic (String pathToFile) {
		load(Config.PATH_TO_MUSIC + pathToFile, Music.class);
	}
	
	public void loadSound (String pathToFile) {
		load(Config.PATH_TO_SOUNDS + pathToFile, Sound.class);
	}

	public Texture getTexture (String pathToFile) {
		return get(pathToFile, Texture.class);
	}
	
	public DistanceFieldFont getFont (String pathToFile) {
		return get(pathToFile, DistanceFieldFont.class);
	}
	
	public Music getMusic (String pathToFile) {
		return get(Config.PATH_TO_MUSIC + pathToFile, Music.class);
	}
	
	public Sound getSound (String pathToFile) {
		return get(Config.PATH_TO_SOUNDS + pathToFile, Sound.class);
	}
	
}
