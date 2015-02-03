package ch3.stacks;
//제한없는 스택
public interface UnboundedStackInterface extends StackInterface{
	
	void push(Object element);
	//스택의 꼭대기에 항목을 위치시킴
}
