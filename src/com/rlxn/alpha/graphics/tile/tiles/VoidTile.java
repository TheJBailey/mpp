package com.rlxn.alpha.graphics.tile.tiles;

import com.rlxn.alpha.graphics.sprite.Sprite;
import com.rlxn.alpha.graphics.tile.Tile;

public class VoidTile extends Tile {

	public VoidTile(Sprite sprite) {
		super(sprite);
	}

	public boolean isSolid() {
		return true;
	}

}
