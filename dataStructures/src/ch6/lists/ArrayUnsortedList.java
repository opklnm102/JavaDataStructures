package ch6.lists;

public class ArrayUnsortedList extends List implements UnsortedListInterface {
	
	public ArrayUnsortedList() {
		super();
	}
	
	public ArrayUnsortedList(int origCap) {
		super(origCap);
	}

	@Override
	public void add(Object element) {
		if(numElements == list.length)
			enlarge();
		list[numElements] = element;
		numElements++;	
	}		
}