package com.mbesutti.presenterPicker;

import java.io.IOException;
import java.util.ArrayList;

public class PresenterPicker {
	private static final String CSV_SEPARATOR = ";";

	public static void main(String[] arguments) throws IOException {
		Args args = new Args(arguments);
		Course repository = new Course();
		if (args.empty()) {
			System.out.println("Presenter: " + Picker.pickFrom(repository.all()));
			return;
		}
		if (args.on("help")) {
			StringBuilder help = new StringBuilder();
			help.append("Possible arguments:");
			help.append("\n<no arguments> -> get random presenter");
			help.append("\nadd:<name>");
			help.append("\nremove:<name>");
			help.append("\nlist");
			help.append("\nhtml");
			help.append("\ncsv");
			System.out.println(help.toString());
		} else if (args.on("add")) {
			repository.add(args.value());
		} else if (args.on("remove")) {
			repository.remove(args.value());
		} else if (args.on("list")) {
			PresenterPicker.printAsList(repository);
		}
		else if (args.on("html")) {
			PresenterPicker.printAsHtml(repository);
		}
		else if (args.on("csv")) {
			PresenterPicker.printAsCsv(repository);
		}
	}
	
	public static void printAsList(Course course) throws IOException {
		System.out.println("Presenters:");
		for (String presenter : course.all()) {
			System.out.println("- " + presenter);
		}
	}
	
	public static void printAsHtml(Course course) throws IOException {
		ArrayList<String> lines =  new ArrayList<String>();
		lines.add("<html>");
		lines.add("<head>");
		lines.add("\t<title>"+course.getName()+"</title>");
		lines.add("</head>");
		lines.add("<body>");
		lines.add("\t<div>"+course.getName()+"</div>");
		lines.add("\t<ul>");
		lines.add("\t\t<li>"+course.getDescription()+"</li>");
		lines.add("\t\t<li>"+course.getLocation()+"</li>");
		lines.add("\t\t<li>"+course.getRemainingSeats()+"</li>");
		lines.add("\t<ul>");
		lines.add("\t<div>Partecipanti</div>");
		for (String presenter : course.all()) {
			lines.add("\t<ul>");
			lines.add("\t\t<li>"+presenter+"</li>");
			lines.add("\t<ul>");
		}
		lines.add("</body>");
		lines.add("</html>");
		
		for (String line : lines) {
			System.out.println(line);
		}
	}
	
	public static void printAsCsv(Course course) throws IOException {
		ArrayList<String> lines =  new ArrayList<String>();
		lines.add("\""+course.getName()+"\""+CSV_SEPARATOR
				+"\""+course.getDescription()+"\""+CSV_SEPARATOR
				+"\""+course.getLocation()+"\""+CSV_SEPARATOR
				+"\""+course.getRemainingSeats()+"\"");
		lines.addAll(course.all());
		
		for (String line : lines) {
			System.out.println("\""+line+"\"");
		}
	}
}
