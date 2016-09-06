package com.mbesutti.presenterPicker;

public class ValueRetriever {
	public static String fromArgument(String args, String separator) {
		return args.substring(args.indexOf(separator)+1, args.length());
	}
}
