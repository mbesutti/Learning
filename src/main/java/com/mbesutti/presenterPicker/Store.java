package com.mbesutti.presenterPicker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Store {
	private final File _file;

	public Store(String fileName) {
		String today = new SimpleDateFormat("yyyy.MM.dd").format(new Date());
		_file = new File(today + " " + fileName);
	}

	public Store(String fileName, String date) {
		_file = new File(date + " " + fileName);
	}
	
	public static ArrayList<String> backups(final String fileName){
		ArrayList<String> backups = new ArrayList<String>();
		File dir = new File(".");
		File [] files = dir.listFiles(new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.contains(fileName);
		    }
		});
		for (File xmlfile : files) {
		    backups.add(xmlfile.getName());
		}
		return backups;
	}
	
	public boolean isEmpty() {
		return !_file.exists();
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
		fw.append(System.getProperty("line.separator"));
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
		}
	}
}
