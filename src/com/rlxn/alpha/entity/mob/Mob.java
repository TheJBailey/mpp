package com.rlxn.alpha.entity.mob;

import com.rlxn.alpha.entity.Entity;
import com.rlxn.alpha.graphics.sprite.SpriteCollection;
import com.rlxn.alpha.graphics.sprite.SpriteSet;
import com.rlxn.alpha.graphics.tile.Tile;
import com.rlxn.alpha.level.Area;
import com.rlxn.alpha.util.math.Functions;

public abstract class Mob extends Entity {

	public static final int NONE = -1;
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;

	public enum State {
		walking, running, biking, surfing, waterfalling, still, idle;

		public boolean moving() {
			return !(this == idle || this == still);
		}
	}

	protected State state = State.still;

	protected SpriteCollection collection;
	protected SpriteSet set;

	float tick = 0, count = 0;

	private int dir = -1;
	private float xt, yt;
	private float speed;

	public Mob(int x, int y, int width, int height, SpriteCollection col, Area area) {
		super(x, y, width, height, col.idle().get(-1), area);
		this.collection = col;
	}

	protected void move(int xa, int ya, State nstate) {

		if (xt == 0 && yt == 0) {
			if (xa != 0) {
				if (!collision(xa, 0)) {
					xt = Tile.SIZE * (xa < 0 ? -1 : 1);
					dir = xa < 0 ? LEFT : RIGHT;

				}
				setState(nstate);

			} else if (ya != 0) {
				if (!collision(0, ya)) {
					yt = Tile.SIZE * (ya < 0 ? -1 : 1);
					dir = ya < 0 ? UP : DOWN;
				}
				setState(nstate);

			} else setState(State.still);
		} else {
			float delta;
			if (Math.abs(xt) > 0) {
				delta = Functions.abs(xt) * speed;
				if (Math.abs(delta) > Math.abs(xt)) delta = xt;
				pos.x += delta;
				xt -= delta;

			} else if (Math.abs(yt) > 0) {
				delta = Functions.abs(yt) * speed;
				if (Math.abs(delta) > Math.abs(yt)) delta = yt;
				pos.y += delta;
				yt -= delta;
			}
		}
		sprite.update();

		/*
		 * old method issues: - didn't change direction on collision - sprite
		 * animation timing was bad - wasn't colliding correctly with right wall
		 * (may not be this) if (xt == 0 && yt == 0) { if (xa != 0) { if
		 * (!collision(xa, 0)) { xt = Tile.SIZE * (xa < 0 ? -1 : 1); dir = xa <
		 * 0 ? LEFT : RIGHT;
		 * 
		 * } setState(nstate);
		 * 
		 * } else if (ya != 0) { if (!collision(0, ya)) { yt = Tile.SIZE * (ya <
		 * 0 ? -1 : 1); dir = ya < 0 ? UP : DOWN; } setState(nstate);
		 * 
		 * } else setState(State.still); } else { float delta; if (Math.abs(xt)
		 * > 0) { delta = Functions.abs(xt) * speed; if (Math.abs(delta) >
		 * Math.abs(xt)) delta = xt; pos.x += delta; xt -= delta;
		 * 
		 * } else if (Math.abs(yt) > 0) { delta = Functions.abs(yt) * speed; if
		 * (Math.abs(delta) > Math.abs(yt)) delta = yt; pos.y += delta; yt -=
		 * delta; } } sprite.update();
		 */
	}

	private void setState(State state) {
		this.state = state;
		switch (state) {
		case biking:
			setMotion(collection.biking(), 4f);
			break;
		case running:
			setMotion(collection.running(), 2f);
			break;
		case surfing:
			setMotion(collection.surfing(), 1f);
			break;
		case walking:
			setMotion(collection.walking(), 1f);
			break;
		case waterfalling:
			setMotion(collection.surfing(), .5f);
			break;
		case still:
			setMotion(collection.idle(), 0f);
			speed = 0f;
			break;
		default:
			speed = 1f;
			break;
		}
	}

	private void setMotion(SpriteSet ss, float spd) {
		set = ss;
		sprite = set.get(dir);
		speed = spd;
	}

}
