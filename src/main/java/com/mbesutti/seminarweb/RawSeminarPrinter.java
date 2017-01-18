package com.mbesutti.seminarweb;

import java.util.ArrayList;

import com.mbesutti.seminarweb.seminar.Seminar;
import com.mbesutti.seminarweb.seminar.Student;

public class RawSeminarPrinter implements SeminarPrinter {

	public String print(Seminar seminar) {
		ArrayList<String> lines = new ArrayList<String>();
		lines.add("Course: "+seminar.getCourse().getName());
		lines.add("Date: "+seminar.getCourse().getDate());
		lines.add("Description: "+seminar.getCourse().getDescription());
		lines.add("Location: "+seminar.getLocation());
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
