package com.diegopinheiro.p2_02_listaMatrizes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TestList02Determinant {

	@Test
	public void testNotSquared() {
		double[][] A = { { 1, 0, 0 }, { 0, 1, 0 } };
		try {
			double actual = List02.matrixDeterminant(A);
			fail("Matrix not squared but returned " + actual);
		} catch (Exception e) {

		}
	}

	@Test
	public void testIdentity() {
		double[][] A = { { 1, 0 }, { 0, 1 } };
		double expected = 1;
		double actual = List02.matrixDeterminant(A);
		assertEquals(expected, actual, 0.0001);
	}

	@Test
	public void testNonZero2by2() {
		double[][] A = { { -1, (double) 3 / 2 }, { (double) 1, -1 } };

		double expected = (double) -1 / 2;
		double actual = List02.matrixDeterminant(A);
		assertEquals(expected, actual, 0.0001);
	}

	@Test
	public void testZero2by2() {
		double[][] A = { { -1, (double) 3 / 2 }, { (double) 2 / 3, -1 } };

		double expected = 0;
		double actual = List02.matrixDeterminant(A);
		assertEquals(expected, actual, 0.0001);
	}

	@Test
	public void test3by3() {
		double[][] A = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		double expected = 0;
		double actual = List02.matrixDeterminant(A);
		assertEquals(expected, actual, 0.0001);
	}

	@Test
	public void test4by4() {
		double[][] A = { { 4, 5, -3, 0 }, { 2, -1, 3, 1 }, { 1, -3, 2, 1 }, { 0, 2, -2, 5 } };
		double expected = 210;
		double actual = List02.matrixDeterminant(A);
		assertEquals(expected, actual, 0.0001);
	}
}
