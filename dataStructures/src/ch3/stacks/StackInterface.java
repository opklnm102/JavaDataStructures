package ch3.stacks;

public interface StackInterface {

	void pop() throws StackUnderflowException;
	//스택이 공백이면 StackUnderflowException을 발생
	//그렇지 않으면 스택의 꼭대기 항목을 삭제함
	
	Object top() throws StackUnderflowException;
	//스택이 공백이면 StackUnderflowException을 발생
	//그렇지 않으면 스택으로부터 꼭대기 항목을 복귀함.
	
	boolean isEmpty();
	//스택이 공백이면 참을, 그렇지 않으면 거짓을 복귀함.
}
