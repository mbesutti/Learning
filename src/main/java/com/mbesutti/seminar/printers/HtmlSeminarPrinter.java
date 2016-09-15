package com.mbesutti.seminar.printers;

import java.util.ArrayList;

import com.mbesutti.seminar.Enrollment;
import com.mbesutti.seminar.Seminar;

public class HtmlSeminarPrinter implements SeminarPrinter {

	public String print(Seminar seminar) {
		ArrayList<String> lines = new ArrayList<String>();
		ArrayList<String> head = HtmlTag.head(HtmlTag.title(seminar.course.name));
		ArrayList<String> bodyContent = new ArrayList<String>();
		bodyContent.addAll(HtmlTag.div(seminar.course.name));
		ArrayList<String> courseInfo = new ArrayList<String>();
		courseInfo.addAll(HtmlTag.li(seminar.course.description));
		courseInfo.addAll(HtmlTag.li(seminar.location));
		courseInfo.addAll(HtmlTag.li(String.valueOf(seminar.getSeatsLeft())));
		bodyContent.addAll(HtmlTag.ul(courseInfo));
		bodyContent.addAll(HtmlTag.div("Partecipants"));
		ArrayList<String> partecipantList = new ArrayList<String>();
		for (Enrollment enrollment : seminar.enrollments) {
			partecipantList.addAll(HtmlTag.li(enrollment.getInfo()));
		}
		bodyContent.addAll(HtmlTag.ul(partecipantList));
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
