package com.rlxn.alpha.graphics.sprite.sets;

import com.rlxn.alpha.graphics.sprite.AniSprite;
import com.rlxn.alpha.graphics.sprite.Sprite;
import com.rlxn.alpha.graphics.sprite.SpriteCollection;
import com.rlxn.alpha.graphics.sprite.SpriteSet;
import com.rlxn.alpha.graphics.sprite.SpriteSheet;

public class PlayerSets {

	public static Red RED = new Red();

	// @formatter:off
	public static class Red implements SpriteCollection {
		private int animation_speed = 10;
		
		private final AniSprite idle_up = new AniSprite(-1, new Sprite(1, 1, 16, 32, SpriteSheet.PLAYER));
		private final AniSprite idle_left = new AniSprite(-1, new Sprite(1, 2, 16, 32, SpriteSheet.PLAYER));
		private final AniSprite idle_down = new AniSprite(-1, new Sprite(1, 0, 16, 32, SpriteSheet.PLAYER));
		private final AniSprite idle_right = new AniSprite(-1, new Sprite(1, 3, 16, 32, SpriteSheet.PLAYER));
		private final SpriteSet idle = new SpriteSet(idle_left, idle_up, idle_right, idle_down);
		
		private  final AniSprite walk_up = new AniSprite(animation_speed, 
				new Sprite(1, 1, 16, 32, SpriteSheet.PLAYER),
				new Sprite(0, 1, 16, 32, SpriteSheet.PLAYER),
				new Sprite(1, 1, 16, 32, SpriteSheet.PLAYER),
				new Sprite(2, 1, 16, 32, SpriteSheet.PLAYER)
				);
		private final AniSprite walk_left = new AniSprite(animation_speed, 
				new Sprite(1, 2, 16, 32, SpriteSheet.PLAYER),
				new Sprite(0, 2, 16, 32, SpriteSheet.PLAYER),
				new Sprite(1, 2, 16, 32, SpriteSheet.PLAYER),
				new Sprite(2, 2, 16, 32, SpriteSheet.PLAYER)
				);
		private final AniSprite walk_down = new AniSprite(animation_speed, 
				new Sprite(1, 0, 16, 32, SpriteSheet.PLAYER),
				new Sprite(0, 0, 16, 32, SpriteSheet.PLAYER),
				new Sprite(1, 0, 16, 32, SpriteSheet.PLAYER),
				new Sprite(2, 0, 16, 32, SpriteSheet.PLAYER)
				);
		private final AniSprite walk_right = new AniSprite(animation_speed, 
				new Sprite(1, 3, 16, 32, SpriteSheet.PLAYER),
				new Sprite(0, 3, 16, 32, SpriteSheet.PLAYER),
				new Sprite(1, 3, 16, 32, SpriteSheet.PLAYER),
				new Sprite(2, 3, 16, 32, SpriteSheet.PLAYER)
				);
		public final SpriteSet walking = new SpriteSet(walk_left, walk_up, walk_right, walk_down);
		
		private  final AniSprite run_up = new AniSprite(animation_speed / 2, 
				new Sprite(1, 5, 16, 32, SpriteSheet.PLAYER),
				new Sprite(0, 5, 16, 32, SpriteSheet.PLAYER),
				new Sprite(1, 5, 16, 32, SpriteSheet.PLAYER),
				new Sprite(2, 5, 16, 32, SpriteSheet.PLAYER)
				);
		private final AniSprite run_left = new AniSprite(animation_speed / 2, 
				new Sprite(1, 6, 16, 32, SpriteSheet.PLAYER),
				new Sprite(0, 6, 16, 32, SpriteSheet.PLAYER),
				new Sprite(1, 6, 16, 32, SpriteSheet.PLAYER),
				new Sprite(2, 6, 16, 32, SpriteSheet.PLAYER)
				);
		private final AniSprite run_down = new AniSprite(animation_speed / 2, 
				new Sprite(1, 4, 16, 32, SpriteSheet.PLAYER),
				new Sprite(0, 4, 16, 32, SpriteSheet.PLAYER),
				new Sprite(1, 4, 16, 32, SpriteSheet.PLAYER),
				new Sprite(2, 4, 16, 32, SpriteSheet.PLAYER)
				);
		private final AniSprite run_right = new AniSprite(animation_speed / 2, 
				new Sprite(1, 7, 16, 32, SpriteSheet.PLAYER),
				new Sprite(0, 7, 16, 32, SpriteSheet.PLAYER),
				new Sprite(1, 7, 16, 32, SpriteSheet.PLAYER),
				new Sprite(2, 7, 16, 32, SpriteSheet.PLAYER)
				);
		public final SpriteSet running = new SpriteSet(run_left, run_up, run_right, run_down);
		
		@Override
		public SpriteSet idle() {
			return idle;
		}
		@Override
		public SpriteSet walking() {
			return walking;
		}
		@Override
		public SpriteSet running() {
			return running;
		}
		@Override
		public SpriteSet biking() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public SpriteSet surfing() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public SpriteSet escape() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public SpriteSet flying() {
			// TODO Auto-generated method stub
			return null;
		}
	}
	// @formatter:on

}