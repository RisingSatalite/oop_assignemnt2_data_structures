package dataStructures;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 
 */

/**
 * @author ivant
 *
 */
public class MyStack<T> implements StackADT<T> {
	
	//Note the orignal version of the StackADT had some methods changes
	
	public int size;
	public T[] stack;

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public MyStack() {
		// TODO Auto-generated constructor stub
		stack = (T[]) new Object[10];
		size = 0;
	}

	public void newStack() {
		// TODO Auto-generated method stub
		stack = (T[]) new Object[10];
		size = 0;
	}

	@Override
	public void push(T element) {
		// TODO Auto-generated method stub
		stack[size] = element;
		size++;
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		size--;
		T popped = stack[size];
		stack[size] = null;
		
		return popped;
	}

	@Override
	public T peek() {
		T peeked = stack[size-1];
		return peeked;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(size == 0) {
			return true;
		}
		
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		for(int i = 0; i < stack.length; i++) {
			stack[i] = null;
		}
		size = 0;
	}

	@Override
	public T[] toArray() {
		T[] array = Arrays.copyOf(stack, size);
		return array;
	}

	@Override
	public int search(T element) {
		// TODO Auto-generated method stub
		for(int i = 0; i < stack.length; i++) {
			if(stack[i] == element) {
				return i;
			}
		}
		return -1;
	}

	
	//These method were added in updated StackADT it seems
	@Override
	public T[] toArray(T[] holder) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T toFind) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(StackADT<T> that) {
		// TODO Auto-generated method stub
		return false;
	}

}