package com.crazyteaparty.teanovelengine.engine.text;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.Align;
import com.crazyteaparty.teanovelengine.engine.Config;
import com.crazyteaparty.teanovelengine.engine.utils.ConvertSize;
import com.rafaskoberg.gdx.typinglabel.TypingLabel;

/**
 * Generates the textbox for drawing text in screen
 * 
 * @version 1.0
 * 
 * @author Vitaliy
 *
 */
public class Textbox extends Actor{
	
	/** List of characters. */
	protected String FONT_CHARS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮ"
			+ "ЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>\u2007";
	/** Parameters for generation font. */
	private FreeTypeFontParameter parameters;
	/** Font for generation TypingLabelStyle. */
	private BitmapFont font;
	/** TypingLabel for drawing text. */
	private TypingLabel label;
	
	/**
	 * Used to drawing text
	 * After use initializeText() to generate a textbox
	 * 
	 * @param fontSize
	 */
	public Textbox(int fontSize) {
		parameters = new FreeTypeFontParameter();
		parameters.characters = FONT_CHARS;
		parameters.size = fontSize;
		parameters.magFilter = TextureFilter.Linear;
		parameters.minFilter = TextureFilter.Linear;
		parameters.genMipMaps = true;
	}
	
	/**
	 * Generates a font for create a TypingLabelStyle
	 * 
	 * @param fontPathFile
	 */
	private void generateFont(String fontPathFile) {
		FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal(Config.PATH_TO_FONT + fontPathFile));
		font = fontGenerator.generateFont(parameters);
		font.getData().markupEnabled = true;
		fontGenerator.dispose();
	}
	
	/**
	 * Generates a label
	 * 
	 * @param text
	 * @param color
	 * @return TypingLabel
	 */
	private TypingLabel generateTypingLabel(CharSequence text, Color color) {
		label = new TypingLabel(text, new LabelStyle(font, color));
		return label;
	}
	
	/**
	 * Generates the textbox for draw.
	 * 
	 * @param fontPathFile
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param color
	 * @return
	 */
	public TypingLabel initializeTextBox(String fontPathFile, float x1, float y1, float x2, float y2, Color color){
		return initializeTextBox(fontPathFile, 1f, 1f, 20f, x1, y1, x2, y2, color);
	}
	
	/**
	 * Generates the textbox for draw.
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param color
	 * @return
	 */
	public TypingLabel initializeTextBox(float x1, float y1, float x2, float y2, Color color){
		return initializeTextBox(Config.DEFAULT_FONT_PATH, x1, y1, x2, y2, color);
	}
	
	/**
	 * Generates the textbox for draw.
	 * 
	 * @param fontPathFile
	 * @param scaleX
	 * @param scaleY
	 * @param lineHeight
	 * @param color
	 * @return TypingLabel
	 */
	public TypingLabel initializeTextBox(String fontPathFile, float scaleX, float scaleY, float lineHeight, float x1, 
			float y1, float x2, float y2, Color color){
		return initializeTextBox(fontPathFile, "", scaleX, scaleY, lineHeight, x1, y1, x2, y2, color);
	}
	
	/**
	 * Generates the textbox for draw.
	 * 
	 * @param fontPathFile
	 * @param text
	 * @param scaleX
	 * @param scaleY
	 * @param lineHeight
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param color
	 * @return TypingLabel
	 */
	public TypingLabel initializeTextBox (String fontPathFile, CharSequence text, float scaleX, float scaleY, float lineHeight, float x1, 
			float y1, float x2, float y2, Color color) {
		generateFont(fontPathFile);
		font.getData().scaleY = scaleX;
		font.getData().scaleY = scaleY;
		font.getData().setLineHeight(lineHeight);
		generateTypingLabel(text, color);
		setTextBox(x1, y1, x2, y2);
		setWrap(true);
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
	
	/**
	 * Sets the shadow for text
	 * 
	 * @param shadowColor
	 * @param shadowOffsetX
	 * @param shadowOffsetY
	 */
	public void setShadow(Color shadowColor, int shadowOffsetX, int shadowOffsetY){
		parameters.shadowColor = shadowColor;
		parameters.shadowOffsetX = shadowOffsetX;
		parameters.shadowOffsetY = shadowOffsetY;
	}
	
	/**
	 * Sets the shadow for text
	 * 
	 */
	public void setShadow(){
		setShadow(Color.BLACK, 1, 1);
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
	public BitmapFont getFont(){
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
	
	/** Returns FreeTypeFontParameter to generate a font. 
	 *  Use before calling initializeText()
	 * 
	 * @return FreeTypeFontParameter
	 */
	public FreeTypeFontParameter getFontParameters(){
		return parameters;
	}
}
