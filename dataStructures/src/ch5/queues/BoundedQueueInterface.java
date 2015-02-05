package ch5.queues;

public interface BoundedQueueInterface extends QueueInterface {
	public void enqueue(Object element) throws QueueOverflowException;
	//큐가 포화이면 QueueOverflowException을 발생
	//그렇지 않으면 큐의 뒤에 항목을 추가
	public boolean isFull();
	//큐가 포화이면 참을 리턴, 아니면 거짓을 리턴
}
