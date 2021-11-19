package com.diegopinheiro.p2_02_listaMatrizes;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class TestList02Adjugate {

	@Test
	public void test01MatrixAdjugateZero1by1() {

		double[][] A = { { 0 } };
		double[][] expected = { { 0 } };
		double[][] actual = List02.matrixAdjugate(A);
		for (int i = 0; i < expected.length; i++) {
			assertArrayEquals(expected[i], actual[i], 0.0001);
		}
	}

	@Test
	public void test02MatrixAdjugateOne1by1() {
		double[][] A = { { 2 } };
		double[][] expected = { { 1 } };
		double[][] actual = List02.matrixAdjugate(A);
		for (int i = 0; i < expected.length; i++) {
			assertArrayEquals(expected[i], actual[i], 0.0001);
		}
	}

	@Test
	public void test03MatrixAdjugate2by2() {
		double[][] A = { { 1, 2 }, { 3, 4 } };
		double[][] expected = { { 4, -2 }, { -3, 1 } };
		double[][] actual = List02.matrixAdjugate(A);
		for (int i = 0; i < expected.length; i++) {
			assertArrayEquals(expected[i], actual[i], 0.0001);
		}
	}

	@Test
	public void test04MatrixAdjugate3by3() {
		double[][] A = { { -3, 2, 5 }, { -1, 0, -2 }, { 3, -4, 1 } };
		double[][] expected = { { -8, -22, -4 }, { -5, -18, -11 }, { 4, -6, 2 } };
		double[][] actual = List02.matrixAdjugate(A);
		for (int i = 0; i < expected.length; i++) {
			assertArrayEquals(expected[i], actual[i], 0.0001);
		}
	}
}
