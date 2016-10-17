package com.rlxn.alpha.graphics.tile;

import com.rlxn.alpha.graphics.Screen;
import com.rlxn.alpha.graphics.sprite.Sprite;
import com.rlxn.alpha.graphics.sprite.SpriteSheet;
import com.rlxn.alpha.graphics.tile.tiles.FloorTile;
import com.rlxn.alpha.graphics.tile.tiles.VoidTile;

public abstract class Tile {
	
	public static final int SIZE = 16;
	
	public static final Tile Void = new VoidTile(new Sprite(SIZE, SIZE, 0xFF000000));
	public static final Tile INDOOR_FLOOR = new FloorTile(new Sprite(7, 0 , SIZE, SIZE, SpriteSheet.TILESET));
	
	Sprite sprite;
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x, y, this);
	}

	public boolean isSolid() {
		return false;
	}
	
	public Sprite sprite() {
		return sprite;
	}

}
