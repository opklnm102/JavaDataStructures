package ch5.queues;

public interface QueueInterface {
	public Object dequeue() throws QueueUnderflowException;
	//큐가 공백이면 QueueUnderflowException을 던딤
	//그렇지 않으면 큐로부터 앞 항목을 제거하고 항목을 리턴함
	public boolean isEmpty();
	//큐가 공백이면 참을 리턴, 그렇지 않으면 거짓을 리턴
}
