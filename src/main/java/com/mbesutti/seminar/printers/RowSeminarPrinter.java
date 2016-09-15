package com.mbesutti.seminar.printers;

import java.util.ArrayList;

import com.mbesutti.seminar.Seminar;
import com.mbesutti.seminar.Student;

public class RowSeminarPrinter implements SeminarPrinter {

	public String print(Seminar seminar) {
		ArrayList<String> lines = new ArrayList<String>();
		lines.add("Course: "+seminar.course.name);
		lines.add("Description: "+seminar.course.description);
		lines.add("Location: "+seminar.location);
		lines.add("Remaining seats: "+seminar.getSeatsLeft());
		lines.add("Partecipants: ");
		for (Student student : seminar.getStudentsList()) {
			lines.add("- "+student.getFullName());
		}
		String result = "";
		for (String line : lines) {
			System.out.println(line);
			result += line + "\n";
		}
		return result.substring(0, result.lastIndexOf("\n"));
	}
	
}
