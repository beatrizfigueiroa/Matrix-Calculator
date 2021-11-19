package com.diegopinheiro.p2_02_listaMatrizes;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestList02CoFactor {

	@Test
	public void testElementCoFactor3by3() {
		double[][] A = { { 2, 1, 2 }, { -3, 4, 1 }, { 3, 2, 5 } };
		double expected = -1;
		double actual = List02.matrixCoFactor(A, 1, 2);
		assertEquals(expected, actual, 0.001);
	}

	@Test
	public void testMatrixCoFactor3by3() {
		double[][] A = { { -3, 2, 5 }, { -1, 0, -2 }, { 3, -4, 1 } };
		double[][] expected = { { -8, -5, 4 }, { -22, -18, -6 }, { -4, -11, 2 } };
		double[][] actual = List02.matrixCoFactor(A);
		for (int i = 0; i < expected.length; i++) {
			assertArrayEquals(expected[i], actual[i], 0.001);
		}
	}
}
