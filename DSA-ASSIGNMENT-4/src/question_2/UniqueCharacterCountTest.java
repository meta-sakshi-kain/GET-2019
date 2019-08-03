package question_2;

import static org.junit.Assert.*;

import org.junit.Test;
//test class to check unique characters in string
public class UniqueCharacterCountTest {

	//test case to check unique characters in string
	@Test
	public void countUniqueCharactersTest() {
		UniqueCharacterCount obj = new UniqueCharacterCount();
		assertEquals(2, obj.countUniqueCharacters("sakshiKain"));
		assertEquals(2, obj.countUniqueCharacters("dikshakain"));
		assertEquals(8, obj.countUniqueCharacters("piyushkain"));
	}

}
