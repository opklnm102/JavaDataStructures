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
				//피연산자를 처리
				value = tokenizer.nextInt();
				if(stack.isFull())
					throw new PostFixException("Too many operands - stack overflow");
				stack.push(value);
			}
			else{
				//연산자를 처리
				operator = tokenizer.next();
				
				//스택으로부터 두번째 피연산자를 얻음
				if(stack.isEmpty())
					throw new PostFixException("Not enough operands - stack underflow");
				operand2=(Integer)stack.top();
				stack.pop();
				
				//스택으로부터 첫번째 피연산자를 얻음
				if(stack.isEmpty())
					throw new PostFixException("Not enough operands - stack underflow");
				
				operand1=(Integer)stack.top();
				stack.pop();
				
				//연산을 수행함
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
				//스택에 연산의 결과를 삽입
				stack.push(result);						
			}
		}
		
		//스택으로부터 최종결과를 얻음
		if(stack.isEmpty())
			throw new PostFixException("Not enough operands - stack underflow");
		result = (Integer)stack.top();
		stack.pop();
		//스택을 이제 공백이어야함
		if(!stack.isEmpty())
			throw new PostFixException("Too many operands - operands left over");
		
		//최종결과를 복귀
		return result;
	}
}
