package com.mbesutti.presenterPicker;

public class Args {
	private static final String SEPARATOR = ":";
	private final String[] _args;

	public Args(String[] args) {
		_args = args;
	}

	private String getParameter() {
		return _args[0];
	}

	public String value() {
		String parameter = getParameter();
		return parameter.substring(parameter.indexOf(SEPARATOR)+1, parameter.length());
	}

	public boolean on(String command) {
		return getParameter().contains(command);
	}
	
	public boolean empty() {
		return _args.length == 0;
	}
}
