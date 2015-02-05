package ch5.queues;

public interface UnboundedQueueInterface extends QueueInterface{
	public void enqueue(Object element);
	//그렇지 않으면 뒤에 항목을 추가
}
