package com.crazyteaparty.teanovellaengine.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.crazyteaparty.teanovellaengine.Main;
import com.crazyteaparty.teanovellaengine.model.sprite.NovelBackground;
import com.crazyteaparty.teanovellaengine.model.sprite.NovelCharacter;
import com.crazyteaparty.teanovellaengine.model.sprite.NovelGUI;
import com.crazyteaparty.teanovellaengine.model.text.NovelTextbox;

public class GameScreen implements Screen{
	
	Texture backgroundTexture;
	Texture backgroundTexture2;
	Texture backgroundTexture3;
	Texture backgroundTexture4;
	Texture textureNovelGUI;
	Texture kagomeTexture;
	 
	NovelBackground novelBackground;
	NovelGUI novelGUI;
	
	NovelCharacter kagome;
	
	NovelTextbox novelTextbox;
	NovelTextbox name;
	
	@Override
	public void show() {
		
		kagomeTexture = new Texture(Gdx.files.internal("images/characters/kagome.png"));
		
		backgroundTexture = new Texture(Gdx.files.internal("images/backgrounds/background.jpg"));
		backgroundTexture2 = new Texture(Gdx.files.internal("images/backgrounds/background2.jpg"));
		backgroundTexture3 = new Texture(Gdx.files.internal("images/backgrounds/background3.jpg"));
		backgroundTexture4 = new Texture(Gdx.files.internal("images/backgrounds/background4.jpg"));
		textureNovelGUI = new Texture(Gdx.files.internal("gui/images/novelGUI.png"));
		
		novelBackground = new NovelBackground(backgroundTexture);
		novelGUI = new NovelGUI(textureNovelGUI, -500f, -500f, 1000f, 300f);
		
		novelTextbox = new NovelTextbox(16);
		//novelTextbox.setShadow();
		novelTextbox.initializeTextBox(-450f, -450f, 450f, -280f, Color.WHITE);
		novelTextbox.setText("Туда");
	
		name = new NovelTextbox(18);
		//name.setShadow(Color.WHITE, 1, 1);
		name.initializeTextBox(-450f, -250f, 450f, -220f, Color.CYAN);
		name.setText("Кагоме");
		
		kagome = new NovelCharacter(kagomeTexture, 0f, -250f);
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
		novelTextbox.draw(Main.batch, 1f);
		Main.batch.end();
		
		if(Gdx.input.justTouched()){
			i++;
		}
		switch(i){
			case 1:
				novelBackground.setTexture(backgroundTexture2);
				novelTextbox.setText("Сюда");
				kagome.setFlipX(true);
				break;
			case 2:
				novelBackground.setTexture(backgroundTexture3);
				novelTextbox.setText("А теперь наклоны");
				kagome.setRotation(20f);
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

