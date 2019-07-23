import static org.junit.Assert.*;

import org.junit.Test;
public class TestSparseMatrix {

//Test case to check the transpose of a matrix	
@Test
public void transposeTest() {
	assertArrayEquals(new int[][] {{1,0,0,9,6},{0,0,0,2,4},{0,0,5,0,0}},new SparseMatrix(new int[][]{{1,0,0},{0,0,0},{0,0,5},{9,2,0},{6,4,0}}).transpose());
	assertArrayEquals(new int[][] {{6,0,0,1},{0,3,0,0}},new SparseMatrix(new int[][]{{6,0},{0,3},{0,0},{1,0}}).transpose());
}

//Test case to check that the matrices are symmetrical or not
@Test
public void symmetricalTest() {
	assertTrue(new SparseMatrix(new int[][]{{0,1,0,},{1,0,0},{0,0,1}}).isSymmetrical());
	assertFalse(new SparseMatrix(new int[][]{{1,3,0,2,0},{3,0,0,2,0},{0,0,0,0,0},{2,2,0,0,1},{1,0,0,1,1}}).isSymmetrical());
}

//Test case to check to add two sparse matrices
@Test
public void addMatrixTest() {
	assertArrayEquals(new int[][] {{1,3},{2,4}},new SparseMatrix(new int[][]{{0,2},{1,2}}).addMatrix(new SparseMatrix(new int[][]{{1,1},{1,2}})));
	assertArrayEquals(new int[][] {{2,4,6},{2,3,4}},new SparseMatrix(new int[][]{{1,2,3},{1,2,3}}).addMatrix(new SparseMatrix(new int[][]{{1,2,3},{1,1,1}})));
}

//Test case to check the multiplication of two matrices
@Test
public void multiplyMatrixTest() {
    assertArrayEquals(new int[][] {{2,4},{3,5}},new SparseMatrix(new int[][]{{0,2},{1,2}}).multiplyMatrix(new SparseMatrix(new int[][]{{1,1},{1,2}})));
	assertArrayEquals(new int[][] {{7,11}},new SparseMatrix(new int[][]{{3,4}}).multiplyMatrix(new SparseMatrix(new int[][]{{1,1},{1,2}})));
}
}
