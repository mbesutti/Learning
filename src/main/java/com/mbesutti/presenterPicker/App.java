package com.mbesutti.presenterPicker;

import java.io.IOException;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
    	PresentersFactory presentersFactory = new PresentersFactory();
    	if (args.length == 0) {
	    	String presenter = Picker.pickFrom(presentersFactory.all());
	    	System.out.println("Presenter: "+presenter);
	    	return;
    	}
    	
    	for (String parameter : args) {
    		if (parameter.equals("help")) {
        		StringBuilder help = new StringBuilder();
        		help.append("Possible arguments:");
        		help.append("\n><no arguments> -> get random presenter");
        		help.append("\nadd:<name>");
//    			help.append("\n- remove:<name>");
    			help.append("\nlist");
        		System.out.println(help.toString());
        	}
    		else if (parameter.contains("add")) {
				presentersFactory.add(ValueRetriever.fromArgument(parameter, ":"));
    		}
//    		else if (parameter.contains("remove")) {
//    			presentersFactory.remove(ValueRetriever.fromArgument(parameter, ":"));
//    		}
    		else if (parameter.contains("list")) {
    			System.out.println("Presenters:");
    			for (String presenter : presentersFactory.all()) {
					System.out.println("- "+presenter);
				}
    		}
		}
    }
}
