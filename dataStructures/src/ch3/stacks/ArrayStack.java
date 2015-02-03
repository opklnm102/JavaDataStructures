package ch3.stacks;

public class ArrayStack implements BoundedStackInterface {

	protected final int DEFCAP = 100; // �⺻�뷮
	protected Object[] stack; // ���� �׸��� ����
	protected int topIndex = -1; // ������ ����� �׸��� ����

	public ArrayStack() {
		stack = new Object[DEFCAP];
	}

	public ArrayStack(int maxSize) {
		stack = new Object[maxSize];
	}

	@Override
	public void pop() throws StackUnderflowException {
		if(!isEmpty()){
			stack[topIndex] = null;
			topIndex--;
		}
		else
			throw new StackUnderflowException("Pop attempted on an empty stack.");
	}

	@Override
	public Object top() throws StackUnderflowException {
		Object topOfStack = null;
		if(!isEmpty())
			topOfStack = stack[topIndex];
		else
			throw new StackUnderflowException("Top attempted on an empty stack.");
		return topOfStack;
	}

	@Override
	public boolean isEmpty() {
		if (topIndex == -1)
			return true;
		else
			return false;
	}

	@Override
	public void push(Object element) throws StackOverflowException {
		if(!isFull()){
			topIndex++;
			stack[topIndex] = element;
		}
		else
			throw new StackOverflowException("Push attempted on a full stack.");
		}

	@Override
	public boolean isFull() {
		if (topIndex == (stack.length - 1))
			return true;
		else
			return false;
	}
}
