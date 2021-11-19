package com.diegopinheiro.p2_02_listaMatrizes;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TestList02Inverse {

	@Test
	public void testMatrixInverseIdentity2by2() {
		double[][] A = { { 1, 0 }, { 0, 1 } };
		double[][] expected = A;
		double[][] actual = List02.matrixInverse(A);
		for (int i = 0; i < expected.length; i++) {
			assertArrayEquals(expected[i], actual[i], 0.0001);
		}
	}

	@Test
	public void testMatrixInverse1by1() {
		double[][] A = { { 1, 0 }, { 0, 1 } };
		double[][] expected = A;
		double[][] actual = List02.matrixInverse(A);
		for (int i = 0; i < expected.length; i++) {
			assertArrayEquals(expected[i], actual[i], 0.0001);
		}
	}

	@Test
	public void testSingularMatrix2by2() {
		double[][] A = { { -1, (double) 3 / 2 }, { (double) 2 / 3, -1 } };
		try {
			double[][] actual = List02.matrixInverse(A);
			fail("Matrix is singular but returned " + actual);
		} catch (Exception e) {
		}
	}

	@Test
	/***
	 * The adjugate is the determinant times the inverse
	 */
	public void testMatrixInverse3by3() {
		double[][] A = { { -3, 2, 5 }, { -1, 0, -2 }, { 3, -4, 1 } };
		double det = List02.matrixDeterminant(A);
		double[][] inverse = List02.matrixInverse(A);
		double[][] expected = List02.matrixMultiplication(det, inverse);
		double[][] actual = List02.matrixAdjugate(A);
		for (int i = 0; i < expected.length; i++) {
			assertArrayEquals(expected[i], actual[i], 0.0001);
		}
	}
}
