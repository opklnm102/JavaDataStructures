package ch5.queues;

public interface QueueInterface {
	public Object dequeue() throws QueueUnderflowException;
	//ť�� �����̸� QueueUnderflowException�� ����
	//�׷��� ������ ť�κ��� �� �׸��� �����ϰ� �׸��� ������
	public boolean isEmpty();
	//ť�� �����̸� ���� ����, �׷��� ������ ������ ����
}
