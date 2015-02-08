package ch7.byteLists;

//2개의 참조를 가지는 이중연결리스트 인터페이스
public interface SpecializedListInterface {
	void resetForward();
	
	byte getNextElement();
	
	void resetBackward();
	
	byte getPriorElement();
	
	int size();
	
	void addFront(byte element);
	
	void addEnd(byte element);

}
