package test;

import dataStructures.ListADT;
import dataStructures.MyArrayList;
import dataStructures.MyStack;
import dataStructures.DoubleLinkedList;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DLLtest {
	@Test
	void creationTest() {
		DoubleLinkedList dll = new DoubleLinkedList();
	}
	@Test
	void sizeTest() {
		DoubleLinkedList dll = new DoubleLinkedList();
		assertEquals(0, dll.size());
	}
	@Test
	void sizeTest2() {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.AddData("data");
		dll.AddData("data");
		dll.AddData("data");
		assertEquals(3, dll.size());
	}
	@Test
	void sizeTest3() {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.AddData("data");
		assertEquals(1, dll.size());
	}
	@Test
	void sizeTest4() {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.AddData("data");
		dll.clear();
		assertEquals(0, dll.size());
	}
	@Test
	void returnTest() {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.AddData("data");
		assertEquals("data", dll.returnValue());
	}
	@Test
	void returnIndexTest() {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.AddData("data");
		assertEquals("data", dll.returnValueIndex(0));
	}
	@Test
	void returnIndexTest2() {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.AddData("data");
		dll.AddData("data2");
		assertEquals("data2", dll.returnValueIndex(1));
	}
	@Test
	void existTest() {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.AddData("data");
		assertEquals(true, dll.Exist("data"));
	}
	@Test
	void existTest2() {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.AddData("data");
		assertEquals(false, dll.Exist("data2"));
	}
}
