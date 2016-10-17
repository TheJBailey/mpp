package com.rlxn.alpha.graphics.sprite;

import com.rlxn.alpha.entity.mob.player.Player;

public class SpriteSet {

	private AniSprite[] sprite = new AniSprite[4];

	public SpriteSet(AniSprite left, AniSprite up, AniSprite right, AniSprite down) {
		sprite[Player.LEFT] = left;
		sprite[Player.UP] = up;
		sprite[Player.RIGHT] = right;
		sprite[Player.DOWN] = down;
	}
	
	public AniSprite get(int dir) {
		if(dir == -1) return sprite[0];
		return sprite[dir];
	}

}
