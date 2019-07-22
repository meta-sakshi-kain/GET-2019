import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class TestSparseMatrix {

    @Test
    void transposeTest() {
       assertArrayEquals(new int[][] {{1,3},{2,4}},new SparseMatrix(new int[][]{{1,2},{3,4}}).transpose());
       assertArrayEquals(new int[][] {{6,3,1},{2,10,5}},new SparseMatrix(new int[][]{{6,2},{3,10},{1,5}}).transpose());
    }
    
    @Test
    void symmetricalTest() {
        assertTrue(new SparseMatrix(new int[][]{{1,2},{2,1}}).isSymmetrical());
        assertFalse(new SparseMatrix(new int[][]{{1,3},{2,1}}).isSymmetrical());
    }
    
    @Test
    void addMatrixTest() {
        assertArrayEquals(new int[][] {{1,3},{2,4}},new SparseMatrix(new int[][]{{0,2},{1,2}}).addMatrix(new SparseMatrix(new int[][]{{1,1},{1,2}})));
        assertArrayEquals(new int[][] {{2,4,6},{2,3,4}},new SparseMatrix(new int[][]{{1,2,3},{1,2,3}}).addMatrix(new SparseMatrix(new int[][]{{1,2,3},{1,1,1}})));
    }
    
    @Test
    void multiplyMatrixTest() {
        assertArrayEquals(new int[][] {{2,4},{3,5}},new SparseMatrix(new int[][]{{0,2},{1,2}}).multiplyMatrix(new SparseMatrix(new int[][]{{1,1},{1,2}})));
        assertArrayEquals(new int[][] {{7,11}},new SparseMatrix(new int[][]{{3,4}}).multiplyMatrix(new SparseMatrix(new int[][]{{1,1},{1,2}})));
    }

}
