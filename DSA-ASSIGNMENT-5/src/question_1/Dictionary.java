package question_1;
import java.io.FileReader;
import java.util.List;
import java.util.Set;
import java.lang.Exception;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
//class for dictionary implementation using a binary tree
public class Dictionary implements DictionaryInterface{
	
	BinaryTree tree = new BinaryTree();
	//constructor
		public Dictionary(String fileName)  {
			try {
				JSONObject rootJSON = (JSONObject) new JSONParser().parse(new FileReader(fileName));
				@SuppressWarnings("unchecked")
				Set<String> keys = rootJSON.keySet();
				for (String i : keys) {
					DataEntry dataEntry = new DataEntry(Integer.parseInt(i), rootJSON.get(i).toString());
					tree.insert(dataEntry);
				}
			} 
			catch (Exception ex) {
				throw new AssertionError("file not found");
			}
		}
	//method to add data to dictionary
	@Override
	public void addData(int key,String value) {
		DataEntry dataEntry = new DataEntry(key, value);
		tree.insert(dataEntry);
	}
	//method to remove data by key value
	@Override
	public void removeData(int key) {
		tree.deleteKey(key);
	}
	//get the value by key
	@Override
	public String getValue(int key) {
		return tree.searchKey(tree.root, key);
	}
	//sort the binary tree
	@Override
	public List<DataEntry> getSortedList() {
		return tree.sortDictionary();
	}
    //get sorted list in given key range
	@Override
	public  List<DataEntry> getSubSortedList(int k1, int k2){
		return tree.sortSubDictionary(k1, k2);
	}
}