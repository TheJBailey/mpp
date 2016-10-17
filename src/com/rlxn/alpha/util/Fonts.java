package com.rlxn.alpha.util;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

public class Fonts {
	public static void main(String[] a) {
		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Font[] fonts = e.getAllFonts(); // Get the fonts
		for (Font f : fonts) {
			System.out.println(f.getFontName());
		}
	}
}