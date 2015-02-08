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

	protected void enlarge() { // 리스트의 크기를 확정
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
	
	protected void find(Object target) {  // 이진탐색알고리즘
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

	public int size() { // 리스트내의 요소 갯수 반환
		return numElements;
	}

	public boolean contains(Object element) { // 동일한 요소를 포함하고 있는지
		find(element);
		return found;
	}

	public boolean remove(Object element) { // 제거
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

	public void reset() { // 리스트의 시작위치로 포인터를 옮김
		currentPos = 0;
	}

	public Object getNext() { // 다음요소를 반환, 현위치 갱신
		Object next = list[currentPos];
		if (currentPos == (numElements - 1))
			currentPos = 0;
		else
			currentPos++;
		return next;
	}
}
