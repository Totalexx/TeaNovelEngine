package com.rafaskoberg.gdx.typinglabel.effects;

import com.rafaskoberg.gdx.typinglabel.Effect;
import com.rafaskoberg.gdx.typinglabel.TypingGlyph;
import com.rafaskoberg.gdx.typinglabel.TypingLabel;

public class PauseEffect extends Effect{

	TypingLabel label;
	
	
	public PauseEffect(TypingLabel label) {
		super(label);
		this.label = label;
	}

	@Override
	protected void onApply(TypingGlyph glyph, int localIndex, float delta) {
		label.pause();
	}

}
