import static org.junit.Assert.*;

import org.junit.Test;

public class TestNQueen {

@Test
public void testWhenSolExist() {
	NQueen Queen = new NQueen(); 
	int dimensionOfMatrix = 4;
	int dimensionOfMatrix1 = 8;
	int dimensionOfMatrix2 = 16;
	int [][] board = new int[dimensionOfMatrix][dimensionOfMatrix];
	assertTrue(Queen.nQueen(board,0,dimensionOfMatrix));
	System.out.println();
	int [][] board1 = new int[dimensionOfMatrix1][dimensionOfMatrix1];
	assertTrue(Queen.nQueen(board1,0,dimensionOfMatrix1));
	System.out.println();
	int [][] board2 = new int[dimensionOfMatrix2][dimensionOfMatrix2];
	assertTrue(Queen.nQueen(board2,0,dimensionOfMatrix2));

}
@Test
public void testWhenSolNotExist() {
	NQueen Queen = new NQueen(); 
	int dimensionOfMatrix = 3;
	int [][] board = new int[dimensionOfMatrix][dimensionOfMatrix];
	assertFalse(Queen.nQueen(board,0,dimensionOfMatrix));
}

}

