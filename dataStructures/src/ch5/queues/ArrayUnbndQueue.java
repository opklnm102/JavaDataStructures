package ch5.queues;

public class ArrayUnbndQueue implements UnboundedQueueInterface{
	protected final int defCap = 100;  //기본용량
	protected Object[] queue;  //큐 항목을 가지는 배열
	protected int origCap;  //원 용량
	protected int numElements = 0;  //큐에 있는 항목의 개수
	protected int front = 0;  //큐의 앞 지시자 색인
	protected int rear = -1;  //큐의 뒤 지시자 색인

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
		//큐의 용량을 원 용량 만큼 증가
		
		//더 큰 배열을 생성
		Object[] larger = new Object[queue.length+origCap];
		
		//작은 배열에서 큰 배열로 내용을 복사
		int currSmaller = front;
		for(int currLarger = 0; currLarger < numElements; currLarger++){
			larger[currLarger]=queue[currSmaller];
			currSmaller = (currSmaller + 1)%queue.length;
		}
		
		//인스턴스 변수를 수정
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
