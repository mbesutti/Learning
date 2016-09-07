package com.mbesutti.presenterPicker;

import java.io.IOException;
import java.util.List;

public class Course {

	private final Store _store;

	public Course() {
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

	public String getName() {
		return "GMTech class";
	}
	
	public String getDescription() {
		return "Un corso figo";
	}

	public String getLocation() {
		return "Mendrisio";
	}

	public int getRemainingSeats() {
		return 0;
	}

}
