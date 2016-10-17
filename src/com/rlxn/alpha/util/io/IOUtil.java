package com.rlxn.alpha.util.io;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class IOUtil {
	
	public static String GAME_DIR = System.getProperty("user.dir");


	public static BufferedImage loadImageResource(String path) {
		try {
			return ImageIO.read(new File(GAME_DIR + path));
		} catch (IOException e) {
			System.err.println("failed to load image::" + GAME_DIR + path);
			e.printStackTrace();
			return null;
		}
	}

}