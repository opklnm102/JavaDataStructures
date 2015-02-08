package ch6.lists;

import support.LLObjectNode;

public class RefSortedList extends RefList implements SortedListInterface {
	
	public RefSortedList() {
		super();
	}
	
	@Override
	public void add(Comparable element) {
		LLObjectNode prevLoc;
		LLObjectNode location;
		Comparable listElement;
		boolean moreToSearch;
		
		location = list;
		prevLoc = null;
		moreToSearch = (location != null);
		//find insertion point
		while(moreToSearch){
			listElement = (Comparable)location.getLink();
			if(listElement.compareTo(element)<0){
				prevLoc = location;
				location = location.getLink();
				moreToSearch = (location != null);				
			}
			else
				moreToSearch = false;
		}
		
		//prepare node for insertion
		LLObjectNode newNode = new LLObjectNode(element);		
		//insert node into list
		if(prevLoc == null){  //insert as first node
			newNode.setLink(list);
			list = newNode;
		}
		else{  //insert elsewhere
			newNode.setLink(location);
			prevLoc.setLink(newNode);
		}
		numElements++;	
	}
}
