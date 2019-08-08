package question_1;
//class for data and corresponding key in dictionary
public class DataEntry {
	private int key;
	private String value;
	//constructor
	public DataEntry(int key, String value) {
		this.key = key;
		this.value = value;
	}
	//get the key value 
	public int getKey() {
		return key;
	}
	//get the value corresponding to a key
	public String getValue() {
		return value;
	}
	//set key for an object
	public void setKey(int key) {
		this.key = key;
	}
	//set value corresponding to a key value
	public void setValue(String value) {
		this.value = value;
	}
	
}
