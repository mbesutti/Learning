package com.mbesutti.seminarweb.html;

import java.util.ArrayList;

public class HtmlForm implements HtmlElement {
	public static final String TEXT = "text";
	public static final String EMAIL = "email";
	
	ArrayList<String> inputs = new ArrayList<String>();
	
	public void addInput(String label, String type, String placeholder) {
		String input = "<div class='form-group'>" +
						"<label for='"+label+"' class='col-sm-2 control-label'>"+label+"</label>" +
							"<div class='col-sm-10'>" +
								"<input type='" + type + "' class='form-control' id='"+label+"' name='"+label+"' placeholder='"+placeholder+"' value='"+placeholder+"'>" +
							"</div>" +
						"</div>";
		inputs.add(input);
	}
	
	public String build(){
		String result = "<form class='form-horizontal' role='form' method='post' action='index.php'>";
		for (String input : inputs) {
			result += input;
		}
		result += "<div class='form-group'>"+
		        "       <div class='col-sm-10 col-sm-offset-2'>"+
		        "       <input id='submit' name='submit' type='submit' value='Send' class='btn btn-primary'>"+
		        "    </div>"+
		        "</div>";
		result += "</form>";
		return result;
	}

}
