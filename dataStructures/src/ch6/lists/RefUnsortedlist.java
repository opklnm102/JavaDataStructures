package ch6.lists;

import support.LLObjectNode;

public class RefUnsortedlist extends RefList implements UnsortedListInterface{
	
	public RefUnsortedlist() {
		super();
	}
	
	@Override
	public void add(Object element) {
		LLObjectNode newNode = new LLObjectNode(element);
		newNode.setLink(list);
		list = newNode;
		numElements++;		
	}
}
