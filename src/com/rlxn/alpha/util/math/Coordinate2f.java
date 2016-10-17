package com.rlxn.alpha.util.math;

public class Coordinate2f {

	public float x, y;
	
	public Coordinate2f() {
		x = y = -1;
	}

	public Coordinate2f(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public double distance(Coordinate2f coor) {
		return -1;
	}
	
	public String toString() {
		return "x: " + x + ", y: " + y;
	}

}
