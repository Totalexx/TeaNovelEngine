package com.crazyteaparty.teanovelengine.engine.audio;

import com.badlogic.gdx.audio.Sound;
import com.crazyteaparty.teanovelengine.engine.GameManager;

public class GameSound{

	Sound sound;
	
	long idSound = 0;
	
	/**
	 * creates a new sound. Only supports mp3 format.
	 * 
	 * @param pathToSound
	 */
	public GameSound (String pathToSound) {
		GameManager.assets.loadSound(pathToSound);
		GameManager.assets.finishLoading();
		sound = GameManager.assets.getSound(pathToSound);
	}
	
	public void play (float volume) {
		idSound = sound.play(volume / 100);
	}
	
	public void stop () {
		sound.stop();
	}
	
	public void loop () {
		sound.loop();
	}
	
	/**
	 * Sets volume for sound. 100 is the maximum, 0 is the minimum.
	 * 
	 * @param volume
	 */
	public void setVolume (float volume) {
		sound.setVolume(idSound, volume / 100);
	}
	
}
