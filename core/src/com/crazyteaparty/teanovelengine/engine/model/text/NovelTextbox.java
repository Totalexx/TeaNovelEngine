package com.crazyteaparty.teanovelengine.engine.model.text;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.Align;
import com.crazyteaparty.teanovelengine.engine.NovelConfig;

/**
 * Generates the textbox for drawing text in screen
 * 
 * @version 1.0
 * 
 * @author Vitaliy
 *
 */
public class NovelTextbox {
	
	/** List of characters. */
	private final String FONT_CHARS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮ"
			+ "ЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";
	
	/** Parameters for generation font. */
	private FreeTypeFontParameter parameters;
	/** Font for generation LabelStyle. */
	private BitmapFont font;
	/** Label for drawing text. */
	private Label label;
	
	/**
	 * Used to drawing text
	 * After use initializeText() to generate a textbox
	 * 
	 * @param fontSize
	 */
	public NovelTextbox(int fontSize) {
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
		FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal(NovelConfig.PATH_TO_FONT + fontPathFile));
		fontGenerator.scaleForPixelHeight(parameters.size);
		font = fontGenerator.generateFont(parameters);
		fontGenerator.dispose();
	}
	
	/**
	 * Generates a label
	 * 
	 * @param text
	 * @param color
	 * @return Label
	 */
	private Label generateLabel(CharSequence text,Color color) {	
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
		return initializeTextBox(fontPathFile, 1f, 2f, 20f, x1, y1, x2, y2, color);
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
		return initializeTextBox(NovelConfig.DEFAULT_FONT_PATH, 1f, 2f, 20f, x1, y1, x2, y2, color);
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
		return label;
	}
	
	public int iteration = 0;
	public boolean isStartedSmoothDraw = false;
	public boolean isFinishedScene = false;
	public String textToDraw;
	public String[] words;
	/**
	 * draw the text character by character
	 * 
	 * @param batch
	 * @param speedDraw
	 * @param parentAlpha
	 */
	public void drawSmooth (SpriteBatch batch, int speedDraw, float parentAlpha) {
		if (isStartedSmoothDraw) {
			float endChar = (float)iteration / (float)speedDraw;
			if(textToDraw.length() == endChar){
				isStartedSmoothDraw = false;
				isFinishedScene = true;
			}else{
				if(endChar == (int)endChar){
					label.setText(textToDraw.substring(0, (int)endChar + 1));
				}
				iteration++;
			}
			draw(batch, parentAlpha);
		} else {
			if (isFinishedScene) {
				draw(batch, parentAlpha);
			} else {
				iteration = 0;
				textToDraw = label.getText().toString();
				isStartedSmoothDraw = true;
			}
		}
	}
	
	public void newdrawSmooth (SpriteBatch batch, int speedDraw, float parentAlpha) {
		if (isStartedSmoothDraw) {
			float endChar = (float) iteration / (float) speedDraw;
			if (textToDraw.length() == endChar) {
				isStartedSmoothDraw = false;
				isFinishedScene = true;
			} else {
				if (endChar == (int) endChar) {
					label.setText(textToDraw.substring(0, (int) endChar + 1));
				}
				iteration++;
			}
			draw(batch, parentAlpha);
		} else {
			if (isFinishedScene) {
				draw(batch, parentAlpha);
			} else {
				iteration = 0;
				textToDraw = label.getText().toString();
				words = textToDraw.split(" ");
				isStartedSmoothDraw = true;
			}
		}
	}
	
	/**
	 * Draws the text
	 * 
	 * @param batch
	 * @param parentAlpha
	 */
	public void draw (SpriteBatch batch, float parentAlpha) {
		label.draw(batch, parentAlpha);
	}
	
	/**
	 * Sets a visible for textbox
	 * 
	 * @param visible
	 */
	public void setVisible(boolean visible) {
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
		label.setPosition(x1, y1);
		label.setAlignment(alignment);
		label.setSize(Math.abs(x1) + x2, Math.abs(y1) + y2);
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
	public void setColor(Color color) {
		label.setColor(color);
	}
	
	/**
	 * Sets the scale for text
	 * 
	 * @param scale
	 */
	public void setScale(float scale) {
		label.setScale(scale);
	}
	
	/**
	 * Sets the text
	 * 
	 * @param text
	 */
	public void setText(CharSequence text) {
		label.setText(text);	
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
