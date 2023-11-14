package geom;

public class Vector {

	private final float abscissa;
	private final float ordinate;
	private final float applicate;

	public Vector(float x, float y) {
		this.abscissa = x;
		this.ordinate = y;
		this.applicate = 0.0f;
	}

	public Vector(float x, float y, float z) {
		this.abscissa = x;
		this.ordinate = y;
		this.applicate = z;	
	}

	public float getX() {
		return abscissa;
	}

	public float getY() {
		return ordinate;
	}

	public float getZ() {
		return applicate;
	}

}
