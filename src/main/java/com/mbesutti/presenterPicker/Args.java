package com.mbesutti.presenterPicker;

import java.util.Arrays;

public class Args {
	private static final String SEPARATOR = ":";
	private final String[] _args;

	public Args(String[] args) {
		_args = args;
	}

	private String getParameter() {
		return _args[0];
	}
	
	private String[] getParameters() {
		return _args;
	}

	public String firstValue() {
		String[] parameter = getParameters();
		return parameter[1];
	}
	
	public String[] allValues() {
		String[] parameters = getParameters();
		String[] values = Arrays.copyOfRange(parameters, 1, parameters.length);
		return values;
	}

	public boolean on(String command) {
		return getParameter().contains(command);
	}
	
	public boolean empty() {
		return _args.length == 0;
	}
}
