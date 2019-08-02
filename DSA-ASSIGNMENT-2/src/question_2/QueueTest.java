package question_2;

import static org.junit.Assert.*;
import org.junit.Test;
//test class for operations on queue 
public class QueueTest {

	@Test
	public void queueTest() {
		Queue queue = new Queue(5);
		assertTrue(queue.isQueueEmpty());
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		assertTrue(queue.isQueueFull());
		queue.dequeue();
		queue.dequeue();
		queue.print();
		assertFalse(queue.isQueueFull());
		assertFalse(queue.isQueueEmpty());
	}

}
