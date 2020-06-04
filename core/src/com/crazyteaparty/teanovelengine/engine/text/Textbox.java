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
public class Textbox extends Actor{
	
	/** List of characters. */
	protected final String FONT_CHARS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮ"
			+ "ЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";
	
	/** Parameters for generation font. */
	protected FreeTypeFontParameter parameters;
	/** Font for generation LabelStyle. */
	protected BitmapFont font;
	/** Label for drawing text. */
	protected Label label;
	/** Draw text char by char*/
	protected boolean charByChar = false;
	/** pause in drawing*/
	protected boolean pauseDraw = false;
    /** End of draw*/
	protected boolean endDraw = false;
	
	protected String currentText;
	
	
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
	private Label generateLabel(CharSequence text, String defaultToken, Color color) {
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
		return initializeTextBox(fontPathFile, "{ENDTEXT}", text, scaleX, scaleY, lineHeight, x1, y1, x2, y2, color);
	}
	
	/**
	 * Generates the textbox for draw.
	 * 
	 * @param fontPathFile
	 * @param defaultToken
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
	public Label initializeTextBox (String fontPathFile, String defaultToken, CharSequence text, float scaleX, float scaleY, float lineHeight, float x1, 
			float y1, float x2, float y2, Color color) {
		generateFont(fontPathFile);
		font.getData().scaleY = scaleX;
		font.getData().scaleY = scaleY;
		font.getData().setLineHeight(lineHeight);
		generateLabel(text, defaultToken, color);
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
	float speedDraw = 10;
	int iteration = 1;
	@Override
	public void draw(Batch batch, float parentAlpha) {
		if(charByChar && !(endDraw && pauseDraw)) {
			float indexChar = iteration / speedDraw;
			if(indexChar == (int) indexChar) {
				String setText = currentText.substring(1, (int) indexChar) + "[#000000FF]" 
						+ currentText.substring((int) indexChar, currentText.length());
				label.setText(setText);
				/*if(false) {
					pauseDraw = true;
				}*/
			}
			if(label.getText().length == indexChar) {
				endDraw = true;
			}
			iteration++;
		}
		label.draw(batch, parentAlpha);
	}
	
	public void setSpeedDraw(float speedDraw) {
		this.speedDraw = speedDraw;
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
