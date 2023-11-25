package dataStructures;

public class LinkedList<T> {
	LinkedList<T> next;
	T value;
	
	public LinkedList() {
	}
	public LinkedList(T newValue) {
		this.value = newValue;
	}
	public LinkedList(LinkedList<T> nextlinklistnode, T newValue) {
		this.next = nextlinklistnode;
		this.value = newValue;
	}
	public LinkedList(DoubleLinkedList<T> nextlinklistnode, DoubleLinkedList<?> previouslinklistnode, Object newValue) {
		// Needed for DoubleLinkedList
	}
	public LinkedList(DoubleLinkedList<T> newEnd, Object data, int end) {
		// Needed for DoubleLinkedList
	}
	public void AddItem(T dataToAdd){
		if(IsTail()) {
			this.next = new LinkedList<>(dataToAdd);
		}
		else {
			this.next.AddItem(dataToAdd);
		}
	}
	public boolean IsEmpty() {
		return(this.next == null);
	}
	public boolean AltIsEmpty() {
		if(this.value == null) {
			return true;
		}
		return false;
	}
	public boolean IsTail() {
		if(this.next == null) {
			return true;
		}
		return false;
	}
	public void ChangeData(T newData) {
		this.value = newData;
	}
	public int GetSize() {
		if(IsTail()) {
			return 1;
		}
		return this.next.GetSize();
	}
}
