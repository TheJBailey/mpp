package com.rlxn.alpha.graphics.sprite;

import java.awt.image.BufferedImage;

import com.rlxn.alpha.util.io.IOUtil;

public class SpriteSheet {

	public static SpriteSheet ENTITYSET = new SpriteSheet("\\res\\assets\\sheets\\entityset.png");
	public static final SpriteSheet TILESET = new SpriteSheet("\\res\\assets\\sheets\\tileset.png");
	public static final SpriteSheet PLAYER = new SpriteSheet("\\res\\assets\\sheets\\player.png");

	private String path;
	private int[] pixels;
	private int width, height;

	public SpriteSheet(String path) {
		this.path = path;
		load();
	}

	private void load() {
		BufferedImage image = IOUtil.loadImageResource(path);
		width = image.getWidth();
		height = image.getHeight();
		pixels = new int[width * height];
		image.getRGB(0, 0, width, height, pixels, 0, width);
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
