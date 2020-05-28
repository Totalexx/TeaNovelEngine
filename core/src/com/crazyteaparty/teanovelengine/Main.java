package com.crazyteaparty.teanovelengine;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.crazyteaparty.teanovelengine.model.file.NovelAssets;
import com.crazyteaparty.teanovelengine.view.screen.GameScreen;


public class Main extends Game {

	public static GameScreen mainScreen;
	
	public static OrthographicCamera camera;
	private static Rectangle viewport;
	
	public static NovelAssets assetManager;
	public static SpriteBatch batch;
	
	@Override
	public void create () {
		NovelConfig.setConfiguration();
		
		assetManager = new NovelAssets();
		camera = new OrthographicCamera(NovelConfig.CAMERA_WIDTH, NovelConfig.CAMERA_HEIGHT);
		batch = new SpriteBatch();
		
		mainScreen = new GameScreen();
		super.setScreen(mainScreen);
	}
	
	public void render() {
		Gdx.gl.glViewport((int) viewport.x, (int) viewport.y, (int) viewport.width, (int) viewport.height);
		//Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		
		super.render();
	}
	
	@Override
	public void resize (int width, int height) {
		float currentAspectRatio = (float) width / height;
		float currentScale = 1f;
		Vector2 cropScreen = new Vector2(0f, 0f);
		
		if(currentAspectRatio > NovelConfig.ASPECT_RATIO){
		
			currentScale = (float)height / (float)NovelConfig.WINDOW_HEIGHT;
			cropScreen.x = (width - NovelConfig.WINDOW_WIDTH * currentScale) / 2f;
		
		}else if(currentAspectRatio < NovelConfig.ASPECT_RATIO) {
		
			currentScale = (float) width / (float) NovelConfig.WINDOW_WIDTH ;
			cropScreen.y = (height - NovelConfig.WINDOW_HEIGHT * currentScale) / 2f;
		
		} else {
		
			currentScale = (float) (width / NovelConfig.WINDOW_WIDTH);
		
		}
		
		float vievportWidth = (float) NovelConfig.WINDOW_WIDTH * currentScale;
		float vievportHeight = (float) NovelConfig.WINDOW_HEIGHT * currentScale;
		viewport = new Rectangle(cropScreen.x, cropScreen.y, vievportWidth, vievportHeight);
		
		super.resize(width, height);
	}
	
	@Override
	public void dispose () {
		assetManager.dispose();
		batch.dispose();
		super.dispose();
	}
	
}
