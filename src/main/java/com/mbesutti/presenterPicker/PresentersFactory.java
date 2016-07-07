package com.mbesutti.presenterPicker;

import java.io.IOException;
import java.util.List;

public class PresentersFactory {

	private final FileHandler _file;

	public PresentersFactory() {
		_file = new FileHandler("presenters.txt");
	}

	public List<String> all() throws IOException {
		return _file.getLines();
	}

	public void add(String presenter) throws IOException {
		_file.writeLine(presenter);
	}

//	public void remove(String presenter) {
////		_file.removeLine(presenter);
//	}

}
