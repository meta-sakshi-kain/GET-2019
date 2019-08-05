package question_1;
import java.util.List;
//Interface to implement operations on dictionary
public interface DictionaryInterface {
	//add data to dictionary
	public void addData(int key, String value);
	//remove data from dictionary
	public void removeData(int key);
	//get value for a given key
	public String getValue(int key);
	//list of sorted key list
	public List<DataEntry> getSortedList();
	//list of sorted list for a given key range
	public List<DataEntry> getSubSortedList(int k1, int k2);
	
}
