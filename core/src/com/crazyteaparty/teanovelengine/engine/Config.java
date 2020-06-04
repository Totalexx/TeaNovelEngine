package com.crazyteaparty.teanovelengine.engine;

import com.rafaskoberg.gdx.typinglabel.TypingConfig;

public abstract class Config {

	/** Title novel*/
	public static final String NOVEL_TITLE = "TeaNovelEngine";
	public static final boolean FULLSCREEN = false;
	public static final int WINDOW_WIDTH = 1066;
	public static final int WINDOW_HEIGHT = 600;
	public static final float ASPECT_RATIO = (float) WINDOW_WIDTH / (float) WINDOW_HEIGHT;
	
	public static float CAMERA_WIDTH = WINDOW_WIDTH;
	public static float CAMERA_HEIGHT = WINDOW_HEIGHT;
	
	public static final int VIRTUAL_WIDTH = 100;
	public static final int VIRTUAL_HEIGHT = 100;
	
	public static final int FPS = 60;
	
	public static final boolean DEBUG = true;
	
	public static final String DEFAULT_FONT_PATH = "Montserrat-Regular.ttf";
	
	/** Path to fonts*/
	public static final String PATH_TO_FONT = "gui/fonts/";
	/** Path to GUI images*/
	public static final String PATH_TO_GUI_IMAGE = "gui/images/";
	/***/
	public static final String PATH_TO_IMAGES_CHARACTERS = "images/characters/";
	public static final String PATH_TO_IMAGES_BACKGROUNDS = "images/backgrounds/";
	
	public static void setConfiguration() {
	}
	
}
