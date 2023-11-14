package alg;

import alg.Matrix;

public class MatrixUtils {

	public static Matrix sum(Matrix A, Matrix B) {
		if ( (A.rows() != B.rows()) && (A.columns() != B.columns()) ) {
			throw new ArithmeticException("Matrices are not of the same dimension");
		}

		Matrix C = new Matrix(A.rows(), B.columns());

		for (int i = 0; i < C.rows(); i++) {
			for (int j = 0; j < C.columns(); j++) {
				C.setElement(i, j, A.getElement(i, j) + B.getElement(i, j));
			}
		}

		return C;
	}

	public static Matrix multiply(Matrix A, Matrix B) {
		if (A.columns() != B.rows()) {
			throw new ArithmeticException("Cannot multiply matrices!");
		}

		double[][] product = new double[A.rows()][B.columns()];

		for (int i = 0; i < product.length; i++) {
			for (int j = 0; j < product[0].length; j++) {
				for (int n = 0; n < product[0].length; n++) {
					product[i][j] += A.getElement(i, n) * B.getElement(n, j);
				}
			}
		}

		return new Matrix(product);
	}

	public static void multiply(Matrix A, double value) {
		for (int i = 0; i < A.rows(); i++) {
			for (int j = 0; j < A.columns(); j++) {
				double product = A.getElement(i, j) * value;
				A.setElement(i, j, product);
			}
		}
	}

	public static Matrix transpose(Matrix A) {
		Matrix transMat = new Matrix(A.columns(), A.rows());

		for (int i = 0; i < transMat.rows(); i++) {
			for (int j = 0; j < transMat.columns(); j++) {
				transMat.setElement(i, j, A.getElement(j, i));
			}
		}

		return transMat;
	}

	public static Matrix minor(Matrix matrix, int row, int column) {
		int M = matrix.rows() - 1;
		int N = matrix.columns() - 1;
		Matrix result = new Matrix(M, N);

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				result.setElement(i, j, matrix.getElement(i, j));
			}
			for (int j = column; j < N; j++) {
				result.setElement(i, j, matrix.getElement(i, j+1));
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < column; j++) {
				result.setElement(i, j, matrix.getElement(i+1, j));
			}
			for (int j = column; j < N; j++) {
				result.setElement(i, j, matrix.getElement(i+1, j+1));
			}
		}

		return result;
	}

	public static double det(Matrix A) {
		if (!A.isSquare()) {
			throw new IllegalArgumentException("Matrix in not square");
		}

		if (A.order() == 1) {
			return A.getElement(0, 0);
		} else if (A.order() == 2) {
			double det = (A.getElement(0, 0) * A.getElement(1, 1)) - (A.getElement(0, 1) * A.getElement(1, 0));
			return det;
		} else if (A.order() == 3) {
			double det = A.getElement(0 ,0) * A.getElement(1, 1) * A.getElement(2, 2) +
						 A.getElement(0, 1) * A.getElement(1, 2) * A.getElement(2, 0) +
						 A.getElement(0, 2) * A.getElement(1, 0) * A.getElement(2, 1) -
						 A.getElement(0, 2) * A.getElement(1, 1) * A.getElement(2, 0) -
						 A.getElement(0, 1) * A.getElement(1, 0) * A.getElement(2, 2) -
						 A.getElement(0, 0) * A.getElement(1, 2) * A.getElement(2, 1);
			return det;
		} else {
			double sum = 0.0;
			int i = 0;

			for (int j = 0; j < A.rows(); j++) {
				double minor = det(minor(A, i, j));
				double aij = Math.pow(-1, (i+1) + (j+1)) * A.getElement(i, j);
				sum += aij * minor;
			}

			return sum;
		}
	}

/*
	public static Matrix removeRow(Matrix matrix, int row) {
		int M = matrix.rows() - 1;
		int N = matrix.columns();
		Matrix result = new Matrix(M, N);

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < N; j++) {
				result.setElement(i, j, matrix.getElement(i, j));
			}
		}

		for (int i = row; i < M; i++) {
			for (int j = 0; j < N; j++) {
				result.setElement(i, j, matrix.getElement(i+1, j));
			}
		}

        return result;
	}

	public static Matrix removeCol(Matrix matrix, int column) {
		int M = matrix.rows();
		int N = matrix.columns() - 1;
		Matrix result = new Matrix(M, N);

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < column; j++) {
				result.setElement(i, j, matrix.getElement(i, j));
			}
			for (int j = column; j < N; j++) {
				result.setElement(i, j, matrix.getElement(i, j+1));
			}
		}

		return result;
	}

	public static Matrix removeRowCol(Matrix matrix, int row, int column) {
		int M = matrix.rows() - 1;
		int N = matrix.columns() - 1;
		Matrix result = new Matrix(M, N);

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				result.setElement(i, j, matrix.getElement(i, j));
			}
			for (int j = column; j < N; j++) {
				result.setElement(i, j, matrix.getElement(i, j+1));
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < column; j++) {
				result.setElement(i, j, matrix.getElement(i+1, j));
			}
			for (int j = column; j < N; j++) {
				result.setElement(i, j, matrix.getElement(i+1, j+1));
			}
		}

		return result;
	}
*/

}
