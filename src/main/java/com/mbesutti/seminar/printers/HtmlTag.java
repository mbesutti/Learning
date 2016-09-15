package com.mbesutti.seminar.printers;

import java.util.ArrayList;

public class HtmlTag {
	public static ArrayList<String> html(ArrayList<String> content) {
		return tagContainer("html", content);
	}
	
	public static ArrayList<String> head(ArrayList<String> content) {
		return tagContainer("head", content);
	}
	
	public static ArrayList<String> title(String content) {
		return tag("title", content);
	}
	
	public static ArrayList<String> body(ArrayList<String> content) {
		return tagContainer("body", content);
	}
	
	public static ArrayList<String> ul(ArrayList<String> content) {
		return tagContainer("ul", content);
	}
	
	public static ArrayList<String> div(ArrayList<String> content) {
		return tagContainer("div", content);
	}
	
	public static ArrayList<String> div(String content) {
		return tag("li", content);
	}
	
	public static ArrayList<String> li(String content) {
		return tag("li", content);
	}
	
	private static ArrayList<String> tag(String name, String content){
		ArrayList<String> result = new ArrayList<String>();
		result.add("<" + name + ">"+content+"</" + name + ">");
		return result;
	}
	
	private static ArrayList<String> tagContainer(String name, ArrayList<String> content){
		ArrayList<String> result = new ArrayList<String>();
		result.add("<" + name + ">");
		for (String line : content) {
			result.add("\t"+line);
		}
		result.add("</" + name + ">");
		return result;
	}
}
