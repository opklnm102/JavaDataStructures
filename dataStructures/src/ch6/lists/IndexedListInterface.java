package ch6.lists;
//���θ���Ʈ �������̽�
public interface IndexedListInterface extends ListInterface{
	void add(int index, Object element);
	Object set(int index, Object element);
	Object get(int index);
	int indexOf(Object element);
	Object remove(int index);
}
