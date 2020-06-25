package com.crazyteaparty.teanovelengine.engine.screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.DistanceFieldFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.crazyteaparty.teanovelengine.engine.GameManager;
import com.crazyteaparty.teanovelengine.engine.audio.GameMusic;
import com.crazyteaparty.teanovelengine.engine.script.Interpreter;
import com.crazyteaparty.teanovelengine.engine.sprite.Background;
import com.crazyteaparty.teanovelengine.engine.sprite.Character;
import com.crazyteaparty.teanovelengine.engine.sprite.GUISprite;
import com.crazyteaparty.teanovelengine.engine.text.Textbox;
import com.crazyteaparty.teanovelengine.game.Config;

public class GameScreen implements Screen{
	 
	Background background;
	GUISprite gui;
	
	Character kagome;
	
	public Textbox textbox;
	Textbox name;
	
	Stage stage;
	
	Interpreter interpreter;
	
	GameMusic bl;
	
	@Override
	public void show() {
		GameManager.assets.loadBackground("background.jpg");
		GameManager.assets.loadBackground("background2.jpg");
		GameManager.assets.loadBackground("background3.jpg");
		GameManager.assets.loadBackground("background4.jpg");
		GameManager.assets.loadCharacter("kagome.png");
		GameManager.assets.loadGUITexture("novelGUI.png");
		GameManager.assets.finishLoading();
		
		bl = new GameMusic("EndlessSummer.mp3");
		bl.play(100);
		
		stage = new Stage(GameManager.viewport);
		
		background = new Background("background.jpg");
		gui = new GUISprite("novelGUI.png", 0, 0, 100, 30);
		
		textbox = new Textbox(0.7f, 5, 5, 95, 20, Color.WHITE);
		textbox.setCharbyChar(true);
		
		name = new Textbox(1f, 5, 22, 95, 26, Color.WHITE);
		
		kagome = new Character("kagome.png", 50, 30);
		
		stage.addActor(background);
		stage.addActor(kagome);
		stage.addActor(gui);
		stage.addActor(name);
		stage.addActor(textbox);
		stage.setDebugAll(Config.DEBUG);
		interpreter = new Interpreter(stage, textbox);
		stage.getBatch().setShader(DistanceFieldFont.createDistanceFieldShader());
	}

	public int i = 0;
	int lastI = -1;
	@Override
	public void render(float delta) {
		if(i != lastI){
			lastI = i;
			switch(i) {
				case 4:
					i = 0;
				case 0:
					name.setText("{COLOR=CYAN}Кагоме{SHAKE}");
					kagome.setRotation(0);
					interpreter.disassemble("say(\"{FADE}В 2016 году из-за крупного взлома банковских систем,"
							+ " правительство организовывает Федеральное бюро по киберпреступности,"
							+ " для борьбы с хакерами. ФБК имеет отдел по вычислению местоположения хакеров,"
							+ " отдел по задержанию, отдел допросов и отдел по предотвращению взломов и атак.\");");
					background.setTexture("background.jpg");
					break;
				case 1:
					name.setText("Николай");
					interpreter.disassemble("say(\"Шёл 2035-ый год. Благодаря исследованиям в области нейробиологии, компания"
							+ " “CyberVR(название временное)” разработала технологию полного погружения в виртуальную реальность."
							+ " Специальный нейрошлем, способный погружать человека в осознанный сон. "
							+ "Благодаря этому состоянию сна, пользователь может в полной мере ощущать присутствие в VR.\");");
					kagome.setFlipX(true);
					background.setTexture("background2.jpg");
					break;
				case 2:
					name.setText("Игорь");
					interpreter.disassemble("say(\"А теперь наклоны.\");");
					kagome.setRotation(20f);
					background.setTexture("background3.jpg");
					break;
				case 3:
					name.setText("{COLOR=YELLOW}Кагоме");
					kagome.setFlipX(false);
					kagome.setRotation(0f);
					interpreter.disassemble("say(\"{COLOR=YELLOW}{SHAKE}БЛИНЧИКИ!!!\");");
					background.setTexture("background4.jpg");
					break;
			}
			interpreter.MethodCall();
		}
		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height);
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

