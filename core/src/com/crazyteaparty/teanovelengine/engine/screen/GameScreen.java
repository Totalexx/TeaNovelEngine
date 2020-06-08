package com.crazyteaparty.teanovelengine.engine.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.crazyteaparty.teanovelengine.engine.Config;
import com.crazyteaparty.teanovelengine.engine.GameManager;
import com.crazyteaparty.teanovelengine.engine.file.Assets;
import com.crazyteaparty.teanovelengine.engine.sprite.Background;
import com.crazyteaparty.teanovelengine.engine.sprite.Character;
import com.crazyteaparty.teanovelengine.engine.sprite.GUI;
import com.crazyteaparty.teanovelengine.engine.text.Textbox;

public class GameScreen implements Screen{
	 
	Background background;
	GUI gui;
	
	Character kagome;
	
	public Textbox textbox;
	Textbox name;
	
	Stage stage;
		
	
	@Override
	public void show() {
		Assets.loadBackground("background.jpg");
		Assets.loadBackground("background2.jpg");
		Assets.loadBackground("background3.jpg");
		Assets.loadBackground("background4.jpg");
		Assets.loadCharacter("kagome.png");
		Assets.loadGUITexture("novelGUI.png");
		Assets.waitLoadAsset();
		
		stage = new Stage(new FitViewport(Config.CAMERA_WIDTH, Config.CAMERA_HEIGHT, GameManager.camera));
		
		background = new Background("background.jpg");
		gui = new GUI("novelGUI.png", 0, 0, 100, 30);
		
		textbox = new Textbox(18);
		textbox.initializeTextBox("arial.ttf", 5, 5, 95, 20, Color.WHITE);
		textbox.setCharbyChar(true);
		
		name = new Textbox(20);
		name.initializeTextBox(5, 22, 95, 26, Color.CYAN);
		name.setText("Кагоме");
		
		kagome = new Character("kagome.png", 50, 30);
		kagome.setScale(1);
		
		stage.addActor(background);
		//stage.addActor(kagome);
		stage.addActor(gui);
		stage.addActor(name);
		stage.addActor(textbox);
		stage.setDebugAll(Config.DEBUG);
		System.out.print('\u0000');
	}

	public static int i = 0;
	int lastI = -1;
	@Override
	public void render(float delta) {
		if(i != lastI){
			lastI = i;
			switch(i) {
				case 4:
					i = 0;
				case 0:
					kagome.setRotation(0);
					kagome.setFlipX(false);
					textbox.setText("В 2016 году из-за крупного взлома банковских систем, правительство организовывает Федеральное бюро по киберпреступности, для борьбы с хакерами. ФБК имеет отдел по вычислению местоположения хакеров, отдел по задержанию, отдел допросов и отдел по предотвращению взломов и атак.");
					background.setTexture("background.jpg");
					break;
				case 1:
					textbox.setText("Шёл 2035-ый год. Благодаря исследованиям в области нейробиологии, компания “CyberVR(название временное)” разработала технологию полного погружения в виртуальную реальность. Специальный нейрошлем, способный погружать человека в осознанный сон. Благодаря этому состоянию сна, пользователь может в полной мере ощущать присутствие в VR.");
					kagome.setFlipX(true);
					background.setTexture("background2.jpg");
					break;
				case 2:
					textbox.setText("А теперь наклоны.");
					kagome.setRotation(20f);
					background.setTexture("background3.jpg");
					break;
				case 3:
					textbox.setText("Огурцы!");
					background.setTexture("background4.jpg");
					break;
			}
		}
		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		stage.dispose();
	}

	@Override
	public void dispose() {

	}

}

