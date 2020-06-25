package com.crazyteaparty.teanovelengine.engine.audio;

import com.badlogic.gdx.audio.Music;
import com.crazyteaparty.teanovelengine.engine.GameManager;

public class GameMusic {
	
	Music music;
	
	/**
	 * creates a new music. Only supports mp3 format.
	 * 
	 * @param pathToMusic
	 */
	public GameMusic(String pathToMusic){
		GameManager.assets.loadMusic(pathToMusic);
		GameManager.assets.finishLoading();
		music = GameManager.assets.getMusic(pathToMusic);
	}
	
	public void play (float volume) {
		music.setVolume(volume);
		music.play();
	}
	
	public void stop () {
		music.stop();
	}
	
	public void setLooping (boolean looping) {
		music.setLooping(looping);
		
	}
	/**
	 * Sets volume for music. 100 is the maximum, 0 is the minimum.
	 * 
	 * @param volume
	 */
	public void setVolume (float volume) {
		music.setVolume(volume / 100);
	}

	public boolean isPlaying () {
		return music.isPlaying();
	}
	
	public float getPosition () {
		return music.getPosition();
	}
	
}
