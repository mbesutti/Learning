package com.mbesutti.seminar.tests;

import org.junit.Assert;
import org.junit.Test;

import com.mbesutti.seminar.Course;
import com.mbesutti.seminar.Enrollment;
import com.mbesutti.seminar.Seminar;
import com.mbesutti.seminar.Student;
import com.mbesutti.seminar.printers.HtmlSeminarPrinter;
import com.mbesutti.seminar.printers.RowSeminarPrinter;
import com.mbesutti.seminar.printers.SeminarPrinter;

public class SeminarTests {
	@Test
	public void printRowSeminar() {
		SeminarPrinter htmlPrinter = new RowSeminarPrinter();
		Course course = new Course();
		course.name = "Corso 1";
		course.description = "Descrizione 1";
		Seminar seminar = new Seminar(course);
		seminar.location = "Sala 1";
		Student student1 = new Student();
		student1.firstName = "Nome 1";
		student1.lastName = "Cognome 1";
		Student student2 = new Student();
		student2.firstName = "Nome 2";
		student2.lastName = "Cognome 2";
		seminar.totalSeats = 2;
		seminar.enrollments.add(new Enrollment(student1));
		seminar.enrollments.add(new Enrollment(student2));
		
		Assert.assertEquals("Course: Corso 1\n"
								+"Description: Descrizione 1\n"
								+"Location: Sala 1\n"
								+"Remaining seats: 0\n"
								+"Partecipants: \n"
								+"- Nome 1 Cognome 1\n"
								+"- Nome 2 Cognome 2", htmlPrinter.print(seminar));
	}
	
	@Test
	public void printHtmlSeminar() {
		SeminarPrinter htmlPrinter = new HtmlSeminarPrinter();
		Course course = new Course();
		course.name = "Corso 1";
		course.description = "Descrizione 1";
		Seminar seminar = new Seminar(course);
		seminar.location = "Sala 1";
		Student student1 = new Student();
		student1.firstName = "Nome 1";
		student1.lastName = "Cognome 1";
		Student student2 = new Student();
		student2.firstName = "Nome 2";
		student2.lastName = "Cognome 2";
		seminar.totalSeats = 2;
		seminar.enrollments.add(new Enrollment(student1));
		seminar.enrollments.add(new Enrollment(student2));
		
		Assert.assertEquals("<head>\n"
									+"	<title>Corso 1</title>\n"
									+"</head>\n"
									+"<body>\n"
									+"	<li>Corso 1</li>\n"
									+"	<ul>\n"
									+"		<li>Descrizione 1</li>\n"
									+"		<li>Sala 1</li>\n"
									+"		<li>0</li>\n"
									+"	</ul>\n"
									+"	<li>Partecipants</li>\n"
									+"	<ul>\n"
									+"		<li>Nome 1 Cognome 1</li>\n"
									+"		<li>Nome 2 Cognome 2</li>\n"
									+"	</ul>\n"
									+"</body>", htmlPrinter.print(seminar));
	}
}
