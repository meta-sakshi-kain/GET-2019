package question_1;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import question_1.DataEntry;
import question_1.Dictionary;

public class DictionaryTest {

	@Test
	public void sortingTest() {
			Dictionary d = new Dictionary("file.json");
		List<DataEntry> list = new ArrayList<DataEntry>();
		d.addData(33, "huma");
		d.addData(33, "huma");
		list = d.getSortedList();
		assertEquals("piyush",d.getValue(1));
		}
	}
	@Test
	public void getValueTest() {
		Dictionary d = new Dictionary("file.json");
		assertEquals("vrinda",d.getValue(6));
	}
	@Test
	public void keyNotFoundTest() {
		Dictionary d = new Dictionary("file.json");
		assertEquals("key not found",d.getValue(277));
	}
	
}
