package ch2.stringLogs;

public interface StringLogInterface {
	
	void insert(String element);
	//precondition : this stringLogs is not full
	//places element into this StringLog
	
	boolean isFull();
	//return true if this StringLog is full. otherwise return false
	
	int size();
	//return the number of Strings in this StringLogs
	
	boolean contains(String element);
	//return true if element is in this StringLogs
	//otherwise return false
	//ignore case differences wen doing a string comparisons
	
	void clear();
	//make this StringLog empty
	
	String getName();
	//return the name of this StringLog
	
	String toString();
	//return a nicely formatted string representing this StringLog
}
