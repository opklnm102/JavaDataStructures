package ch3.stacks;
//�����ִ� ����
public interface BoundedStackInterface extends StackInterface{
	
	void push(Object element) throws StackOverflowException;
	//������ ��ȭ�̸� stackOverflowException�� �߻���Ŵ
	//�׷��� ������ ������ ����⿡ �׸��� ��ġ��Ų��.
	
	boolean isFull();
	//���ÿ� ��ȭ�̸� ��, �ƴϸ� ����
}
