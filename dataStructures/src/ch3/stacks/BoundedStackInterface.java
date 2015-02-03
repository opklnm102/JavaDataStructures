package ch3.stacks;
//제한있는 스택
public interface BoundedStackInterface extends StackInterface{
	
	void push(Object element) throws StackOverflowException;
	//스택이 포화이면 stackOverflowException을 발생시킴
	//그렇지 않으면 스택의 꼭대기에 항목을 위치시킨다.
	
	boolean isFull();
	//스택에 포화이면 참, 아니면 거짓
}
