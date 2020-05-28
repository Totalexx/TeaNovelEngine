package com.crazyteaparty.teanovelengine.engine.view.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.crazyteaparty.teanovelengine.engine.Main;
import com.crazyteaparty.teanovelengine.engine.model.file.NovelAssets;
import com.crazyteaparty.teanovelengine.engine.model.sprite.NovelBackground;
import com.crazyteaparty.teanovelengine.engine.model.sprite.NovelCharacter;
import com.crazyteaparty.teanovelengine.engine.model.sprite.NovelGUI;
import com.crazyteaparty.teanovelengine.engine.model.text.NovelTextbox;

public class GameScreen implements Screen{
	 
	NovelBackground novelBackground;
	NovelGUI novelGUI;
	
	NovelCharacter kagome;
	
	NovelTextbox novelTextbox;
	NovelTextbox name;
	
	@Override
	public void show() {
		NovelAssets.loadBackground("background.jpg");
		NovelAssets.loadBackground("background2.jpg");
		NovelAssets.loadBackground("background3.jpg");
		NovelAssets.loadBackground("background4.jpg");
		NovelAssets.loadCharacter("kagome.png");
		NovelAssets.loadGUITexture("novelGUI.png");
		NovelAssets.waitLoadAsset();
		
		novelBackground = new NovelBackground("background.jpg");
		novelGUI = new NovelGUI("novelGUI.png", -500f, -500f, 1000f, 300f);
		
		novelTextbox = new NovelTextbox(16);
		novelTextbox.initializeTextBox(-450f, -450f, 450f, -280f, Color.WHITE);
		novelTextbox.setText("В 2016 году из-за крупного взлома банковских систем, правительство организовывает Федеральное бюро по киберпреступности, для борьбы с хакерами. ФБК имеет отдел по вычислению местоположения хакеров, отдел по задержанию, отдел допросов и отдел по предотвращению взломов и атак.");
	
		name = new NovelTextbox(18);
		name.initializeTextBox(-450f, -250f, 450f, -220f, Color.CYAN);
		name.setText("Кагоме");
		
		kagome = new NovelCharacter("kagome.png", 0f, -250f);
		kagome.setScale(1.2f);
		
	}

	int i = 0;
	@Override
	public void render(float delta) {
		
		Main.batch.begin();
		novelBackground.draw(Main.batch);
		kagome.draw(Main.batch);
		novelGUI.draw(Main.batch);
		name.draw(Main.batch, 1f);
		novelTextbox.newdrawSmooth(Main.batch, 2, 1f);
		Main.batch.end();
		
		if(Gdx.input.justTouched()){
			i++;
			novelTextbox.isFinishedScene = false;
			novelTextbox.isStartedSmoothDraw = false;
				switch(i){
				case 1:
					novelTextbox.setText("Шёл 2035-ый год. Благодаря исследованиям в области нейробиологии, компания “CyberVR(название временное)” разработала технологию полного погружения в виртуальную реальность. Специальный нейрошлем, способный погружать человека в осознанный сон. Благодаря этому состоянию сна, пользователь может в полной мере ощущать присутствие в VR.");
					kagome.setFlipX(true);
					break;
				case 2:
					novelTextbox.setText("А теперь наклоны");
					kagome.setRotation(20f);
					break;
				case 3:
					novelTextbox.setText("Огурцы!!!!!");
					break;
			}
		}
		switch(i){
			case 0:
				novelBackground.setTexture("background.jpg");
				break;
			case 1:
				novelBackground.setTexture("background2.jpg");
				break;
			case 2:
				novelBackground.setTexture("background3.jpg");
				break;
			case 3:
				novelBackground.setTexture("background4.jpg");
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

