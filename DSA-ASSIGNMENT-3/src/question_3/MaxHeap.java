package question_3;
//maxHeap implementation 
public class MaxHeap {

	private Bowler[] Heap;
	private int size;

	public MaxHeap(int maxsize) {
		Heap = new Bowler[maxsize + 1];
		size = 0;
		Heap[0] = new Bowler("captain", Integer.MAX_VALUE);
	}

	// returns position of parent
	private int parent(int pos) {
		return pos / 2;
	}

	// two functions return left and right children.
	private int leftChild(int pos) {
		return (2 * pos);
	}

	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}

	// returns true if given node is leaf
	private boolean isLeaf(int pos) {
		if (pos > (size / 2) && pos <= size)
			return true;
		return false;
	}

	private void swap(int fpos, int spos) {
		Bowler tmp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}

	// A recursive function for maintain max heap
	private void maxHeapify(int pos) {
		if (isLeaf(pos))
			return;
		if ((Heap[pos].getNoOfballs() < Heap[leftChild(pos)].getNoOfballs()) || (Heap[pos].getNoOfballs() < Heap[rightChild(pos)].getNoOfballs())) {
			if (Heap[leftChild(pos)].getNoOfballs() > Heap[rightChild(pos)].getNoOfballs()) {
				swap(pos, leftChild(pos));
				maxHeapify(leftChild(pos));
			} else {
				swap(pos, rightChild(pos));
				maxHeapify(rightChild(pos));
			}
		}
	}

	// Inserts a new bowler to max heap
	public void insert(Bowler bowler) {
		Heap[++size] = bowler;
		int current = size;
		while (Heap[current].getNoOfballs() > Heap[parent(current)].getNoOfballs()) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	// Remove an bowler from max heap
	public Bowler extractMax() {
		Bowler bowler = Heap[1];
		Heap[1] = Heap[size--];
		maxHeapify(1);
		return bowler;
	}
}
