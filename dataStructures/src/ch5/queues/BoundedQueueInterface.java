package ch5.queues;

public interface BoundedQueueInterface extends QueueInterface {
	public void enqueue(Object element) throws QueueOverflowException;
	//ť�� ��ȭ�̸� QueueOverflowException�� �߻�
	//�׷��� ������ ť�� �ڿ� �׸��� �߰�
	public boolean isFull();
	//ť�� ��ȭ�̸� ���� ����, �ƴϸ� ������ ����
}
