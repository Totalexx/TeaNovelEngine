package com.crazyteaparty.teanovelengine.engine.text;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.DistanceFieldFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.Align;
import com.crazyteaparty.teanovelengine.engine.GameManager;
import com.crazyteaparty.teanovelengine.engine.utils.ConvertSize;
import com.crazyteaparty.teanovelengine.game.Config;
import com.rafaskoberg.gdx.typinglabel.TypingLabel;

/**
 * Generates the textbox for drawing text in screen
 * 
 * @version 1.0
 * 
 * @author Vitaliy Popov
 *
 */
public  class Textbox extends Actor{
	
	/** Font for generation TypingLabelStyle. */
	private DistanceFieldFont font;
	/** TypingLabel for drawing text. */
	private TypingLabel label;
	
	public Textbox (String fontPathFile, CharSequence text, float fontSize, float x1, float y1, float x2, float y2, Color color) {
		generateFont(fontPathFile, fontSize);
		generateTypingLabel(text, color);
		setTextBox(x1, y1, x2, y2);
		setWrap(true);
		label.setFontScale(fontSize);
	}
	
	public Textbox (CharSequence text, float fontSize, float x1, float y1, float x2, float y2, Color color) {
		this(Config.DEFAULT_FONT_NAME, text, fontSize, x1, y1, x2, y2, color);
	}
	
	public Textbox (float fontSize, float x1, float y1, float x2, float y2, Color color) {
		this(Config.DEFAULT_FONT_NAME, "", fontSize, x1, y1, x2, y2, color);
	}
	
	/**
	 * Create a font for create a LabelStyle
	 * 
	 * @param fontPathFile
	 */
	private void generateFont(String fontPathFile, float fontSize) {
		GameManager.assets.loadFont(Config.PATH_TO_FONT + fontPathFile + ".fnt");
		GameManager.assets.finishLoading();
		font = GameManager.assets.getFont(Config.PATH_TO_FONT + fontPathFile + ".fnt");
		font.setDistanceFieldSmoothing(2.5f);
		//font.getData().setScale(fontSize);
		//System.out.println(font.getScaleX());
	}
	
	/**
	 * Generates a label
	 * 
	 * @param text
	 * @param color
	 * @return TypingLabel
	 */
	private TypingLabel generateTypingLabel(CharSequence text, Color color) {
		LabelStyle labelStyle = new LabelStyle(font, Color.WHITE);
		label = new TypingLabel(text, labelStyle);
		return label;
	}
	
	@Override
	public void act(float delta) {
		label.act(delta);
		super.act(delta);
	}
	
	/**
	 * Draws the text
	 * 
	 * @param batch
	 * @param parentAlpha
	 * @return 
	 */
	@Override
	public void draw (Batch batch, float parentAlpha) {
		label.draw(batch, parentAlpha);
	}
	
	public void setBorder () {
		
	}
	
	public void setSpeedDraw(float speedDraw) {
		
	}
	
	public void setCharbyChar(boolean charByChar) {
		label.setDrawCharByChar(charByChar);
	}
	
	/**
	 * Sets a visible for textbox
	 * 
	 * @param visible
	 */
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		label.setVisible(visible);
	}
	
	/**
	 * Sets the textbox size and alignment for text
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param alignment
	 */
	public void setTextBox(float x1, float y1, float x2, float y2, int alignment) {
		x1 = ConvertSize.virtualXToReal(x1);
		y1 = ConvertSize.virtualYToReal(y1);
		x2 = ConvertSize.virtualXToReal(x2);
		y2 = ConvertSize.virtualYToReal(y2);
		super.setBounds(x1, y1, x2 - x1, y2 - y1);
		label.setPosition(x1, y1);
		label.setSize(x2 - x1, y2 - y1);
		label.setAlignment(alignment);
	}
	
	/**
	 * Sets the textbox size and top left alignment for text
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void setTextBox(float x1, float y1, float x2, float y2) {
		setTextBox(x1, y1, x2, y2, Align.topLeft);
	}
	
	/**
	 * Sets alignment for textbox
	 * 
	 * @param alignment
	 */
	public void setAlignment(int alignment) {
		label.setAlignment(alignment);
	}
	
	/**
	 * Sets wrap for textbox
	 * 
	 * @param wrap
	 */
	public void setWrap(boolean wrap) {
		label.setWrap(wrap);
	}
	
	/**
	 * Sets color for text
	 * 
	 * @param color
	 */
	@Override
	public void setColor(Color color) {
		label.setColor(color);
	}
	
	/**
	 * Sets the scale for text
	 * 
	 * @param scale
	 */
	@Override
	public void setScale(float scale) {
		super.setScale(scale);
		label.setScale(scale);
	}
	
	public void skip() {
		label.skipToTheEnd(false, false);
	}
	
	public void setPause(boolean pause) {
		label.setPaused(pause);
	}
	
	/**
	 * Sets the text
	 * 
	 * @param text
	 */
	public void setText(CharSequence text) {
		label.restart(text);
	}
	
	public void setDrawCharByChar(boolean drawCharByChar) {
		label.setDrawCharByChar(drawCharByChar);
	}
	
	public boolean isDrawCharByChar() {
		return label.isDrawCharByChar();
	}
	
	public boolean hasEnded() {
		return label.hasEnded();
	}
	
	public boolean isPaused() {
		return label.isPaused();
	}
	
	/**
	 * Returns font
	 * 
	 * @return TypingLabel
	 */
	public DistanceFieldFont getFont(){
		return font;
	}
	
	/**
	 * Returns label
	 * 
	 * @return TypingLabel
	 */
	public TypingLabel getTypingLabel(){
		return label;
	}
	
}
