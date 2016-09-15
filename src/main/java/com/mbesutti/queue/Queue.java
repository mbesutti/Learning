package com.mbesutti.queue;

import java.util.ArrayList;

public abstract class Queue {
	final ArrayList<String> _list;

	public Queue() {
		_list = new ArrayList<String>();
	}
	
	public String peek() {
		return _list.get(0);
	}
	
	abstract void enqueue(String element);
	abstract String dequeue();
}
