package com.mbesutti.presenterPicker;

import java.io.IOException;
import java.util.List;

public class Course {

	private final Store _store;

	public Course() throws IOException {
		_store = new Store("presenters");
		if (_store.isEmpty()) {
			prefill();
		}
	}

	public Course(String date) {
		_store = new Store("presenters", date);
	}
	
	public static List<String> history(){
		return Store.backups("presenters");
	}

	public List<String> presenters() throws IOException {
		return _store.getLines();
	}

	public void add(String presenter) throws IOException {
		_store.writeLine(presenter);
	}

	public void remove(String presenter) throws IOException {
		_store.removeLine(presenter);
	}

	public String getName() {
		return "GMTech lessons";
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

	private void prefill() throws IOException {
		add("manlio");
		add("franco");
		add("ale");
		add("dario");
		add("enrico");
		add("mattia");
		add("chicco");
		add("pino");
		add("gennaro");
		add("massi");
		add("vacca");
		add("gabri");
		add("stefano");
		add("matteo");
		add("valentino");
	}

}
