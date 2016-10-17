package com.rlxn.alpha.entity.entities;

import com.rlxn.alpha.entity.Entity;
import com.rlxn.alpha.graphics.sprite.AniSprite;
import com.rlxn.alpha.graphics.sprite.Sprite;
import com.rlxn.alpha.graphics.tile.Tile;

public class DecorEntity extends Entity {

	public DecorEntity(int x, int y, Sprite sprite) {
		super(x * Tile.SIZE, y * Tile.SIZE, new AniSprite(0, sprite));

	}

	@Override
	public void update() {
	}

}
