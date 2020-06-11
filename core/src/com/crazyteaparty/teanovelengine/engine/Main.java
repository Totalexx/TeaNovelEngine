package com.crazyteaparty.teanovelengine.engine;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.crazyteaparty.teanovelengine.engine.input.Input;
import com.crazyteaparty.teanovelengine.engine.screen.GameScreen;

public class Main extends Game {

	private GameScreen gameScreen;
	private Rectangle viewport;
	
	@Override
	public void create () {
		gameScreen = new GameScreen();
		Config.setConfiguration();
		super.setScreen(gameScreen);
	
		Gdx.input.setInputProcessor(new Input(gameScreen));
	}
	
	@Override
	public void render() {
		//Gdx.gl.glViewport((int) viewport.x, (int) viewport.y, (int) viewport.width, (int) viewport.height);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		GameManager.camera.update();
		
		super.render();
	}
	
	@Override
	public void resize (int width, int height) {
		float currentAspectRatio = (float) width / (float) height;
		float currentScale = 1f;
		float windowWidth;
		float windowHeight;
		float aspectRatio;
		
		Vector2 cropScreen = new Vector2(0f, 0f);
		if(Gdx.graphics.isFullscreen()) {
			windowWidth = Config.MONITOR_WIDTH;
			windowHeight = Config.MONITOR_HEIGHT;
			aspectRatio = Config.MONITOR_ASPECT_RATIO;
		} else {
			windowWidth = Config.WINDOW_WIDTH;
			windowHeight = Config.WINDOW_HEIGHT;
			aspectRatio = Config.ASPECT_RATIO;	
		}
		if (currentAspectRatio > aspectRatio) {
			currentScale = (float) height / windowHeight;
			cropScreen.x = (width - windowWidth * currentScale) / 2f;
		} else if (currentAspectRatio < aspectRatio) {
			currentScale = (float) width / windowWidth;
			cropScreen.y = (height - windowHeight * currentScale) / 2f;
		} else {
			currentScale = (float) (width / windowWidth);
		}
		
		float vievportWidth =  windowWidth * currentScale;
		float vievportHeight = windowHeight * currentScale;
		viewport = new Rectangle(cropScreen.x, cropScreen.y, vievportWidth, vievportHeight);
		
		super.resize(width, height);
	}
	
	@Override
	public void dispose () {
		GameManager.dispose();
		super.dispose();
	}
	
}
