package com.crazyteaparty.teanovelengine.engine;

public abstract class Config {

	/** Titel novel*/
	public static final String NOVEL_TITLE = "TeaNovelEngine";
	public static final boolean FULLSCREEN = false;
	public static final int WINDOW_WIDTH = 1066;
	public static final int WINDOW_HEIGHT = 600;
	public static final float ASPECT_RATIO = (float) WINDOW_WIDTH / (float) WINDOW_HEIGHT;
	
	public static final float CAMERA_WIDTH = 1000f;
	public static final float CAMERA_HEIGHT = 1000f;
	
	public static final int FPS = 60;
	
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
