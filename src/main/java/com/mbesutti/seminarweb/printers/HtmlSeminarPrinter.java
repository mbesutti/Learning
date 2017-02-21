package com.mbesutti.seminarweb.printers;

import java.util.ArrayList;

import com.mbesutti.seminarweb.seminar.Seminar;
import com.mbesutti.seminarweb.seminar.Student;

public class HtmlSeminarPrinter implements SeminarPrinter {

	public String print(Seminar seminar) {
		ArrayList<String> lines = new ArrayList<String>();
		ArrayList<String> head = HtmlTag.head(HtmlTag.title(seminar.getCourse().getName()));
		ArrayList<String> bodyContent = new ArrayList<String>();
		bodyContent.addAll(HtmlTag.div(seminar.getCourse().getName()));
		ArrayList<String> courseInfo = new ArrayList<String>();
		courseInfo.addAll(HtmlTag.li(seminar.getCourse().getDate()));
		courseInfo.addAll(HtmlTag.li(seminar.getCourse().getDescription()));
		courseInfo.addAll(HtmlTag.li(seminar.getLocation()));
		courseInfo.addAll(HtmlTag.li(String.valueOf(seminar.getSeatsLeft())));
		courseInfo.addAll(HtmlTag.div("Partecipants"));
		ArrayList<String> partecipantList = new ArrayList<String>();
		for (Student student : seminar.getStudentsList()) {
			partecipantList.addAll(HtmlTag.li(student.getFullName()));
		}
		courseInfo.addAll(HtmlTag.ul(partecipantList));
		bodyContent.addAll(HtmlTag.ul(courseInfo));
		ArrayList<String> body = HtmlTag.body(bodyContent);
		
		lines.addAll(head);
		lines.addAll(body);
		HtmlTag.html(lines);
		
		String result = "";
		for (String line : lines) {
			System.out.println(line);
			result += line + "\n";
		}
		return result.substring(0, result.lastIndexOf("\n"));
	}

}
