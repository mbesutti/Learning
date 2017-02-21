package com.mbesutti.seminarweb.html;

public class HtmlLink implements HtmlElement {

	private String _value;
	private String _url;

	public HtmlLink(String value, String url) {
		_value = value;
		_url = url;
		
	}

	public String build() {
		return "<a href=\""+_url+"\" class=\"btn btn-primary\">"+_value+"</a>";
	}

}
