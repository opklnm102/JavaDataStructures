package ch7.byteLists;

//2���� ������ ������ ���߿��Ḯ��Ʈ �������̽�
public interface SpecializedListInterface {
	void resetForward();
	
	byte getNextElement();
	
	void resetBackward();
	
	byte getPriorElement();
	
	int size();
	
	void addFront(byte element);
	
	void addEnd(byte element);

}
