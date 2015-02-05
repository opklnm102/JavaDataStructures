package ch5.queues;

public class ArrayBndQueue implements BoundedQueueInterface {
	protected final int DEFCAP = 100;  //기본용량
	protected Object[] queue;  //큐 항목을 보유하는 배열
	protected int numElements=0;  //큐에 있는 항목의 개수
	protected int front=0;  //큐의 앞 지시자 색인
	protected int rear;  //큐의 뒤 지시자 색인

	public ArrayBndQueue(){
		queue = new Object[DEFCAP];
		rear = DEFCAP-1;		
	}
	
	public ArrayBndQueue(int maxSize){
		queue = new Object[maxSize];
		rear = maxSize-1;
	}

	@Override
	public Object dequeue() throws QueueUnderflowException {
		if(isEmpty())
			throw new QueueUnderflowException("Dequeue attempted on empty queue.");
		else{
			Object toReturn = queue[front];
			queue[front] = null;
			front = (front+1)%queue.length;
			numElements = numElements - 1;
			return toReturn;
		}
	}

	@Override
	public boolean isEmpty() {
		return (numElements == 0);
	}

	@Override
	public void enqueue(Object element) throws QueueOverflowException {
		if(isFull())
			throw new QueueOverflowException("Enqueue attempted on a full.");
		else{
			rear = (rear+1)%queue.length;
			queue[rear] = element;
			numElements = numElements + 1;
		}		
	}

	@Override
	public boolean isFull() {
		return (numElements == queue.length);
	}
}
