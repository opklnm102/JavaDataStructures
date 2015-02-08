package ch6.lists;

public interface ListInterface {
	int size();
	boolean contains(Object element);
	String toString();
	void reset();
	Object getNext();
}
