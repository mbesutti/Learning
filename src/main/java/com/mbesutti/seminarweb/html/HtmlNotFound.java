package com.mbesutti.seminarweb.html;

import java.util.HashMap;
import java.util.Map;


public class HtmlNotFound implements HtmlElement {
	
	Map<String, String> _redirects = new HashMap<String, String>();
	
	public void addRedirectLink(String value, String url){
		_redirects.put(value, url);
	}

	public String build() {
		String result = "<div class=\"container\">"+
				"    <div class=\"row\">"+
				"        <div class=\"col-md-12\">"+
				"            <div class=\"error-template\">"+
				"		<h1>Oops!</h1>"+
				"	    <h2>404 Not Found</h2>"+
				"	    <div class=\"error-details\">"+
				"			Sorry, an error has occured, Requested page not found!<br>"+
				"	    </div>"+
				"	    <div class=\"error-actions\">";
		for (String key : _redirects.keySet()) {
			result += "		<a href=\""+_redirects.get(key)+"\" class=\"btn btn-primary\">"+key+"</a>";
			 
		}
		result += "			 </div>"+
				  "			 </div>"+
				  "			 </div>"+
				  "			 </div>"+
				  "			 </div>";
		return result;
	}

}
