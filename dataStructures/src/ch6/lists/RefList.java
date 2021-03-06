package ch6.lists;

import support.LLObjectNode;

public class RefList {
	protected int numElements;
	protected LLObjectNode currentPos;

	// set by find method
	protected boolean found;
	protected LLObjectNode location; // node containing element, if found
	protected LLObjectNode previous; // node preceding location

	protected LLObjectNode list; // first node on the list

	public RefList() {
		numElements = 0;
		list = null;
		currentPos = null;
	}

	protected void find(Object target) {
		boolean moreToSearch;
		location = list;
		found = false;

		moreToSearch = (location != null);
		while (moreToSearch && !found) {
			if (location.getInfo().equals(target))
				found = true;
			else {
				previous = location;
				location = location.getLink();
				moreToSearch = (location != null);
			}
		}
	}

	public int size() {
		return numElements;
	}

	public boolean contains(Object element) {
		find(element);
		return found;
	}

	public boolean remove(Object element) {
		find(element);
		if (found) {
			if (list == location)
				list = list.getLink();
			else
				previous.setLink(location.getLink());

			numElements--;
		}
		return found;
	}

	public Object get(Object element) {
		find(element);
		if (found)
			return location.getInfo();
		else
			return null;
	}

	public String toString() {
		LLObjectNode currNode = list;
		String listString = "List:\n";
		while (currNode != null) {
			listString = listString + " " + currNode.getInfo() + "\n";
			currNode = currNode.getLink();
		}
		return listString;
	}

	public void reset() {
		currentPos = list;
	}

	public Object getNext() {
		Object next = currentPos.getInfo();
		if (currentPos.getLink() == null)
			currentPos = list;
		else
			currentPos = currentPos.getLink();
		return next;
	}
}
