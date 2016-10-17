package com.rlxn.alpha.entity.entities;

import com.rlxn.alpha.entity.Entity;
import com.rlxn.alpha.graphics.sprite.Sprite;
import com.rlxn.alpha.graphics.sprite.SpriteSheet;

public class Pokemart {

	public static Entity WALL = new DecorEntity(19, 0, new Sprite(12, 6, 16, 32, SpriteSheet.ENTITYSET));
	public static Entity CORNER_RIGHT = new DecorEntity(19, 0, new Sprite(8, 4, 16, 48, SpriteSheet.ENTITYSET));
	public static Entity CORNER_LEFT = new DecorEntity(19, 0, new Sprite(8, 4, 16, 48, SpriteSheet.ENTITYSET));
}
