package question_1;
//stack interface
public interface Stack {
	//add element to stack
	public void push(String data);
	//delete element from stack
	public String pop();
	//check if stack is empty, if empty return true 
	public boolean isEmpty();
	//check the element at top of queue
	public String peek();
}
