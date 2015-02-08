package ch7.byteLists;

//2개의 참조를 가지는 이중연결리스트
public class SpecializedList implements SpecializedListInterface {

	protected class SListNode{
		protected byte info;
		protected SListNode next;
		protected SListNode back;
	}
	protected SListNode listFirst;
	protected SListNode listLast;
	protected int numElements;
	protected SListNode currentFPos;  //current forward position for iteration
	protected SListNode currentBPos;  //current backward position for iteration	
	
	public SpecializedList() {
		numElements=0;
		listFirst=null;
		listLast=null;
		currentFPos=null;
		currentBPos=null;
	}
	
	@Override
	public void resetForward() {
		currentFPos = listFirst;		
	}

	@Override
	public byte getNextElement() {
		byte nextElementInfo = currentFPos.info;
		if(currentFPos == listLast)
			currentFPos = listFirst;
		else
			currentFPos = currentFPos.next;
		return nextElementInfo;
	}

	@Override
	public void resetBackward() {
		currentBPos = listLast;		
	}

	@Override
	public byte getPriorElement() {
		byte nextElementInfo = currentBPos.info;
		if(currentBPos == listFirst)
			currentBPos = listLast;
		else
			currentBPos = currentBPos.back;
		return nextElementInfo;
	}

	@Override
	public int size() {
		return numElements;
	}

	@Override
	public void addFront(byte element) {
		SListNode newNode = new SListNode();
		newNode.info = element;
		newNode.next = listFirst;
		newNode.back = null;
		if(listFirst == null){
			listFirst = newNode;
			listLast = newNode;
		}
		else{
			listFirst.back = newNode;
			listFirst = newNode;
		}
		numElements++;
	}

	@Override
	public void addEnd(byte element) {
		SListNode newNode = new SListNode();
		newNode.info = element;
		newNode.next = null;
		newNode.back = listLast;
		if(listFirst == null){
			listFirst = newNode;
			listLast = newNode;
		}
		else{
			listLast.next = newNode;
			listLast = newNode;
		}
		numElements++;		
	}
}
