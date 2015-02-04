package ch3.postfix;

import java.util.Scanner;

import ch3.stacks.ArrayStack;
import ch3.stacks.BoundedStackInterface;

public class PostFixEvaluator {
	public static int evaluate(String expression){
		BoundedStackInterface stack = new ArrayStack(50);
		
		int value;
		String operator;
		int operand1;
		int operand2;
		
		int result=0;
		
		Scanner tokenizer = new Scanner(expression);
		
		while(tokenizer.hasNext()){
			if(tokenizer.hasNextInt()){
				//�ǿ����ڸ� ó��
				value = tokenizer.nextInt();
				if(stack.isFull())
					throw new PostFixException("Too many operands - stack overflow");
				stack.push(value);
			}
			else{
				//�����ڸ� ó��
				operator = tokenizer.next();
				
				//�������κ��� �ι�° �ǿ����ڸ� ����
				if(stack.isEmpty())
					throw new PostFixException("Not enough operands - stack underflow");
				operand2=(Integer)stack.top();
				stack.pop();
				
				//�������κ��� ù��° �ǿ����ڸ� ����
				if(stack.isEmpty())
					throw new PostFixException("Not enough operands - stack underflow");
				
				operand1=(Integer)stack.top();
				stack.pop();
				
				//������ ������
				if(operator.equals("/"))
					result = operand1/operand2;
				else if(operator.equals("*"))
						result = operand1*operand2;
				else if(operator.equals("+"))
					result = operand1+operand2;
				else if(operator.equals("-"))
					result = operand1-operand2;
				else
					throw new PostFixException("Illegal symbol: "+operator);
				//���ÿ� ������ ����� ����
				stack.push(result);						
			}
		}
		
		//�������κ��� ��������� ����
		if(stack.isEmpty())
			throw new PostFixException("Not enough operands - stack underflow");
		result = (Integer)stack.top();
		stack.pop();
		//������ ���� �����̾����
		if(!stack.isEmpty())
			throw new PostFixException("Too many operands - operands left over");
		
		//��������� ����
		return result;
	}
}
