public class Category {
	private String name;
	private int no_of_children;
	
	public Category(String name, int no_of_children) {
		this.name = name;
		this.no_of_children = no_of_children;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNo_of_children() {
		return no_of_children;
	}
	public void setNo_of_children(int no_of_children) {
		this.no_of_children = no_of_children;
	}

}
