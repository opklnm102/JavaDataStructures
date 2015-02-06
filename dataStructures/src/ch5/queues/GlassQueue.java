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
		//앞에 있는 객체를 리턴
		return queue[front];
	}
	
	public Object peekRear(){
		//큐의 뒤에 있는 객체를 리턴
		return queue[rear];
	}
}
