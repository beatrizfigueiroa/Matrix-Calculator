package com.diegopinheiro.p2_02_listaMatrizes;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TestList02MatrixMultiplication {

	@Test
	public void testColumnADifferentLinesB() {
		double[][] A = { { 1 }, { 1 } };
		double[][] B = { { 1, 0 }, { 0, 1 } };

		try {
			double[][] actual = List02.matrixMultiplication(A, B);
			fail("Número de colunas de A diferente do numéro de linhas de B mas retornou " + actual);
		} catch (Exception e) {

		}
	}

	@Test
	public void testElementIdentity2by2() {
		double a = 2;
		double[][] A = { { 1, 0 }, { 0, 1 } };
		double[][] expected = { { 2, 0 }, { 0, 2 } };
		double[][] actual = List02.matrixMultiplication(a, A);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testMatrixIdentity2by2() {
		double[][] A = { { 1, 0 }, { 0, 1 } };
		double[][] B = { { 1, 0 }, { 0, 1 } };
		double[][] expected = { { 1, 0 }, { 0, 1 } };
		double[][] actual = List02.matrixMultiplication(A, B);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testMatrixIdentity3by3() {
		double[][] A = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
		double[][] B = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
		double[][] expected = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
		double[][] actual = List02.matrixMultiplication(A, B);
		assertArrayEquals(expected, actual);
	}

}
