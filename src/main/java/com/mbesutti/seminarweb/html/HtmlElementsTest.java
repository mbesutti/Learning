package com.mbesutti.seminarweb.html;

import static org.junit.Assert.*;

import org.junit.Test;

public class HtmlElementsTest {
	@Test
	public void form() {
		HtmlForm form = new HtmlForm("/course/add");
		form.addInput("Name", HtmlForm.TEXT, "Course1");
		form.addSubmit("Create");
		
		assertEquals("<form class='form-horizontal' role='form' method='post' action='/course/add'>"
						+ "<div class='form-group'>"
							+ "<label for='Name' class='col-sm-2 control-label'>Name</label>"
							+ "<div class='col-sm-10'>"
								+ "<input type='text' class='form-control' id='Name' name='name' placeholder='Course1' value='Course1'>"
								+ "<div class='col-xs-12 messageContainer'></div>"
							+ "</div>"
						+ "</div>"
						+ "<div class='form-group'>       "
							+ "<div class='col-sm-10 col-sm-offset-2'>       "
								+ "<input id='submit' name='submit' type='submit' value='Create' class='btn btn-primary'>    "
							+ "</div>"
						+ "</div>"
					+ "</form>", form.build());
	}
	
	@Test
	public void link() {
		HtmlElement link = new HtmlLink("List", "/course");
		
		assertEquals("<a href=\"/course\" class=\"btn btn-primary\">List</a>", link.build());
	}
	
	@Test
	public void table() {
		HtmlTable table = new HtmlTable();
		table.setHeaders("Name", "Date", "Description");
		table.addRow("name", "date", "description");
		assertEquals("<table class=\"table\">"
						+ "<thead>"
							+ "<tr>"
								+ "<th>Name</th>"
								+ "<th>Date</th>"
								+ "<th>Description</th>"
							+ "</tr>"
						+ "</thead>"
						+ "<tbody>"
							+ "<tr>"
								+ "<td>name</td>"
								+ "<td>date</td>"
								+ "<td>description</td>"
							+ "</tr>"
						+ "</tbody>"
					+ "</table>", table.build());
	}
}
