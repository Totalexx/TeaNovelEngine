package com.crazyteaparty.teanovelengine.engine.input;

import com.crazyteaparty.teanovelengine.engine.screen.GameScreen;

public abstract class InputEvents {

	public static void textSceneEvent(GameScreen screen) {
		if(screen.textbox.hasEnded()) {
			screen.i++;
		} else {
			if(screen.textbox.isPaused()) {
				screen.textbox.setPause(false);
			} else {
				screen.textbox.skip();
			}
		}
	}
	
}
