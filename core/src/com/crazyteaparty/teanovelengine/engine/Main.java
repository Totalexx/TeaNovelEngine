package com.crazyteaparty.teanovelengine.engine;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.crazyteaparty.teanovelengine.engine.screen.GameScreen;

public class Main extends Game {

	private static Rectangle viewport;
	private GameScreen mainScreen;
	
	@Override
	public void create () {
		Config.setConfiguration();
		mainScreen = new GameScreen();
		super.setScreen(mainScreen);
	}
	
	@Override
	public void render() {
		Gdx.gl.glViewport((int) viewport.x, (int) viewport.y, (int) viewport.width, (int) viewport.height);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		GameManager.camera.update();
		
		super.render();
	}
	
	@Override
	public void resize (int width, int height) {
		float currentAspectRatio = (float) width / (float) height;
		float currentScale = 1f;
		Vector2 cropScreen = new Vector2(0f, 0f);
		
		if (currentAspectRatio > Config.ASPECT_RATIO) {
			currentScale = (float) height / (float) Config.WINDOW_HEIGHT;
			cropScreen.x = (width - Config.WINDOW_WIDTH * currentScale) / 2f;
		} else if (currentAspectRatio < Config.ASPECT_RATIO) {
			currentScale = (float) width / (float) Config.WINDOW_WIDTH ;
			cropScreen.y = (height - Config.WINDOW_HEIGHT * currentScale) / 2f;
		} else {
			currentScale = (float) (width / Config.WINDOW_WIDTH);
		}
		
		float vievportWidth = (float) Config.WINDOW_WIDTH * currentScale;
		float vievportHeight = (float) Config.WINDOW_HEIGHT * currentScale;
		viewport = new Rectangle(cropScreen.x, cropScreen.y, vievportWidth, vievportHeight);
		
		super.resize(width, height);
	}
	
	@Override
	public void dispose () {
		GameManager.dispose();
		super.dispose();
	}
	
}
