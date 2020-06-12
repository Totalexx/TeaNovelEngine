package com.crazyteaparty.teanovelengine.engine.input;

import com.badlogic.gdx.InputProcessor;
import com.crazyteaparty.teanovelengine.engine.screen.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.crazyteaparty.teanovelengine.engine.input.InputEvents;

public class Input implements InputProcessor{

	GameScreen screen;
	
	public Input(GameScreen screen) {
		this.screen = screen;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
			case Keys.SPACE:
				InputEvents.textSceneEvent(screen);
				break;
			default:
				break;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		switch (button) {
			case Buttons.LEFT:
				InputEvents.textSceneEvent(screen);
				break;	
			default:
				break;
		}
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

}
