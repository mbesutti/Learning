package com.mbesutti.queue;

import junit.framework.Assert;

import org.junit.Test;

public class QueueTest {
	@Test
	public void enqueueOne() {
		SimpleQueue queue = new SimpleQueue();
		queue.enqueue("matteo");
		Assert.assertEquals("matteo", queue.dequeue());
	}
	
	@Test
	public void enqueueMore() {
		SimpleQueue queue = new SimpleQueue();
		queue.enqueue("matteo");
		queue.enqueue("tia");
		Assert.assertEquals("matteo", queue.dequeue());
		Assert.assertEquals("tia", queue.dequeue());
	}

	@Test
	public void peekOne() {
		SimpleQueue queue = new SimpleQueue();
		queue.enqueue("matteo");
		Assert.assertEquals("matteo", queue.peek());
		Assert.assertEquals("matteo", queue.peek());
	}
	
	@Test
	public void isFull() {
		MonitorableQueue queue = new MonitorableQueue(1);
		Assert.assertFalse(queue.isFull());
		queue.enqueue("matteo");
		Assert.assertTrue(queue.isFull());
		queue.dequeue();
		Assert.assertFalse(queue.isFull());
	}
	
	@Test
	public void isEmpty() {
		MonitorableQueue queue = new MonitorableQueue(1);
		Assert.assertTrue(queue.isEmpty());
		queue.enqueue("matteo");
		Assert.assertFalse(queue.isEmpty());
		queue.dequeue();
		Assert.assertTrue(queue.isEmpty());
	}
}
