package com.rlxn.alpha.graphics;

import java.awt.Graphics;

import com.rlxn.alpha.graphics.sprite.Sprite;
import com.rlxn.alpha.graphics.tile.Tile;

public class Screen {

	public static final int INV_COLOR = 0xFFFFF200;
	public static final int INV_COLOR_2 = 0xFF00B7EF;

	private int[] pixels;
	private int width, height;
	Graphics graphics;

	public Screen(int w, int h, int[] pixels, Graphics g) {
		width = w;
		height = h;

		this.pixels = pixels;
		graphics = g;
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++)
			pixels[i] = 0;
	}

	public void renderTile(int xp, int yp, Tile tile) {
		xp -= Camera.levelOffsetX();
		yp -= Camera.levelOffsetY();
		for (int y = 0; y < tile.sprite().height(); y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.sprite().width(); x++) {
				int xa = x + xp;
				if (xa < 0 || ya < 0 || xa >= width || ya >= height) continue;
				pixels[xa + ya * width] = tile.sprite().pixels()[x + y * tile.sprite().width()];
			}
		}
	}

	public void renderSprite(int xp, int yp, Sprite sprite, boolean fixed) {
		if (fixed) {
			xp -= Camera.levelOffsetX();
			yp -= Camera.levelOffsetY();
		}
		for (int y = 0; y < sprite.height(); y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.width(); x++) {
				int xa = x + xp;
				if (xa < 0 || ya < 0 || xa >= width || ya >= height) continue;
				int pixel = sprite.pixels()[x + y * sprite.width()];
				if (pixel == INV_COLOR || pixel == INV_COLOR_2) continue;
				pixels[xa + ya * width] = pixel;
			}
		}
	}

	public void renderRectangle(int xp, int yp, int width, int height, int color, boolean fixed) {
		if (fixed) {
			xp -= Camera.levelOffsetX();
			yp -= Camera.levelOffsetY();
		}
		for (int y = 0; y < height; y++) {
			int ya = y + yp;
			for (int x = 0; x < width; x++) {
				int xa = x + xp;
				pixels[xa + ya * this.width] = color;
			}
		}
	}

	public int width() {
		return width;
	}

	public int height() {
		return height;
	}

}
