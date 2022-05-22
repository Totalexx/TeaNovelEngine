package com.crazyteaparty.teanovelengine.game;

public abstract class Config{

	/** Title novel. */
	public static final String NOVEL_TITLE = "TeaNovelEngine";
	
	/** Enable fullscreen. */
	public static final boolean FULLSCREEN = false;
	
	/** window width in pixels at startup. */
	public static final int WINDOW_WIDTH = 1066;
	/** Window height in pixels at startup. */
	public static final int WINDOW_HEIGHT = 600;
	
	/** Background width in pixels. */
	public static final int SCENE_WIDTH = 1280;
	/** Background height in pixels. */
	public static final int SCENE_HEIGHT = 720;

	/** FPS limit. Set 0 to disable FPS limit. */
	public static final int FPS = 60;
	
	/** Virtual units. This number is equal to the width of the window.*/
	public static final int VIRTUAL_WIDTH = 100;
	/** Virtual units. This number is equal to the height of the window.*/
	public static final int VIRTUAL_HEIGHT = 100;
	
	/** Enable debug mode. */
	public static final boolean DEBUG = true;
	
	/** Path to the default font. */
	public static final String DEFAULT_FONT_NAME = "Montserrat";
	/** Path to the font folder. */
	public static final String PATH_TO_FONT = "gui/fonts/";
	/** Path to GUI image folder. */
	public static final String PATH_TO_GUI_IMAGE = "gui/images/";
	/** Path to character image folder. */
	public static final String PATH_TO_IMAGES_CHARACTERS = "images/characters/";
	/** Path to background image folder. */
	public static final String PATH_TO_IMAGES_BACKGROUNDS = "images/backgrounds/";
	/** Path to sounds folder. */
	public static final String PATH_TO_SOUNDS = "audio/sounds/";
	/** Path to music folder. */
	public static final String PATH_TO_MUSIC = "audio/music/";
	
	/** This code be executed at startup. */
	public static void setConfiguration() {
		// Write here your code
	}
	
}
