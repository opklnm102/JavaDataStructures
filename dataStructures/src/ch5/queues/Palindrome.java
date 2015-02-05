package ch5.queues;

import ch3.stacks.ArrayStack;
import ch3.stacks.BoundedStackInterface;

public class Palindrome {
	public static boolean test(String candidate){
		//�ĺ��� ȸ���̸� ��, �ƴϸ� ������ ����
		char ch;  //ó���Ǵ� ���� �ĺ� ����
		int length;  //�ĺ� ��Ʈ���� ����
		int numLetters;  //�ĺ� ��Ʈ������ ���ĺ��� ����
		int charCount;  //���ݱ��� �˻�� ������ ��
		char fromStack;  //�������κ��� �˵� ���� ����
		char fromQueue;  //ť�κ��� ������ ���� ����
		boolean stillPalindrome;  //��Ʈ���� ȸ���� ���ɼ��� ������ ��
		BoundedStackInterface stack;  //������ �ƴ� ��Ʈ�� ���ڸ� ����
		BoundedQueueInterface queue;  //���� ������ �ƴ� ��Ʈ�� ���ڸ� ����
		
		//������ ������ �ʱ�ȭ
		length = candidate.length();
		stack = new ArrayStack(length);
		queue = new ArrayBndQueue(length);
		numLetters=0;
		
		//���ڸ� ��� ó��
		for(int i=0; i<length; i++){
			ch = candidate.charAt(i);
			if(Character.isLetter(ch)){
				numLetters++;
				ch = Character.toLowerCase(ch);
				stack.push(ch);
				queue.enqueue(ch);
			}				
		}
		
		//ȸ������ ����
		stillPalindrome=true;
		charCount=0;
		while(stillPalindrome && (charCount < numLetters)){
			fromStack = (Character)stack.top();
			stack.pop();
			fromQueue = (Character)queue.dequeue();
			if(fromStack != fromQueue)
				stillPalindrome = false;
			charCount++;
		}
		
		//return result
		return stillPalindrome;
	}
}
