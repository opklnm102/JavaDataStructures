package ch4;

import support.LLObjectNode;
import ch3.stacks.LinkedStack;
//재귀를 이용한 역 프린팅
public class LinkedStack2 extends LinkedStack{
	private void revPrint(LLObjectNode listRef){
		if(listRef != null){
			revPrint(listRef.getLink());
			System.out.println(" " + listRef.getInfo());
		}
	}
	
	public void printReversed(){
		revPrint(top);
	}
}
