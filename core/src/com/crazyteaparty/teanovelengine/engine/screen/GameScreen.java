package com.crazyteaparty.teanovelengine.engine.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.crazyteaparty.teanovelengine.engine.Main;
import com.crazyteaparty.teanovelengine.engine.file.Assets;
import com.crazyteaparty.teanovelengine.engine.sprite.Background;
import com.crazyteaparty.teanovelengine.engine.sprite.Character;
import com.crazyteaparty.teanovelengine.engine.sprite.GUI;
import com.crazyteaparty.teanovelengine.engine.text.Textbox;

public class GameScreen implements Screen{
	 
	Background background;
	GUI gUI;
	
	Character kagome;
	
	Textbox textbox;
	Textbox name;
	
	@Override
	public void show() {
		Assets.loadBackground("background.jpg");
		Assets.loadBackground("background2.jpg");
		Assets.loadBackground("background3.jpg");
		Assets.loadBackground("background4.jpg");
		Assets.loadCharacter("kagome.png");
		Assets.loadGUITexture("gUI.png");
		Assets.waitLoadAsset();
		
		background = new Background("background.jpg");
		gUI = new GUI("gUI.png", -500f, -500f, 1000f, 300f);
		
		textbox = new Textbox(16);
		textbox.initializeTextBox(-450f, -450f, 450f, -280f, Color.WHITE);
		textbox.setText("В 2016 году из-за крупного взлома банковских систем, правительство организовывает Федеральное бюро по киберпреступности, для борьбы с хакерами. ФБК имеет отдел по вычислению местоположения хакеров, отдел по задержанию, отдел допросов и отдел по предотвращению взломов и атак.");
	
		name = new Textbox(18);
		name.initializeTextBox(-450f, -250f, 450f, -220f, Color.CYAN);
		name.setText("Кагоме");
		
		kagome = new Character("kagome.png", 0f, -250f);
		kagome.setScale(1.2f);
		
	}

	int i = 0;
	@Override
	public void render(float delta) {
		
		Main.batch.begin();
		background.draw(Main.batch);
		kagome.draw(Main.batch);
		gUI.draw(Main.batch);
		name.draw(Main.batch, 1f);
		textbox.newdrawSmooth(Main.batch, 2, 1f);
		Main.batch.end();
		
		if(Gdx.input.justTouched()){
			i++;
			textbox.isFinishedScene = false;
			textbox.isStartedSmoothDraw = false;
				switch(i){
				case 1:
					textbox.setText("Шёл 2035-ый год. Благодаря исследованиям в области нейробиологии, компания “CyberVR(название временное)” разработала технологию полного погружения в виртуальную реальность. Специальный нейрошлем, способный погружать человека в осознанный сон. Благодаря этому состоянию сна, пользователь может в полной мере ощущать присутствие в VR.");
					kagome.setFlipX(true);
					break;
				case 2:
					textbox.setText("А теперь наклоны");
					kagome.setRotation(20f);
					break;
				case 3:
					textbox.setText("Огурцы!!!!!");
					break;
			}
		}
		switch(i){
			case 0:
				background.setTexture("background.jpg");
				break;
			case 1:
				background.setTexture("background2.jpg");
				break;
			case 2:
				background.setTexture("background3.jpg");
				break;
			case 3:
				background.setTexture("background4.jpg");
				break;
		}
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
		
	}

	@Override
	public void dispose() {

	}

}

