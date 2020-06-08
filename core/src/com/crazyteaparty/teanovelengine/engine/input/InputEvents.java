package com.crazyteaparty.teanovelengine.engine.input;

import com.crazyteaparty.teanovelengine.engine.screen.GameScreen;

public abstract class InputEvents {

	public static void textSceneEvent(GameScreen screen) {
		if(screen.textbox.isEndDraw()) {
			screen.i++;
		} else {
			if(screen.textbox.isPauseDraw()) {
				screen.textbox.setPauseDraw(false);
			} else {
				screen.textbox.setSkipCharByChar(true);
			}
		}
	}
	
}
