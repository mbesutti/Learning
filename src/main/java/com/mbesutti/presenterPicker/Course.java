package com.mbesutti.presenterPicker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Course {

	private final Store _store;
	private final Store _absents;

	public Course() throws IOException {
		_store = new Store("presenters");
		if (_store.isEmpty()) {
			prefill();
		}
		_absents = new Store("absents");
	}

	public Course(String date) {
		_store = new Store("presenters", date);
		_absents = new Store("absents", date);
	}
	
	public static List<String> history(){
		return Store.backups("presenters");
	}

	public List<String> presenters() throws IOException {
		return _store.getLines();
	}

	public List<String> absents() throws IOException {
		if (_absents==null) {
			ArrayList<String> emptyList = new ArrayList<String>();
			emptyList.add("none");
			return emptyList;
		}
		return _absents.getLines();
	}

	public void add(String[] presenters) throws IOException {
		for (String presenter : presenters) {
			_store.writeLine(presenter);
		}
	}

	public void remove(String[] presenters) throws IOException {
		for (String presenter : presenters) {
			_store.removeLine(presenter);
			_absents.writeLine(presenter);
		}
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
		String[] presenters = {"manlio", "franco", "ale", "dario", "enrico", "mattia", "chicco", "pino", "gennaro", "massi", "vacca", "gabri", "stefano", "matteo", "valentino"};
		add(presenters);
	}

}
