package com.mbesutti.seminarweb.printers;

import java.util.ArrayList;
import java.util.List;

import com.mbesutti.seminarweb.seminar.Seminar;
import com.mbesutti.seminarweb.seminar.Student;

public class CsvSeminarPrinter implements SeminarPrinter {
	private static final String CSV_SEPARATOR = ";";

	public String print(Seminar seminar) {
		
		ArrayList<String> lines =  new ArrayList<String>();
		lines.add("\""+seminar.getCourse().getName()+"\""+CSV_SEPARATOR
				+"\""+seminar.getCourse().getDate()+"\""+CSV_SEPARATOR
				+"\""+seminar.getCourse().getDescription()+"\""+CSV_SEPARATOR
				+"\""+seminar.getLocation()+"\""+CSV_SEPARATOR
				+"\""+seminar.getSeatsLeft()+"\""+CSV_SEPARATOR);
		
		for (Student student : seminar.getStudentsList()) {
			lines.add("\""+student.getFirstName()+"\""+CSV_SEPARATOR
					+"\""+student.getLastName()+"\""+CSV_SEPARATOR);
		}
		
		String result = "";
		for (String line : lines) {
			System.out.println(line);
			result += line + "\n";
		}
		
		return result.substring(0, result.lastIndexOf("\n"));
	}

}
