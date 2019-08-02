package question_2;
//Queue interface
public interface QueueInterface {
	//enqueue data to the queue
	public void enqueue(int data);
	//delete data from queue
	public void dequeue();
	//check if queue is full or not if full returns true
	public boolean isQueueFull();
	//check if queue is empty or not if empty returns true
	public boolean isQueueEmpty();
	//print the queue
	public void print();

}
