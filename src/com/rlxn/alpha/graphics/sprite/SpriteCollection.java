package com.rlxn.alpha.graphics.sprite;

import com.rlxn.alpha.graphics.sprite.SpriteSet;

public interface SpriteCollection {

	public abstract SpriteSet idle();

	public abstract SpriteSet walking();

	public abstract SpriteSet running();

	public abstract SpriteSet biking();

	public abstract SpriteSet surfing();

	public abstract SpriteSet escape();

	public abstract SpriteSet flying();

}
