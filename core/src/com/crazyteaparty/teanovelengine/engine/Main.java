package com.crazyteaparty.teanovelengine.engine;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.crazyteaparty.teanovelengine.engine.input.Input;
import com.crazyteaparty.teanovelengine.engine.screen.GameScreen;
import com.crazyteaparty.teanovelengine.game.Config;

public class Main extends Game {

	private GameScreen gameScreen;
	@Override
	public void create () {
		Config.setConfiguration();
		GameManager.init();
		gameScreen = new GameScreen();
		super.setScreen(gameScreen);
		Gdx.input.setInputProcessor(new Input(gameScreen));
	}
	
	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		GameManager.camera.update();
		super.render();
	}
	
	@Override
	public void resize (int width, int height) {
		GameManager.resize(width, height);
		GameManager.viewport.update(width, height);
		super.resize(width, height);
	}
	
	@Override
	public void dispose () {
		GameManager.dispose();
		super.dispose();
	}
	
}
