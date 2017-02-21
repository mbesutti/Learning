package com.mbesutti;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.commons.codec.binary.Base64;

public class b2b_integration {
	public static void main(String[] args) throws Exception {
		String xml = cardNumberRequest();
		String data = "xml=" + URLEncoder.encode(xml, "UTF-8");
		System.out.println(URLEncoder.encode("John & Co"));
		//String data = "xml=" + xml;
		
		URL url = new URL("https://testgateway.mfgroup.ch/");
		URLConnection connection = url.openConnection();
		String authString = "eurotradeSimulation:P8o0xzfw";
		String encoded = new String(Base64.encodeBase64(authString.getBytes()));
		connection.setDoOutput(true);
		connection.setRequestProperty("Authorization", "Basic " + encoded);

		final OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
		writer.write(data);
		writer.flush();

		final BufferedReader reader = new BufferedReader(
		new InputStreamReader(connection.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		writer.close();
		reader.close();
	}

	private static String cardNumberRequest() {
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+
				"<cardNumberRequest protocol=\"getVirtualCardNumber\" version=\"2.9\">"+
				"  <externalReference>288198</externalReference>"+
				"  <companyName>Plutronics &amp; co</companyName>"+
				"  <legalForm>ag</legalForm>"+
				"  <companyRegistrationNumber>CHE-114.817.641</companyRegistrationNumber>"+
				"  <gender>male</gender>"+
				"  <firstName>Chicco</firstName>"+
				"  <lastName>Buch</lastName>"+
				"  <street>Bergstrasse 14B</street>"+
				"  <city>Zurich</city>"+
				"  <zip>5432</zip>"+
				"  <country>CH</country>"+
				"  <language>de</language>"+
				"  <email>h.bachplutronics.ch</email>"+
				"  <birthdate>1984-02-06</birthdate>"+
				"  <merchantId>15533</merchantId>"+
				"  <filialId>100</filialId>"+
				"  <terminalId>3322</terminalId>"+
				"  <amount>13170</amount>"+
				"  <currencyCode>CHF</currencyCode>"+
				"</cardNumberRequest>";
	}
}
