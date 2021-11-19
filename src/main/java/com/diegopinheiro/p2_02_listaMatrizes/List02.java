package com.diegopinheiro.p2_02_listaMatrizes;

import java.lang.Math;

public class List02 {
	public static double[][] calculateCompoundInterest(double initialAmount, int numPeriods, double[] interestRates) {
		int column = interestRates.length;
		int row = numPeriods + 1;
		int countWhile = 0;
		int countIfRowGreaterThanOne;
		double[][] matrix = new double[row][column];

		for (int i = 0; i < row; i++) {
			countIfRowGreaterThanOne = i + 2;
			while (countWhile < column) {
				matrix[0][countWhile] = initialAmount;
				interestRates[countWhile] += 1;
				if (row > 1) {
					matrix[1][countWhile] = matrix[0][countWhile] * interestRates[countWhile];
				}
				countWhile++;
			}
			if (row > 2) {
				for (int j = 0; j < column; j++) {
					if (matrix[row - 1][column - 1] != 0) {
						break;
					}
					matrix[countIfRowGreaterThanOne][j] = (matrix[countIfRowGreaterThanOne - 1][j]
							/ matrix[countIfRowGreaterThanOne - 2][j]) * matrix[countIfRowGreaterThanOne - 1][j];
				}
			}

		}

		return matrix;
	}

	public static double[][] matrixMultiplication(double a, double[][] A) {
		int column = A[0].length;
		double[][] C = new double[A.length][column];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				C[i][j] = A[i][j] * a;
			}
		}

		return C;
	}

	public static double[][] matrixTranspose(double[][] A) {
		int column = A[0].length;
		double[][] transposed = new double[column][A.length];
		for (int i = 0; i < column; i++) {
			for (int j = 0; j < A.length; j++) {
				transposed[i][j] = A[j][i];
			}
		}
		return transposed;
	}

	public static double[][] matrixMultiplication(double[][] A, double[][] B) {
		double[][] C = new double[A.length][B[0].length];
		if (A[0].length != B.length) {
			throw new RuntimeException("Number of columns from A is different from the number of lines from B");
		}
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B[0].length; j++) {
				for (int a = 0; a < A[0].length; a++) {
					C[i][j] = (A[i][a] * B[a][j]) + C[i][j];
				}
			}
		}
		return C;
	}

	public static double[][] subMatrix(double[][] A, int i, int j) {
		int row = A.length - 1;
		int column = A[0].length - 1;
		double[][] S = new double[row][column];
		int si = 0;

		for (int a = 0; a < row + 1; a++) {
			if (a == i) {
				continue;
			}
			int sj = 0;
			for (int b = 0; b < column + 1; b++) {
				if (b == j) {
					continue;
				}
				S[si][sj] = A[a][b];
				sj++;
			}
			si++;
		}
		return S;
	}

	public static double matrixDeterminant(double[][] A) {
		if (A[0].length != A.length) {
			throw new RuntimeException("It is not a square matrix");
		}
		double result = 0;
		if (A.length == 1) {
			result = A[0][0];
			return result;
		}
		if (A.length == 2) {
			result = A[0][0] * A[1][1] - A[0][1] * A[1][0];
			return result;
		}
		for (int j = 0; j < A[0].length; j++) {
			result += A[0][j] * matrixCoFactor(A, 0, j);
		}
		return result;
	}

	public static double matrixCoFactor(double[][] A, int i, int j) {
		double[][] subMatrix = subMatrix(A, i, j);
		double matrixDeterminant = matrixDeterminant(subMatrix);
		return Math.pow(-1, i + j) * matrixDeterminant;
	}

	public static double[][] matrixCoFactor(double[][] A) {
		int row = A.length;
		int column = A[0].length;
		double[][] C = new double[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < A[0].length; j++) {
				C[i][j] = matrixCoFactor(A, i, j);
			}
		}
		return C;
	}

	public static double[][] matrixAdjugate(double[][] A) {
		if (A.length == 1) {
			if (A[0][0] == 0) {
				return A;
			} else {
				A[0][0] = 1;
				return A;
			}
		}
		return matrixTranspose(matrixCoFactor(A));
	}

	public static boolean matrixIsSingular(double[][] A) {
		if (matrixDeterminant(A) == 0) {
			return true;
		}
		return false;
	}

	public static double[][] matrixInverse(double[][] A) {
		if (matrixIsSingular(A) == true) {
			throw new RuntimeException("Matrix inverse does not exists if the determinant of the matrix is 0");

		}
		double matrixDeterminant = matrixDeterminant(A);
		double[][] matrixAdjugate = matrixAdjugate(A);
		return matrixMultiplication(1 / matrixDeterminant, matrixAdjugate);
	}
}
