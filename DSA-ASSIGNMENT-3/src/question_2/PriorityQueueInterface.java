package question_2;
//Priority queue interface
public interface PriorityQueueInterface {
    //add item to queue
	public void enqueueItem(Item item);
	//delete item from queue
	public void dequeueItem();
	//check if queue is full
	public boolean isQueueFull();
	//check if queue is empty
	public boolean isQueueEmpty();
	
}
