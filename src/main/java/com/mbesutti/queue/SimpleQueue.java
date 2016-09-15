package com.mbesutti.queue;


public class SimpleQueue extends Queue {
	
	@Override
	public void enqueue(String element) {
		_list.add(element);
	}

	@Override
	public String dequeue() {
		return _list.remove(0);
	}
	
}
