package com.rlxn.alpha.entity.mob.player;

import static com.rlxn.alpha.util.input.Input.Keyboard.keyState;

import java.awt.event.KeyEvent;

import com.rlxn.alpha.entity.mob.Mob;
import com.rlxn.alpha.graphics.Camera;
import com.rlxn.alpha.graphics.Screen;
import com.rlxn.alpha.graphics.sprite.sets.PlayerSets;
import com.rlxn.alpha.graphics.tile.Tile;
import com.rlxn.alpha.level.Area;
import com.rlxn.alpha.util.input.Input.Keyboard.KeyState;

public class Player extends Mob {

	public Player(int x, int y, Area area) {
		super(x * Tile.SIZE, y * Tile.SIZE, 32, 32, PlayerSets.RED, area);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		int xa = 0, ya = 0;
		State qstate = State.still;

		if (keyState(KeyEvent.VK_A) == KeyState.active) xa -= 1;
		if (keyState(KeyEvent.VK_D) == KeyState.active) xa += 1;
		if (keyState(KeyEvent.VK_W) == KeyState.active) ya -= 1;
		if (keyState(KeyEvent.VK_S) == KeyState.active) ya += 1;

		if (xa != 0 || ya != 0) {
			if (keyState(KeyEvent.VK_SHIFT) == KeyState.active) qstate = State.running;
			else qstate = State.walking;
		}

		move(xa, ya, qstate);
	}

	public void render(Screen screen) {
		screen.renderSprite(Camera.playerX(), Camera.playerY(), sprite.sprite(), false);
	}

}
