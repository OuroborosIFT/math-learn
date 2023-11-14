package alg;

import java.util.Random;

public class Matrix {

	private final double[][] matrix;
	//matrix dimension
	private int row;	//number of matrix rows (количество строк матрицы)
	private int column;	//number of matrix columns (количество столбцов матрицы)

	public Matrix() {
		Random rand = new Random();
		this.row = rand.nextInt(10) + 1;
		this.column = this.row;
		this.matrix = new double[row][column];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				this.matrix[i][j] = rand.nextDouble() * (double)rand.nextInt(100) + 1.00;
			}
		}
	}

	public Matrix(int row, int column) {
		Random rand = new Random();
		this.row = row;
		this.column = column;
		this.matrix = new double[row][column];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				this.matrix[i][j] = rand.nextDouble() * (double)rand.nextInt(100) + 1.00;
			}
		}
	}

	public Matrix(int row) {
		this(row, row);
	}

	public Matrix(double[][] matrix) {
		this.row = matrix.length;
		this.column = matrix[0].length;
		this.matrix = matrix;
	}

	public Matrix(Matrix matrix) {
		this.matrix = matrix.getArray();
		this.row = matrix.rows();
		this.column = matrix.columns();
	}

	public void print() {
		for (double[] m1 : this.matrix) {
			for (double m : m1) {
				System.out.printf(" %.2f ", m);
			}
			System.out.println();
		}
	}

	public double[][] getArray() {
		return this.matrix;
	}

	public boolean isSquare() {
		return this.row == this.column ? true : false;
	}

	public int order() {
		if (!this.isSquare()) {
			throw new ArithmeticException("The matrix is not square!");
		}

		return this.row;
	}

	// возвращает количество строк матрицы
	public int rows() {
		return this.row;
	}

	// возвращает количество столбцов матрицы
	public int columns() {
		return this.column;
	}

	public double getElement(int i, int j) {
		return this.matrix[i][j];
	}

	public void setElement(int i, int j, double value) {
		this.matrix[i][j] = value;
	}

}
