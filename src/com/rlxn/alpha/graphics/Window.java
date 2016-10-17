package com.rlxn.alpha.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.rlxn.alpha.Main;
import com.rlxn.alpha.util.input.Input;

public class Window extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 0;
	public static final int HEIGHT = 1;
	public static final int SCALE = 2;
	public static final int TITLE = 3;
	public static final int FRAMES = 4;
	public static final int FRAME_OBJECT = 5;
	public static final int FPS = 6;

	private static final Font DEV_FONT = new Font("Digital Dismay", Font.PLAIN, 24);
	public static boolean DEV_HUD = true;

	static Thread thread;

	JFrame frame;
	int width, height, scale;
	String title;

	BufferedImage image;
	Graphics2D graphics;
	Screen screen;
	int[] pixels;

	int fps = 0, dfps;
	long lft, ldt;

	boolean running = false;

	public Window(int w, int h, int s, String title) {
		width = w;
		height = h;
		scale = s;
		this.title = title;

		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

		screen = new Screen(width, height, pixels, graphics);

		frame = new JFrame(title);

		addMouseListener(Input.mouse);
		addMouseMotionListener(Input.mouse);
		addMouseWheelListener(Input.mouse);
		addKeyListener(new Input.Keyboard());

		lft = System.nanoTime();
		ldt = System.currentTimeMillis();

		initFrame();
	}

	public void update() {

	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(2);
			return;
		}

		graphics = (Graphics2D) bs.getDrawGraphics();
		// setRenderingHints(graphics);

		Main.getArea().render(screen);
		Main.getPlayer().render(screen);

		graphics.drawImage(image, 0, 0, width * scale, height * scale, null);

		if (DEV_HUD) devHud();

		screen.clear();
		graphics.dispose();
		bs.show();
	}

	@Override
	public void run() {
		requestFocus();
		while (running) {
			render();
			fps = (int) Math.round(1000000000.0 / (System.nanoTime() - lft));
			lft = System.nanoTime();
		}
		stop();
	}

	private void devHud() {
		if (graphics.getColor() != Color.cyan) graphics.setColor(Color.cyan);
		if (graphics.getFont() != DEV_FONT) graphics.setFont(DEV_FONT);
		graphics.drawString(dfps + "", 4, 20);
		if (System.currentTimeMillis() - ldt > 150) {
			dfps = fps;
			ldt += 150;
		}
	}

	@SuppressWarnings("unused")
	private void setRenderingHints(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		g.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
		g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}

	public void initFrame() {
		frame.add(this);
		frame.setPreferredSize(new Dimension(width * scale, height * scale));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void setTitle(String title) {
		frame.setTitle(title);
	}

	public Object fetch(int prop_reference) {
		switch (prop_reference) {
		case WIDTH:
			return width;
		case HEIGHT:
			return height;
		case SCALE:
			return scale;
		case TITLE:
			return title;
		case FRAME_OBJECT:
			return frame;
		case FPS:
			return fps;
		default:
			return null;
		}

	}

	public void start() {
		thread = new Thread(this, "Graphics");
		thread.start();
		running = true;
	}

	public Screen getScreen() {
		return screen;
	}

	public void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static Thread thread() {
		return thread;
	}
}
