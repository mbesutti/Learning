package com.mbesutti.seminarweb.html;

import java.util.ArrayList;

public class HtmlForm implements HtmlElement {
	public static final String TEXT = "text";
	public static final String SUBMIT = "submit";
	
	ArrayList<String> inputs = new ArrayList<>();
	private final String _destination;
	
	public HtmlForm(String destination) {
		_destination = destination;
		
	}
	
	public void addInput(String label, String type, String placeholder, String error) {
		boolean hasError = error!=null&&!error.isEmpty();
		String formHasError = hasError?" has-error has-feedback":"";
		String errorMessage = hasError?error:"";
		inputs.add("<div class='form-group"+formHasError+"'>" +
						"<label for='"+label+"' class='col-sm-2 control-label'>"+label+"</label>" +
						"<div class='col-sm-10'>" +
							"<input type='" + type + "' class='form-control' id='"+label+
								"' name='"+label.toLowerCase()+"' placeholder='"+placeholder+"' value='"+placeholder+"'>"+
							"<div class='col-xs-12 messageContainer'>"+errorMessage+"</div>" +
						"</div>" +
					"</div>");
	}
	
	public void addSubmit(String text){
		inputs.add("<div class='form-group'>"+
		        "       <div class='col-sm-10 col-sm-offset-2'>"+
		        "       <input id='submit' name='submit' type='submit' value='" + text + "' class='btn btn-primary'>"+
		        "    </div>"+
		        "</div>");
	}
	
	@Override
	public String build(){
		String result = "<form class='form-horizontal' role='form' method='post' action='" + _destination + "'>";
		for (String input : inputs) {
			result += input;
		}
		result += "</form>";
		return result;
	}

	public void addInput(String label, String type, String placeholder) {
		addInput(label, type, placeholder, null);
	}

}
