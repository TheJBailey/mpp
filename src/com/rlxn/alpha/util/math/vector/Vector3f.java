package com.rlxn.alpha.util.math.vector;

public class Vector3f {

	public static final int X = 1;
	public static final int Y = 2;
	public static final int Z = 3;

	float x, y, z;

	public Vector3f(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector3f() {
		x = y = z = 0;
	}

	public float distance(int axis, Vector3f vector) {
		// switch (axis) {
		// case X:
		// return 0;
		// case Y:
		// return 0;
		// case Z:
		// return 0;
		// case (X & Y):
		// return 0;
		// case (Y & Z):
		// return 0;
		// case (X & Z):
		// return 0;
		// case (X & Y & Z):
		// return 0;
		// }
		return 0;
	}

}
