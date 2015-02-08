package ch6.lists;

public class ArraySortedList extends List implements SortedListInterface {

	public ArraySortedList() {
		super();
	}

	public ArraySortedList(int origCap) {
		super(origCap);
	}

	@Override
	public void add(Comparable element) {
		Comparable listElements;
		int location = 0;
		boolean moreToSearch;

		if (numElements == list.length) // ����Ʈ�� ����������
			enlarge(); // ũ�⸦ �ø���

		moreToSearch = (numElements > 0);

		while (moreToSearch) {
			listElements = (Comparable) list[location];
			if (listElements.compareTo(element) < 0) {
				location++;
				moreToSearch = (location < numElements);
			} else
				moreToSearch = false;
		}

		for (int index = numElements; index > location; index--)
			list[index] = list[index - 1];

		list[location] = element;
		numElements++;
	}
}
