package com.mbesutti.presenterPicker;

import java.io.IOException;
import java.util.List;

public class Presenters {

	private final Store _store;

	public Presenters() {
		_store = new Store("presenters.txt");
	}

	public List<String> all() throws IOException {
		return _store.getLines();
	}

	public void add(String presenter) throws IOException {
		_store.writeLine(presenter);
	}

	public void remove(String presenter) throws IOException {
		_store.removeLine(presenter);
	}
}
