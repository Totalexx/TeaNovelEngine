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

/**
 * Generates the textbox for drawing text in screen
 * 
 * @version 1.0
 * 
 * @author Vitaliy
 *
 */
public class TextboxLast extends Actor{
	
	/** List of characters. */
	protected String FONT_CHARS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮ"
			+ "ЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>\u2007";
	/** Parameters for generation font. */
	private FreeTypeFontParameter parameters;
	/** Font for generation LabelStyle. */
	private BitmapFont font;
	/** Label for drawing text. */
	private Label label;
	/** Draw text char by char*/
	private boolean charByChar = false;
	/** pause in drawing*/
	private boolean pauseDraw = false;
    /** End of draw*/
	private boolean endDraw = false;
	
	private boolean skipCharByChar = false;
	
	private String currentText;
	
	private float currentSpeedDraw = 1f;
	
	private float saveSpeedDraw;
	
	private int iterationDraw = 0;
	
	/**
	 * Used to drawing text
	 * After use initializeText() to generate a textbox
	 * 
	 * @param fontSize
	 */
	public TextboxLast(int fontSize) {
		parameters = new FreeTypeFontParameter();
		parameters.characters = FONT_CHARS;
		parameters.size = fontSize;
		parameters.magFilter = TextureFilter.Linear;
		parameters.minFilter = TextureFilter.Linear;
		parameters.genMipMaps = true;
	}
	
	/**
	 * Generates a font for create a LabelStyle
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
	 * @return Label
	 */
	private Label generateLabel(CharSequence text, Color color) {
		label = new Label(text, new LabelStyle(font, color));
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
	public Label initializeTextBox(String fontPathFile, float x1, float y1, float x2, float y2, Color color){
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
	public Label initializeTextBox(float x1, float y1, float x2, float y2, Color color){
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
	 * @return Label
	 */
	public Label initializeTextBox(String fontPathFile, float scaleX, float scaleY, float lineHeight, float x1, 
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
	 * @return Label
	 */
	public Label initializeTextBox (String fontPathFile, CharSequence text, float scaleX, float scaleY, float lineHeight, float x1, 
			float y1, float x2, float y2, Color color) {
		generateFont(fontPathFile);
		font.getData().scaleY = scaleX;
		font.getData().scaleY = scaleY;
		font.getData().setLineHeight(lineHeight);
		generateLabel(text, color);
		setTextBox(x1, y1, x2, y2);
		setWrap(true);
		currentText = text.toString();
		return label;
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
		float indexChar;
		int lengthText = currentText.length();
		try {
			indexChar = iterationDraw / currentSpeedDraw;
		} catch (Exception e) {
			indexChar = iterationDraw;
		}
		if(lengthText == (int) indexChar) {
			endDraw = true;
			if(skipCharByChar) {
				currentSpeedDraw = saveSpeedDraw;
			}
		}
		if(charByChar && !(endDraw || pauseDraw)) {
			if(indexChar == (int) indexChar) {
				label.setText(currentText.substring(0, (int) (indexChar + 1)) 
						+ currentText.substring((int) (indexChar + 1), lengthText).replaceAll("\\S", "\u2007"));
				char currentChar = currentText.charAt((int) indexChar);
				if(currentChar == '.' || currentChar == '!' || currentChar == '?') {
					pauseDraw = true;
				}
			}
			if(skipCharByChar) {
				label.setText(currentText);
				endDraw = true;
			}
			iterationDraw++;
		} else {
			if(!(endDraw || pauseDraw)) {
				label.setText(currentText);
			}
		}
		label.draw(batch, parentAlpha);
	}
	
	public void setSpeedDraw(float speedDraw) {
		this.currentSpeedDraw = speedDraw;
		saveSpeedDraw = speedDraw;
	}
	
	public void setCharbyChar(boolean charByChar) {
		this.charByChar = charByChar;
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
	
	/**
	 * Sets the text
	 * 
	 * @param text
	 */
	public void setText(CharSequence text) {
		currentText = text.toString();
		endDraw = false;
		pauseDraw = false;
		skipCharByChar = false;
		iterationDraw = 0;
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
		parameters.shadowColor = Color.BLACK;
		parameters.shadowOffsetX = 1;
		parameters.shadowOffsetY = 1;
	}
	
	public void setPauseDraw(boolean pauseDraw) {
		this.pauseDraw = pauseDraw;
	}
	
	public void setEndDraw(boolean endDraw) {
		this.endDraw = endDraw;
	}
	
	public void setSkipCharByChar(boolean skipCharByChar) {
		this.skipCharByChar = skipCharByChar;
	}
	
	public boolean isSkipCharByChar() {
		return skipCharByChar;
	}
	
	public boolean isPauseDraw() {
		return pauseDraw;
	}
	
	public boolean isEndDraw() {
		return endDraw;
	}
	
	/**
	 * Returns font
	 * 
	 * @return Label
	 */
	public BitmapFont getFont(){
		return font;
	}
	
	/**
	 * Returns label
	 * 
	 * @return Label
	 */
	public Label getLabel(){
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
