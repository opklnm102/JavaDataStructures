package ch3.stacks;

public interface StackInterface {

	void pop() throws StackUnderflowException;
	//������ �����̸� StackUnderflowException�� �߻�
	//�׷��� ������ ������ ����� �׸��� ������
	
	Object top() throws StackUnderflowException;
	//������ �����̸� StackUnderflowException�� �߻�
	//�׷��� ������ �������κ��� ����� �׸��� ������.
	
	boolean isEmpty();
	//������ �����̸� ����, �׷��� ������ ������ ������.
}
