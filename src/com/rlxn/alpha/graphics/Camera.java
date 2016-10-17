package com.rlxn.alpha.graphics;

import com.rlxn.alpha.entity.mob.player.Player;
import com.rlxn.alpha.level.Area;
import com.rlxn.alpha.util.math.Coordinate2f;

public abstract class Camera {

	private static Coordinate2f playerOffset = new Coordinate2f(0, 0);
	private static Coordinate2f levelOffset = new Coordinate2f(0, 0);
	private static Coordinate2f playerPosition = new Coordinate2f(0, 0);

	public static void update(Player player, Area area, Screen screen) {
		levelOffset.x = player.x() - (screen.width() - player.width()) / 2 - playerOffset.x;
		levelOffset.y = player.y() - (screen.height() - player.height()) / 2 - playerOffset.y;
		playerPosition.x = (screen.width() - player.width()) / 2 + playerOffset.x;
		playerPosition.y = (screen.height() - player.height()) / 2 + playerOffset.y;
	}

	public static int levelOffsetX() {
		return (int) levelOffset.x;
	}

	public static int levelOffsetY() {
		return (int) levelOffset.y;
	}

	public static float playerOffsetX() {
		return playerOffset.x;
	}

	public static float playerOffsetY() {
		return playerOffset.y;
	}

	public static int playerX() {
		return (int) playerPosition.x;
	}

	public static int playerY() {
		return (int) playerPosition.y;
	}

	public static void setPlayerOffset(int x, int y) {
		playerOffset.x = x;
		playerOffset.y = y;
	}
}
