package com.mbesutti.seminarweb.html;

import java.util.ArrayList;
import java.util.List;

public class HtmlTable implements HtmlElement{

	private String[] _columns;
	private final List<List<HtmlElement>> _rows;
	
	public HtmlTable() {
		_rows = new ArrayList<List<HtmlElement>>();
	}
	
	public void setHeaders(String... columns) {
		_columns = columns;
	}
	
	public void addRow(List<HtmlElement> cells){
		_rows.add(cells);
	}
	
	public void addRow(String... cells){
		List<HtmlElement> htmlCells = new ArrayList<HtmlElement>();
		for (String row : cells) {
			HtmlSpan cell = new HtmlSpan(row);
			htmlCells.add(cell);
		}
		_rows.add(htmlCells);
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
		for (List<HtmlElement> row : _rows) {
			string += "<tr>";
			for (HtmlElement value : row) {
				string+="<td>"+value.build()+"</td>";
			}
			string += "</tr>";
		}
		string += "</tbody>";
		string += "</table>";
		return string;
	}

}
