package com.diegopinheiro.p2_02_listaMatrizes;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class TestList02MatrixTranspose {

	@Test
	public void testTransposeIdentity() {
		double[][] a = { { 1, 0 }, { 0, 1 } };

		double[][] expected = { { 1, 0 }, { 0, 1 } };
		double[][] actual = List02.matrixTranspose(a);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testTranspose3by3() {
		double[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		double[][] expected = { { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 } };
		double[][] actual = List02.matrixTranspose(a);

		assertArrayEquals(expected, actual);
	}
}
