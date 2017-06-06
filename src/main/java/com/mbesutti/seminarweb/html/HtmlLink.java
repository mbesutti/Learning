package com.mbesutti.seminarweb.html;

public class HtmlLink implements HtmlElement {

	private final String _value;
	private final String _url;

	public HtmlLink(String value, String url) {
		_value = value;
		_url = url;
		
	}

	@Override
	public String build() {
		return "<a href=\""+_url+"\">"+_value+"</a>";
//		return "<a href=\""+_url+"\" class=\"btn btn-primary\">"+_value+"</a>";
	}

}
