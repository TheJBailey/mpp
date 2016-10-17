package com.rlxn.alpha.graphics.sprite;

public class AniSprite {

	Sprite[] sprites;
	Sprite sprite;
	float length, tick;
	int frame = 0;

	public AniSprite(int frameLength, Sprite... sprites) {
		this.sprites = sprites;
		length = tick = frameLength;
		sprite = sprites[0];
	}

	public void update() {
		if (tick != 0) tick--;
		else {
			tick = length;
			frame++;
		}
		if (frame > sprites.length - 1) frame = 0;
		sprite = sprites[frame];
	}

	public Sprite sprite(int frame) {
		return sprites[frame];
	}

	public void next() {
		frame++;
		if (frame > sprites.length - 1) frame = 0;
	}

	public float updateRate(float time) {
		return length = time;
	}

	public int nframes() {
		return sprites.length;
	}

	public Sprite sprite() {
		return sprite;
	}

	public int width() {
		return sprite.width();
	}

	public int height() {
		return sprite.height();
	}

}
