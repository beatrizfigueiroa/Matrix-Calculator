package com.diegopinheiro.p2_02_listaMatrizes;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class TestList02MatrixSubMatrix {
	@Test
	public void testIdentity2by2() {
		double[][] A = { { 1, 0 }, { 0, 1 } };
		double[][] expected = { { 1 } };
		double[][] actual = List02.subMatrix(A, 1, 1);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void test3by3() {
		double[][] A = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		double[][] expected = { { 1, 2 }, { 7, 8 } };
		double[][] actual = List02.subMatrix(A, 1, 2);
		assertArrayEquals(expected, actual);
	}
}
