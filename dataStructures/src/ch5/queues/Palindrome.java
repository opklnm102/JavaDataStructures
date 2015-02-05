package ch5.queues;

import ch3.stacks.ArrayStack;
import ch3.stacks.BoundedStackInterface;

public class Palindrome {
	public static boolean test(String candidate){
		//후보가 회문이면 참, 아니면 거짓을 리턴
		char ch;  //처리되는 현재 후보 문자
		int length;  //후보 스트링의 길이
		int numLetters;  //후보 스트링에서 알파벳의 길이
		int charCount;  //지금까지 검사된 문자의 수
		char fromStack;  //스택으로부터 팝된 현재 문자
		char fromQueue;  //큐로부터 삭제된 현재 문자
		boolean stillPalindrome;  //스트링이 회문일 가능성이 있으면 참
		BoundedStackInterface stack;  //공백이 아닌 스트링 문자를 저장
		BoundedQueueInterface queue;  //역시 공백이 아닌 스트링 문자를 저장
		
		//변수와 구조를 초기화
		length = candidate.length();
		stack = new ArrayStack(length);
		queue = new ArrayBndQueue(length);
		numLetters=0;
		
		//문자를 얻고 처리
		for(int i=0; i<length; i++){
			ch = candidate.charAt(i);
			if(Character.isLetter(ch)){
				numLetters++;
				ch = Character.toLowerCase(ch);
				stack.push(ch);
				queue.enqueue(ch);
			}				
		}
		
		//회문인지 결정
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
