package geom;

import geom.Vector;

public class VectorUtils {

	public static float module(Vector A) {
		float x = A.getX();
		float y = A.getY();
		float z = A.getZ();

		return (float)Math.sqrt(x*x + y*y + z*z);
	}

	public static Vector multiply(Vector A, float a) {
		float x = A.getX() * a;
		float y = A.getY() * a;
		float z = A.getZ() * a;

		return new Vector(x, y, z);
	}

	public static boolean isCollinear(Vector A, Vector B) {
		float Ax = A.getX();
		float Ay = A.getY();
		float Az = A.getZ();
		float Bx = B.getX();
		float By = B.getY();
		float Bz = B.getZ();

		float l1 = Bx / Ax;
		float l2 = By / Ay;
		float l3 = Bz / Az;

		return (l1==l2) && (l2==l3) ? true : false;
	}

}
