package com.rlxn.alpha.graphics.sprite;

public class Sprite {

	int width, height;
	int[] pixels;
	
	public Sprite(int w, int h, int color) {
		width = w;
		height = h;
		pixels = new int[width * height];
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = color;
		}
	}

	public Sprite(int x, int y, int w, int h, SpriteSheet sheet) {
		width = w;
		height = h;
		pixels = new int[width * height];
		load(x * width, y * height, sheet);
	}

	public void load(int xp, int yp, SpriteSheet sheet) {
		for (int y = 0; y < height; y++) {
			int ya = y + yp;
			for (int x = 0; x < width; x++) {
				int xa = x + xp;
				pixels[x + y * width] = sheet.pixels()[xa + ya * sheet.width()];
			}
		}
	}

	public int width() {
		return width;
	}

	public int height() {
		return height;
	}

	public int[] pixels() {
		return pixels;
	}

}
