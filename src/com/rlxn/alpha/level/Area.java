package com.rlxn.alpha.level;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.rlxn.alpha.entity.Entity;
import com.rlxn.alpha.entity.mob.Mob;
import com.rlxn.alpha.graphics.Camera;
import com.rlxn.alpha.graphics.Screen;
import com.rlxn.alpha.graphics.tile.Tile;
import com.rlxn.alpha.level.areas.Room;
import com.rlxn.alpha.util.io.IOUtil;

public abstract class Area {

	public static Area TEST = new Room("\\res\\levels\\test_level\\");

	String dir;

	private static long time, delta;

	String name;
	int width, height;
	Tile[] tiles;
	Entity[] entities;
	Mob[] npc;
	ArrayList<Mob> players;

	public Area(String dir) {
		this.dir = dir;
		load();
	}

	private void load() {
		BufferedImage imagemap;
		
		imagemap = IOUtil.loadImageResource(dir + "tilemap.png");
		width = imagemap.getWidth();
		height = imagemap.getHeight();
		tiles = new Tile[width * height];
		int[] colormap = new int[width * height];
		imagemap.getRGB(0, 0, width, height, colormap, 0, width);
		
		for (int i = 0; i < tiles.length; i++) {
			switch (colormap[i]) {
			case 0xFFEEBB77:
				tiles[i] = Tile.INDOOR_FLOOR;
				break;
			default:
				tiles[i] = Tile.Void;
				break;
			}
		}
	}

	public void update() {
		
	}

	public void render(Screen screen) {
		int xs = Camera.levelOffsetX() >> 4;
		int xe = Camera.levelOffsetX() + screen.width() >> 4;
		int ys = Camera.levelOffsetY() >> 4;
		int ye = Camera.levelOffsetY() + screen.height() >> 4;
		for (int y = ys; y <= ye; y++) {
			for (int x = xs; x <= xe; x++) {
				getTile(x, y).render((x << 4), (y << 4), screen);
			}
		}

		// screen.renderSprite((int) wall.x(), (int) wall.y(), wall.sprite(), true);

	}

	public Entity getEntity(int x, int y) {
		for (int i = 0; i < entities.length; i++) {
			Entity e = entities[i];
			boolean xc = x >= ((int) e.x() >> 4) && x <= ((int) (e.x() + e.width()) >> 4);
			boolean yc = y >= ((int) e.y() >> 4) && y <= ((int) (e.y() + e.height()) >> 4);
			if (xc && yc) return e;
		}
		return null;
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.Void;
		return tiles[x + y * width];
	}

	public long time() {
		return time;
	}

	public long deltaTime() {
		return delta;
	}
}
