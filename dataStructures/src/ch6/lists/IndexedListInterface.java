package ch6.lists;
//색인리스트 인터페이스
public interface IndexedListInterface extends ListInterface{
	void add(int index, Object element);
	Object set(int index, Object element);
	Object get(int index);
	int indexOf(Object element);
	Object remove(int index);
}
