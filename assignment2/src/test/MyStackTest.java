package test;

import dataStructures.ListADT;
import dataStructures.MyArrayList;
import dataStructures.MyStack;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MyStackTest {
	@Test
	void creationTest() {
		MyStack stack = new MyStack();
	}
	@Test
	void sizeTest() {
		MyStack stack = new MyStack();
		assertEquals(0, stack.size());
	}
	@Test
	void sizeTest2() {
		MyStack stack = new MyStack();
		stack.push("data");
		assertEquals(1, stack.size());
	}
	@Test
	void sizeTest3() {
		MyStack stack = new MyStack();
		stack.push("data");
		stack.push("data");
		stack.push("data");
		assertEquals(3, stack.size());
	}
	@Test
	void peekTest() {
		MyStack stack = new MyStack();
		stack.push("data");
		assertEquals("data", stack.peek());
	}
	@Test
	void emptyTest() {
		MyStack stack = new MyStack();
		stack.push("data");
		stack.pop();
		assertEquals(true, stack.isEmpty());
	}
	@Test
	void emptyTest2() {
		MyStack stack = new MyStack();
		stack.push("data");
		stack.clear();
		assertEquals(true, stack.isEmpty());
	}
	@Test
	void clearTest() {
		MyStack stack = new MyStack();
		stack.push("data");
		stack.clear();
		assertEquals(0, stack.size());
	}
	@Test
	void clearTest2() {
		MyStack stack = new MyStack();
		stack.clear();
		assertEquals(0, stack.size());
	}
	@Test
	void clearTest3() {
		MyStack stack = new MyStack();
		stack.push("data");
		stack.push("data");
		stack.push("data");
		stack.clear();
		assertEquals(0, stack.size());
	}
	@Test
	void searchTest() {
		MyStack stack = new MyStack();
		stack.push("data");
		stack.push("data");
		stack.push("data2");
		stack.clear();
		assertEquals(0, stack.search("data2"));
	}
	@Test
	void searchTest1() {
		MyStack stack = new MyStack();
		assertEquals(-1, stack.search("data"));
	}
	@Test
	void searchTest2() {
		MyStack stack = new MyStack();
		stack.push("data");
		assertEquals(-1, stack.search("data2"));
	}
}
