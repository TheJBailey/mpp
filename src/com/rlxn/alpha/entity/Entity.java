package com.rlxn.alpha.entity;

import com.rlxn.alpha.graphics.Screen;
import com.rlxn.alpha.graphics.sprite.AniSprite;
import com.rlxn.alpha.graphics.sprite.Sprite;
import com.rlxn.alpha.level.Area;
import com.rlxn.alpha.util.math.Coordinate2f;

public abstract class Entity {

	protected int width, height;
	protected Coordinate2f pos;
	protected AniSprite sprite;
	protected Area area;
	protected boolean solid = true;

	public Entity(int x, int y, AniSprite sprite) {
		this.sprite = sprite;
		width = sprite.width();
		height = sprite.height();
		pos = new Coordinate2f(x, y);
	}

	public Entity(int x, int y, int width, int height, AniSprite sprite, Area area) {
		pos = new Coordinate2f(x, y);
		this.width = width;
		this.height = height;
		this.sprite = sprite;
		this.area = area;
	}

	public abstract void update();

	public boolean collision(int x, int y) {
		int xt = ((int) pos.x >> 4) + x;
		int yt = ((int) pos.y >> 4) + y;
		int wt = (width >> 4) / 2;
		int ht = (height >> 4) / 2;
		if (area.getTile(xt, yt).isSolid()) return true;
		if (area.getTile(xt + wt, yt + ht).isSolid()) return true;

		// Entity e = getEntity(xt, yt);
		// if (e == null || e.isSolid()) return true;
		return false;
	}

	public void render(Screen screen) {
		screen.renderSprite((int) pos.x, (int) pos.y, sprite.sprite(), true);
	}

	public int width() {
		return width;
	}

	public int height() {
		return height;
	}

	public float x() {
		return pos.x;
	}

	public float y() {
		return pos.y;
	}

	public Sprite sprite() {
		return sprite.sprite();
	}

	public boolean isSolid() {
		return solid;
	}
}
