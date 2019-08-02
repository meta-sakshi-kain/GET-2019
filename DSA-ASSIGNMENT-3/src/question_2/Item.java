package question_2;
//class item for storing item no and its priority
public class Item {
	int item;
	int priority;
	public Item(int item, int priority) {
		super();
		this.item = item;
		this.priority = priority;
	}
	public void setItem(int item) {
		this.item = item;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getItem() {
		return item;
	}
	public int getPriority() {
		return priority;
	}
}
