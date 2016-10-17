package com.rlxn.alpha;

import java.awt.Canvas;
import java.awt.Font;

import com.rlxn.alpha.entity.mob.player.Player;
import com.rlxn.alpha.graphics.Camera;
import com.rlxn.alpha.graphics.Window;
import com.rlxn.alpha.level.Area;

public class Main extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static int TICK_RATE = 60;
	public static Font DEFAULT_FONT = new Font("HELVETICA", Font.PLAIN, 32);
	
	static String title = "Raster Game";
	static int width = 600, height = width / 4 * 3, scale = 2;

	private Window window;
	private static Thread thread;
	private boolean running;

	static Area area;
	static Player player;

	public Main() {
		window = new Window(width, height, scale, title);

		area = Area.TEST;
		player = new Player(9, 9, area);
	}

	public void update() {
		window.update();
		Camera.update(player, area, window.getScreen());
		area.update();
		player.update();
	}

	@Override
	public void run() {
		long lt = System.nanoTime();
		double delta = 0;

		while (running) {
			long now = System.nanoTime();
			delta += (now - lt) / (1000000000.0 / TICK_RATE);
			lt = now;

			if (delta >= 1) {
				update();
				delta--;
			}
		}
		stop();

	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Main");
		thread.start();
		window.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			System.err.println(thread.toString() + " failed to close");
		}
	}

	public static void main(String[] args) {
		new Main().start();
	}

	public static Player getPlayer() {
		return player;
	}

	public static Area getArea() {
		return area;
	}

	public static Thread thread() {
		return thread;
	}
}