package test;

import dataStructures.Queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueTest {

	//@Test
	void test() {
		fail("Not yet implemented");
	}
	@Test
	void sizeTest1() {
		Queue queue = new Queue();
		assertEquals(0, queue.size());
	}
	@Test
	void sizeTest2() {
		Queue queue = new Queue();
		queue.enqueue("data");
		assertEquals(1, queue.size());
	}
	@Test
	void sizeTest3() {
		Queue queue = new Queue();
		queue.enqueue("data");
		queue.enqueue("data");
		queue.enqueue("data");
		queue.enqueue("data");
		queue.enqueue("data");
		queue.enqueue("data");
		queue.enqueue("data");
		queue.enqueue("data");
		assertEquals(8, queue.size());
	}
	@Test
	void peekTest1() {
		Queue queue = new Queue();
		queue.enqueue("data");
		assertEquals("data", queue.peek());
	}
	@Test
	void peekTest2() {
		Queue queue = new Queue();
		queue.enqueue("data");
		queue.enqueue("data1");
		queue.enqueue("data2");
		queue.dequeue();
		assertEquals("data1", queue.peek());
	}
	@Test
	void voidTest() {
		Queue queue = new Queue();
		queue.enqueue("data");
		queue.dequeueAll();
		assertEquals(0, queue.size());
	}
	@Test
	void voidTest2() {
		Queue queue = new Queue();
		queue.enqueue("data");
		queue.enqueue("data");
		queue.enqueue("data");
		queue.enqueue("data");
		queue.enqueue("data");
		queue.enqueue("data");
		queue.enqueue("data");
		queue.dequeueAll();
		assertEquals(0, queue.size());
	}
	@Test
	void addTest() {
		//Check that multiple data types can be added
		Queue queue = new Queue();
		queue.enqueue("data");
		queue.enqueue(1);
		queue.enqueue(queue);
	}
	@Test
	void equalTest() {
		Queue queue = new Queue();
		Queue queue2 = new Queue();
		queue.enqueue(1);
		queue.enqueue(2);
		assertEquals(true, queue.equals(queue2));
	}
	@Test
	void emptyTest() {
		Queue queue = new Queue();
		assertEquals(true, queue.isEmpty());
	}
	@Test
	void creationTest() {
		Queue queue = new Queue();
	}
}
