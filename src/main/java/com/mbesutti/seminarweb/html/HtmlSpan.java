package com.mbesutti.seminarweb.html;

public class HtmlSpan implements HtmlElement {

	private final String _value;

	public HtmlSpan(String value) {
		_value = value;
	}

	@Override
	public String build(){
		return "<span>" + _value + "</span>";
	}
}
