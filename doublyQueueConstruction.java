package assign2;

public class doublyQueueConstruction {
	
	static class doublyQueue{
		private int front;
		private int rear;
		private int[] nums;
		private int size;
		
		public doublyQueue(int size){
			nums = new int[size];
			front = -1;
			rear = 0;
			this.size = size;
		}
		
		public boolean isFull() {
			return ((front == rear + 1) || (front == 0 && rear == size - 1));
		}
		
		public boolean isEmpty() {
			return (front == -1);
		}
		
		public void insertFront(int element) {
			if(isFull()) {
				System.out.println("queue overflow!");
				return;
			}
			//if queue is initially empty.
			if(front == -1) {
				front = 0;
				rear = 0;
			}
			//if front is at the first position of the queue
			else if(front == 0) {
				front = size - 1;
			}
			else {
				front -= 1;
			}
			nums[front] = element;
		}
		
		public void insertRear(int element) {
			if(isFull()) {
				System.out.println("queue overflow!");
				return;
			}
			//if queue is initially empty.
			if(front == -1) {
				front = 0;
				rear = 0;
			}
			//if rear is at the last location of the queue
			else if(rear == size - 1) {
				rear = 0;
			}
			else {
				rear += 1;
			}
			nums[rear] = element;
		}
		
		public void deleteFront() {
			if(isEmpty()) {
				System.out.println("queue underflow!");
				return;
			}
			//if queue has only one element.
			if(front == rear) {
				front = -1;
				rear = -1;
			}
			//if front is at the last index of the queue, we set it to 0.
			else if(front == size - 1) {
				front = 0;
			}
			else {
				front += 1;
			}
		}
		
		public void deleteRear() {
			if(isEmpty()) {
				System.out.println("queue underflow!");
				return;
			}
			//if queue has only one element.
			if(front == rear) {
				front = -1;
				rear = -1;
			}
			//if rear is at the 0th index, we set it to the size - 1 position.
			else if(rear == 0) {
				rear = size - 1;
			}
			else {
				rear -= 1;
			}
		}
		
		public int getFront() {
			if(isEmpty()) {
				System.out.println("queue underflow!");
				return -1;
			}
			return nums[front];
		}
		
		public int getRear() {
			if(isEmpty()) {
				System.out.println("queue underflow!");
				return -1;
			}
			return nums[rear];
		}
	}
	
	public static void main(String[] args) {
		doublyQueue dq = new doublyQueue(5);
		dq.insertFront(1);
		dq.insertFront(2);
		dq.insertFront(3);
		dq.insertFront(4);
		dq.insertFront(5);
		dq.deleteRear();
		dq.deleteRear();
		dq.deleteRear();
		dq.deleteRear();
		dq.deleteRear();
	}

}
