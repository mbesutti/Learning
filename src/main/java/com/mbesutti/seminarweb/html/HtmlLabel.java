package com.mbesutti.seminarweb.html;

public class HtmlLabel implements HtmlElement {

	private final String _value;

	public HtmlLabel(String value) {
		_value = value;
	}

	@Override
	public String build(){
		return "<label>" + _value + "</label>";
	}
}
