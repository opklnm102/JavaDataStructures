package ch5.queues;

public class ArrayBndQueue implements BoundedQueueInterface {
	protected final int DEFCAP = 100;  //�⺻�뷮
	protected Object[] queue;  //ť �׸��� �����ϴ� �迭
	protected int numElements=0;  //ť�� �ִ� �׸��� ����
	protected int front=0;  //ť�� �� ������ ����
	protected int rear;  //ť�� �� ������ ����

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
