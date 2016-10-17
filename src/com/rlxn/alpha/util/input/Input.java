package com.rlxn.alpha.util.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import com.rlxn.alpha.util.math.Coordinate2f;

public class Input {

	public static Mouse mouse = new Mouse();
	
	public static class Keyboard implements KeyListener {

		public enum KeyState {
			active, released, inactive
		}

		public static KeyState[] keys = new KeyState[60000];

		public static KeyState keyState(int keycode) {
			return keys[keycode];
		}

		@Override
		public void keyPressed(KeyEvent e) {
			keys[e.getKeyCode()] = KeyState.active;
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (keys[e.getKeyCode()] == KeyState.active) keys[e.getKeyCode()] = KeyState.released;
			else keys[e.getKeyCode()] = KeyState.inactive;
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		}

	}

	public static class Mouse implements MouseMotionListener, MouseWheelListener, MouseListener {

		public static int NONE = -1;
		public static int LMB = 1;
		public static int MMB = 2;
		public static int RMB = 3;
		public static int MB4 = 4;
		public static int MB5 = 5;

		Coordinate2f pos = new Coordinate2f();
		int button;

		public int x() {
			return Math.round(pos.x);
		}

		public int y() {
			return Math.round(pos.y);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			button = e.getButton();

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			button = -1;
		}

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseDragged(MouseEvent e) {
			pos.x = e.getX();
			pos.y = e.getY();
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			pos.x = e.getX();
			pos.y = e.getY();
		}

	}
}
