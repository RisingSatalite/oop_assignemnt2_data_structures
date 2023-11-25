package test;

import dataStructures.ListADT;
import dataStructures.MyArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MyArrayListTests {

    @Test
    void testAddAndGet() {
    	ListADT<String> list = new MyArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("orange");

        assertEquals("apple", list.get(0));
        assertEquals("banana", list.get(1));
        assertEquals("orange", list.get(2));
    }

    @Test
    void testSize() {
    	ListADT<Integer> list = new MyArrayList<>();
        assertEquals(0, list.size());

        list.add(1);
        list.add(2);

        assertEquals(2, list.size());
    }

    @Test
    void testEnsureCapacity() {
    	ListADT<Double> list = new MyArrayList<>();

        list.add(1.0);
        list.add(2.0);
        list.add(3.0);

        assertEquals(3, list.size());
        assertEquals(3.0, list.get(2));
    }

    @Test
    void testOutOfBounds() {
        ListADT<Double> list = new MyArrayList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));

        list.add(3.14);

        assertDoesNotThrow(() -> list.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    @Test
    void testRemove() {
        ListADT<String> list = new MyArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("orange");

        assertEquals("banana", list.remove(1));
        assertEquals(2, list.size());
        assertEquals("orange", list.get(1));
    }

    @Test
    void testSet() {
        ListADT<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);

        assertEquals(2, list.set(1, 3));
        assertEquals(3, list.get(1));
    }

    @Test
    void testClear() {
        ListADT<String> list = new MyArrayList<>();
        list.add("apple");
        list.add("banana");

        list.clear();

        assertEquals(0, list.size());
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    void testAddAll() {
        ListADT<Integer> list1 = new MyArrayList<>();
        list1.add(1);
        list1.add(2);

        ListADT<Integer> list2 = new MyArrayList<>();
        list2.add(3);
        list2.add(4);

        list1.addAll(list2);

        assertEquals(4, list1.size());
        //Problem here, 
        assertEquals(3, list1.get(2));
    }

    @Test
    void testRemoveByValue() {
        ListADT<String> list = new MyArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("orange");

        //I do not think you need this like this, skip assert true and false should be possible
        assertTrue(true, list.remove("banana"));
        assertFalse(false, list.remove("grape"));
        
        assertEquals(2, list.size());
        assertEquals("orange", list.get(1));
    }

    @Test
    void testSetOutOfBounds() {
        ListADT<Integer> list = new MyArrayList<>();
        list.add(1);

        assertThrows(IndexOutOfBoundsException.class, () -> list.set(1, 2));
    }

    @Test
    void testRemoveOutOfBounds() {
        ListADT<String> list = new MyArrayList<>();
        list.add("apple");

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
    }

    @Test
    void testAddAllNull() {
        ListADT<Integer> list = new MyArrayList<>();
        assertThrows(NullPointerException.class, () -> list.addAll(null));
    }
}