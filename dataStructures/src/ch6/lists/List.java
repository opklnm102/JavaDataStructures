package ch6.lists;

public class List {
	protected final int DEFCAP = 100; // default capacity
	protected int origCap; // original capacity
	protected Object[] list; // array to hold this list's elements
	protected int numElements; // number of elements in this list
	protected int currentPos; // current position for iteration

	protected boolean found; // true if element found, otherwise false
	protected int location; // indicates location of element if found

	public List() {
		list = new Object[DEFCAP];
		origCap = DEFCAP;
	}

	public List(int origCap) {
		list = new Object[origCap];
		this.origCap = origCap;
	}

	protected void enlarge() { // ����Ʈ�� ũ�⸦ Ȯ��
		Object[] larger = new Object[list.length + origCap];

		for (int i = 0; i < numElements; i++) {
			larger[i] = list[i];
		}
	}

	// protected void find(Object target){
	// boolean moreToSearch;
	// location=0;
	// found = false;
	// moreToSearch = (location < numElements);
	// while(moreToSearch && !found){
	// if(list[location].equals(target))
	// found = true;
	// else{
	// location++;
	// moreToSearch = (location < numElements);
	// }
	// }
	// }
	
	protected void find(Object target) {  // ����Ž���˰���
		int first = 0;
		int last = numElements - 1;
		boolean moreToSearch = (first <= last);
		int compareResult;
		Comparable targetElement = (Comparable) target;
		found = false;
		while (moreToSearch && !found) {
			location = (first + last) / 2;
			compareResult = targetElement.compareTo(list[location]);
			if (compareResult == 0)
				found = true;
			else if (compareResult < 0) {
				last = location - 1;
				moreToSearch = (first <= last);
			}
			else{
				first=location+1;
				moreToSearch=(first<=last);
			}
		}
	}

	public int size() { // ����Ʈ���� ��� ���� ��ȯ
		return numElements;
	}

	public boolean contains(Object element) { // ������ ��Ҹ� �����ϰ� �ִ���
		find(element);
		return found;
	}

	public boolean remove(Object element) { // ����
		find(element);
		if (found) {
			for (int i = location; i <= numElements - 2; i++)
				list[i] = list[i + 1];
			list[numElements - 1] = null;
			numElements--;
		}
		return found;
	}

	public Object get(Object element) {
		find(element);
		if (found)
			return list[location];
		else
			return null;
	}

	public String toString() {
		String listString = "List:\n";
		for (int i = 0; i < numElements; i++)
			listString = listString + " " + list[i] + "\n";
		return listString;
	}

	public void reset() { // ����Ʈ�� ������ġ�� �����͸� �ű�
		currentPos = 0;
	}

	public Object getNext() { // ������Ҹ� ��ȯ, ����ġ ����
		Object next = list[currentPos];
		if (currentPos == (numElements - 1))
			currentPos = 0;
		else
			currentPos++;
		return next;
	}
}
