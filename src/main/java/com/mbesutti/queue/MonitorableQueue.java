package com.mbesutti.queue;

public class MonitorableQueue extends Queue {
	
	private final int _maxSize;
	
	public MonitorableQueue(int maxSize) {
		_maxSize = maxSize;
	}
	
	public boolean isFull() {
		return _list.size() == _maxSize;
	}
	
	public boolean isEmpty() {
		return _list.size() == 0;
	}

	@Override
	public void enqueue(String element) {
		_list.add(element);
	}

	@Override
	public String dequeue() {
		return _list.remove(0);
	}
}
