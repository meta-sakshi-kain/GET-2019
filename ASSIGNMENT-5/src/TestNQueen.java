import static org.junit.Assert.*;

import org.junit.Test;


public class TestNQueen {

	@Test
	public void testWhenSolExist() {
		NQueen Queen = new NQueen(); 
		int dimensionOfMatrix = 4;
		int dimensionOfMatrix1 = 8;
		int [][] board = new int[dimensionOfMatrix][dimensionOfMatrix];
		assertTrue(Queen.nQueen(board,0,dimensionOfMatrix));
		int [][] board1 = new int[dimensionOfMatrix1][dimensionOfMatrix1];
		assertTrue(Queen.nQueen(board1,0,dimensionOfMatrix1));
		
	}
	@Test
	public void testWhenSolNotExist() {
		NQueen Queen = new NQueen(); 
		int dimensionOfMatrix = 3;
		int [][] board = new int[dimensionOfMatrix][dimensionOfMatrix];
		assertFalse(Queen.nQueen(board,0,dimensionOfMatrix));
	}
	
}
