package ch5.queues;

public class ArrayUnbndQueue implements UnboundedQueueInterface{
	protected final int defCap = 100;  //�⺻�뷮
	protected Object[] queue;  //ť �׸��� ������ �迭
	protected int origCap;  //�� �뷮
	protected int numElements = 0;  //ť�� �ִ� �׸��� ����
	protected int front = 0;  //ť�� �� ������ ����
	protected int rear = -1;  //ť�� �� ������ ����

	public ArrayUnbndQueue(){
		queue = new Object[defCap];
		rear=defCap-1;
		origCap=defCap;
	}
	
	public ArrayUnbndQueue(int origCap){
		queue = new Object[origCap];
		rear = origCap-1;
		this.origCap = origCap;
	}
	
	private void enlarge(){
		//ť�� �뷮�� �� �뷮 ��ŭ ����
		
		//�� ū �迭�� ����
		Object[] larger = new Object[queue.length+origCap];
		
		//���� �迭���� ū �迭�� ������ ����
		int currSmaller = front;
		for(int currLarger = 0; currLarger < numElements; currLarger++){
			larger[currLarger]=queue[currSmaller];
			currSmaller = (currSmaller + 1)%queue.length;
		}
		
		//�ν��Ͻ� ������ ����
		queue = larger;
		front=0;
		rear = numElements-1;
	}	

	@Override
	public Object dequeue() throws QueueUnderflowException {
		if(isEmpty())
			throw new QueueUnderflowException("Dequeue attempted on empty queue.");
		else{
			Object toReturn = queue[front];
			queue[front]=null;
			front=(front+1)%queue.length;
			numElements = numElements-1;
			return toReturn;
		}
	}

	@Override
	public boolean isEmpty() {
		return (numElements == 0);
	}

	@Override
	public void enqueue(Object element) {
		if(numElements == queue.length)
			enlarge();
		rear=(rear+1)%queue.length;
		queue[rear] = element;
		numElements = numElements+1;		
	}
}
