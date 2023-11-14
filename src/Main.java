// import alg.Matrix;
// import alg.MatrixUtils;
// import matan.Fibonacci;
import geom.Vector;
import geom.VectorUtils;

public class Main {
	public static void main(String[] args) {
		// Matrix m4 = new Matrix(new double[][] {
		// 	{4.00, 2.00, 6.00, 13.00},
		// 	{17.00, 18.00, 19.00, 5.00},
		// 	{10.00, 14.00, 12.00, 8.00},
		// 	{14.00, 1.00, 12.00, 31.00}
		// });

		// System.out.println(Fibonacci.sum(10));
		// Fibonacci.printSequence(50);

		Vector v1 = new Vector(3.0f, 5.0f);
		System.out.println(VectorUtils.module(v1));
	}
}
