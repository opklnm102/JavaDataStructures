package ch5.queues;

public class GlassQueue extends ArrayUnbndQueue{
	
	public GlassQueue(){
		super();
	}
	
	public GlassQueue(int origCap){
		super(origCap);
	}
	
	public int size(){
		return numElements;
	}
	
	public Object peekFront(){
		//�տ� �ִ� ��ü�� ����
		return queue[front];
	}
	
	public Object peekRear(){
		//ť�� �ڿ� �ִ� ��ü�� ����
		return queue[rear];
	}
}
