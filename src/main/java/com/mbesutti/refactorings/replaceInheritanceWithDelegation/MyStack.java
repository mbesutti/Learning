package com.mbesutti.refactorings.replaceInheritanceWithDelegation;

import java.util.Vector;

public class MyStack {
	private static final long serialVersionUID = 4905999281666644881L;
	private Vector<Object> _vector = new Vector<Object>();

	public void push(Object element) {
		_vector.insertElementAt(element, 0);
	}

	public Object pop() {
		Object result = _vector.firstElement();
		_vector.removeElementAt(0);
		return result;
	}

	public int size() {
		return _vector.size();
	}

	public boolean isEmpty() {
		return _vector.isEmpty();
	}
}
