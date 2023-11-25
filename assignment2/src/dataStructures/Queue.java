package dataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<T, E> implements QueueADT<E>{
	T queueData;
	Queue next;
	int lenght;
	
	//Empty constructor, meant to be original constructor
	public Queue() {}
	
	public Queue(int lenght) {
		this.lenght = lenght;
	}
	//Constructor that can take an intial value, use primary for adding items, but can also be used as original constructor
	public Queue(Object value) {
		this.queueData = (T) value;	
	}
	
	//Remove the first item and pushes all other items in queue forward
	@Override
	public E dequeue() {
		T hold = this.queueData;
		if(this.next == null) {
			//If the next queue line item is null, it does not contain any more data after it, and can be discarded
			this.queueData = null;
		}else {
			T var =  (T) this.next.dequeue();
			if(var != null) {
				this.queueData = var;
			}else {
				this.next = null;
			}
		}
		return (E) hold;
	}
	
	//Adds a new item to the queue, at the end
	@Override
	public void enqueue(E newItem) {
		if(this.queueData == null) {
			this.queueData = (T) newItem;
		}else if(this.next == null){
			this.next = new Queue(newItem);
		}else {
			this.next.enqueue(newItem);
		}
	}
	
	//Return the top item on the queue, without removing it
	@Override
	public E peek() {
		return (E) this.queueData;
	}
	//Check if the queue is empty
	@Override
	public boolean isEmpty() {
		if(queueData != null) {
			return false;
		}
		return true;
	}
	//Return the number of items in the queue
	@Override
	public int size() {
		//Keeps checking until it has reached the last item in queue
		if (this.next == null) {
			if(this.queueData == null) {
				return(0);
			}
			return 1;
		}
		//And then each queue object adds one until it is returned to the original caller
		return(this.next.size()+1);
	}
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return (Iterator<E>) new QueueIterator();
	}
	private class QueueIterator implements Iterator<T> {
		private Queue current;

		public QueueIterator() {
			current = next;
		}
		@Override
		public boolean hasNext() {
			return (current != null);
		}

		@Override
		public T next() {
			if (!hasNext()) {
                throw new NoSuchElementException();
            }
			T data = (T) current.queueData;
			current =current.next;
			return data;
		}
		
	}
	@Override
	public boolean equals(QueueADT<E> that) {
		Queue queue1 = this;
		Queue queue2 = (Queue) that;//I assume this is how it works
		// Traverse both lists and compare node data
        while (queue1 != null && queue2 != null) {
            if (queue1.queueData != queue2.queueData) {
                return false; // Data does not match, lists are different
            }
            queue1 = queue1.next;
            queue2 = queue2.next;
        }

        // If one list is longer than the other, they are not the same
        return (queue1 == null && queue2 == null);
	}
	@Override
	public Object[] toArray() {
		Object[] items = new Object[this.size()];
		//Add the item to the end of the array, and then reverse it
		items[this.size()-1] = this.queueData;
		if(this.next != null) {
			this.next.addToArray(items);
		}
		//it will take the item thought the addToArray and will reverse here
		this.reverseArray(items);
		return items;
	}
	public void addToArray(Object[] arr) {
		arr[this.size()-1] = this.queueData;
		if(this.next != null) {
			this.next.addToArray(arr);
		}
	}
	public static void reverseArray(Object[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            // Swap elements at left and right indices
            Object temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            // Move indices towards the center
            left++;
            right--;
        }
    }
	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		// How is this different other from toArray
		lenght = holder.length - 1;
		holder[lenght] = (E) this.queueData;
		if(next == null) {
			return null;
		}
		return toArray(holder, lenght);
	}
	public E[] toArray(E[] holder, int place) {
		lenght = lenght - 1;
		holder[lenght] = (E) this.queueData;
		E[] newArray = null;
		//If placement become 0, create the new array
		if(lenght == 0) {
			lenght = this.size();
			newArray = (E[]) new Object[lenght];
			this.reverseArray(holder);
		}
		if(next == null) {
			return null;
		}
		if(newArray != null) {
			this.next.toArray(newArray);
		}
		return toArray(holder, lenght);
	}
	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return this.lenght < this.size();
	}
	@Override
	public void dequeueAll() {
		// Removes all data form the queue
		this.queueData = null;
		this.next = null;
		
	}

}
