package com.crazyteaparty.teanovellaengine.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;
import com.crazyteaparty.teanovellaengine.Main;
import com.crazyteaparty.teanovellaengine.model.images.NovelBackground;
import com.crazyteaparty.teanovellaengine.model.images.NovelGUI;
import com.crazyteaparty.teanovellaengine.model.text.NovelTextbox;

public class GameScreen implements Screen{
	
	Texture backgroundTexture;
	Texture backgroundTexture2;
	Texture backgroundTexture3;
	Texture backgroundTexture4;
	Texture textureNovelGUI;
	 
	NovelBackground novelBackground;
	NovelGUI novelGUI;
	
	NovelTextbox novelTextbox;
	
	@Override
	public void show() {
		
		backgroundTexture = new Texture(Gdx.files.internal("images/backgrounds/background.jpg"));
		backgroundTexture2 = new Texture(Gdx.files.internal("images/backgrounds/background2.jpg"));
		backgroundTexture3 = new Texture(Gdx.files.internal("images/backgrounds/background3.jpg"));
		backgroundTexture4 = new Texture(Gdx.files.internal("images/backgrounds/background4.jpg"));
		textureNovelGUI = new Texture(Gdx.files.internal("gui/images/novelGUI.png"));
		
		novelBackground = new NovelBackground(backgroundTexture);
		novelGUI = new NovelGUI(textureNovelGUI, -500f, -500f, 1000f, 300f);
		
		novelTextbox = new NovelTextbox(16);
		novelTextbox.setShadow(Color.BLACK, 1, 1);
		novelTextbox.initializeTextBox("Roboto-Regular.ttf", -450f, -450f, 450f, -250f, Color.WHITE);
		novelTextbox.setText("Если оно заработает с первого раза, я охуею.");
	}

	int i = 0;
	@Override
	public void render(float delta) {
		
		Main.batch.begin();
		novelBackground.draw(Main.batch);
		novelGUI.draw(Main.batch);
		novelTextbox.draw(Main.batch, 1f);
		Main.batch.end();
		
		if(Gdx.input.justTouched()){
			i++;
		}
		switch(i){
			case 1:
				novelBackground.setTexture(backgroundTexture2);
				novelTextbox.setText("Я охуел.");
				break;
			case 2:
				novelBackground.setTexture(backgroundTexture3);
				//label.setText("Она собрала всю свою храбрость и сказала");
				break;
			case 3:
				novelBackground.setTexture(backgroundTexture4);
				//label.setText("Огурцы!!!!!");
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
