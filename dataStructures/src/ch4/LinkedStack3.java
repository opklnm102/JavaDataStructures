package ch4;

import support.LLObjectNode;
import ch3.stacks.LinkedStack;
import ch3.stacks.UnboundedStackInterface;

//������ �̿��� �� ������
public class LinkedStack3 extends LinkedStack{
	public void printReversed(){
		UnboundedStackInterface stack = new LinkedStack();
		LLObjectNode listNode;
		Object object;
		listNode = top;
		while(listNode != null){ //�������� ���ÿ� ����
			stack.push(listNode.getInfo());
			listNode = listNode.getLink();			
		}
		//���ÿ� ���� ������ �������� ã�Ƽ� �׸��� ����Ʈ
		while(!stack.isEmpty()){
			System.out.println(" " + stack.top());
			stack.pop();
		}
	}
}