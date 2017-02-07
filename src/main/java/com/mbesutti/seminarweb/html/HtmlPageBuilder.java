package com.mbesutti.seminarweb.html;

import java.util.ArrayList;

public class HtmlPageBuilder {
	ArrayList<HtmlElement> elements = new ArrayList<HtmlElement>();

	public void add(HtmlElement item) {
		elements.add(item);
	}

	public String build(String title) {
		String result = "<!DOCTYPE html>                                                                                                                                 " +
				"<html lang='en'>                                                                                                                                " +
				"  <head>                                                                                                                                        " +
				"    <meta charset='utf-8'>                                                                                                                      " +
				"    <meta http-equiv='X-UA-Compatible' content='IE=edge'>                                                                                       " +
				"    <meta name='viewport' content='width=device-width, initial-scale=1'>                                                                        " +
				"    <title>Seminar</title>                                                                                      								 " +
				"    <link rel='stylesheet' href='/css/bootstrap.min.css'>                                        												 " +
				"  </head>                                                                                                                                       " +
				"  <body>                                                                                                                                        " +
				"  	<div class='container'>                                                                                                                      " +
				"  		<div class='row'>                                                                                                                        " +
				"  			<div class='col-md-6 col-md-offset-3'>                                                                                               " +
				"  				<h1 class='page-header text-center'>" + title + "</h1>                                                                    ";
		
		for (HtmlElement htmlElement : elements) {
			result += htmlElement.build();
		}
		
		result += "			</div>                                                                                                                               " +
				"		</div>                                                                                                                                   " +
				"	</div>                                                                                                                                       " +
				"    <script src='/js/jquery.min.js'></script>                                                   												 " +
				"    <script src='/js/bootstrap.min.js'></script>                                                 												 " +
				"  <body> ";
		return result;
	}

}
