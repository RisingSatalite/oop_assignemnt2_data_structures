package dataStructures;


//There is not really much DLLadt, so this should still work
public class DoubleLinkedList<T> extends LinkedList {
	DoubleLinkedList last;
	DoubleLinkedList next;

	public DoubleLinkedList() {
	}
	public DoubleLinkedList(T newValue) {
		super(newValue);
		this.value = newValue;
	}
	public DoubleLinkedList(DoubleLinkedList<T> nextlinklistnode, T newValue) {
		super(nextlinklistnode, newValue);
		this.next = nextlinklistnode;
		this.value = newValue;
		// TODO Make sure contructer works
	}
	public DoubleLinkedList(DoubleLinkedList<T> nextlinklistnode, DoubleLinkedList previouslinklistnode, T newValue) {
		super(nextlinklistnode, previouslinklistnode, newValue);
		this.next = nextlinklistnode;
		this.last = previouslinklistnode;
		this.value = newValue;
		// TODO Make sure contructer works
	}
	public DoubleLinkedList(DoubleLinkedList<T> newEnd, T data, int end) {
		super(newEnd, data, end);
		this.value = data;
		if(end == 0) {
			this.next = newEnd;
		}
		if(end == 1) {
			this.last = newEnd;
		}
	}
	//Extra function
	public void NewHeadData(T newData) {
		if(IsHead()) {
			this.value = newData;
		}else{
			last.NewHeadData(newData);
		}
	}
	public void NewHead(T newData) {
		if(IsHead()) {
			this.last = new DoubleLinkedList<T>(this, newData, 0);
		}else{
			last.NewHead(newData);
		}
	}
	public void AddData(T newData) {
		this.NewTail(newData);
	}
	public void NewTail(T newData) {
		if(IsTail()) {
			this.next = new DoubleLinkedList<T>(this, newData, 1);
		}else{
			next.NewTail(newData);
		}
	}
	public boolean IsHead() {
		return(this.last == null);
	}
	public void RemoveLast() {
		if(IsTail()) {
			last.next = null;
		}else {
			next.RemoveLast();
		}
	}
	public DoubleLinkedList RemoveFirst() {
		if(IsHead()) {
			next.last = null;
			return next;
		}else {
			return next.RemoveFirst();
		}
	}
	public boolean Exist(T data) {
		if(this.value == data) {
			return true;
		}
		if(next == null) {
			return false;
		}
		return next.Exist(data);
	}
	public int size() {
		if(this.value == null) {
			return 0;
		}
		if(this.next == null) {
			return 1;
		}
		return this.next.size()+1;
	}
	public void clear() {
		this.next = null;
		this.last = null;
		this.value = null;
	}
	public T returnValue() {
		return (T) this.value;
	}
	public T returnValueIndex(int number) {
		if(number == 0) {
			return this.returnValue();
		}
		if(this.next != null) {
			return (T) this.next.returnValueIndex(number -1);
		}//There is no data at that index
		return null;
	}
}
