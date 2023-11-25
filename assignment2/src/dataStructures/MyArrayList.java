package dataStructures;
 
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
 
public class MyArrayList<E> implements ListADT<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;
 
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
 
    @Override
    public int size() {
        return size;
    }
 
    @Override
    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
 
    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (toAdd == null) {
            throw new NullPointerException("Cannot add null elements to the list");
        }
 
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
 
        ensureCapacity();
 
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = toAdd;
        size++;
 
        return true;
    }
 
    @Override
    public boolean add(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("Cannot add null elements to the list");
        }
 
        ensureCapacity();
        elements[size++] = toAdd;
 
        return true;
    }
 
    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("Cannot add null elements to the list");
        }
 
        ensureCapacity();
 
        for (E element : toAdd) {
            elements[size++] = element;
        }
 
        return true;
    }
 
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
 
        return (E) elements[index];
    }
 
    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
 
        E removedElement = (E) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null; // Set the last element to null
        return removedElement;
    }
 
    @Override
    public E remove(E toRemove) throws NullPointerException {
        if (toRemove == null) {
            throw new NullPointerException("Cannot remove null elements from the list");
        }
 
        for (int i = 0; i < size; i++) {
            if (toRemove.equals(elements[i])) {
                return remove(i);
            }
        }
 
        return null; // Element not found
    }
 
    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (toChange == null) {
            throw new NullPointerException("Cannot set null elements in the list");
        }
 
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
 
        E previousElement = (E) elements[index];
        elements[index] = toChange;
        return previousElement;
    }
 
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
 
    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) {
            throw new NullPointerException("Cannot search for null elements in the list");
        }
 
        for (int i = 0; i < size; i++) {
            if (toFind.equals(elements[i])) {
                return true;
            }
        }
 
        return false;
    }
 
    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold == null) {
            throw new NullPointerException("Provided array cannot be null");
        }
 
        if (toHold.length < size) {
            return Arrays.copyOf(elements, size, (Class<? extends E[]>) toHold.getClass());
        }
 
        System.arraycopy(elements, 0, toHold, 0, size);
        return toHold;
    }
 
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }
 
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = 0;
 
            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }
 
            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) elements[currentIndex++];
            }
        };
    }
 
    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }
}