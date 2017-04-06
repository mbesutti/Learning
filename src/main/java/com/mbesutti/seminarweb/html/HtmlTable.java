package com.mbesutti.seminarweb.html;

import java.util.ArrayList;
import java.util.List;

public class HtmlTable implements HtmlElement{

	private String[] _columns;
	private final List<String[]> _rows;
	
	public HtmlTable() {
		_rows = new ArrayList<String[]>();
	}
	
	public void setHeaders(String... columns) {
		_columns = columns;
	}
	
	public void addRow(String... row){
		_rows.add(row);
	}

	@Override
	public String build() {
		String string = "<table class=\"table\">"+
						"<thead>"+
							"<tr>";
		for (String col : _columns) {
			string += "<th>"+col+"</th>";
		}
		string +=			"</tr>"+
						"</thead>"+
						"<tbody>";
		for (String[] row : _rows) {
			string += "<tr>";
			for (String value : row) {
				string+="<td>"+value+"</td>";
			}
			string += "</tr>";
		}
		string += "</tbody>";
		string += "</table>";
		return string;
	}

}
