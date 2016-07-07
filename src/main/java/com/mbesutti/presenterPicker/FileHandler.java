package com.mbesutti.presenterPicker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileHandler {
	private final File _file;

	public FileHandler(String path) {
		_file = new File(path);
	}
	
	public ArrayList<String> getLines() throws IOException{
		FileInputStream fis = new FileInputStream(_file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		ArrayList<String> lines = new ArrayList<String>();
		while (br.ready()) {
			lines.add(br.readLine());
		}
		br.close();
		return lines;
	}
	
	public void writeLine(String line) throws IOException {
		FileWriter fw = new FileWriter(_file, true);
		fw.append(line);
		fw.close();
	}
	
	public void removeLine(String line) throws IOException {
		ArrayList<String> lines = getLines();
		lines.remove(line);
		FileWriter fw = new FileWriter(_file);
		fw.write("");
		fw.close();
		for (String string : lines) {
			writeLine(string);
			writeLine(System.getProperty("line.separator"));
		}
	}
}
