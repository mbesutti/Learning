package com.mbesutti;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.commons.codec.binary.Base64;

public class TestCnrToTestEnv {
	public static void main(String[] args) throws Exception {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
			   	 + "<cardNumberRequest "
					 + "protocol=\"getVirtualCardNumber\" version=\"2.9\"> "
			   	 + "<externalReference>order-1454422507</externalReference> "
			   	 + "<gender>male</gender> "
				 + "<firstName>Fritz</firstName> "
			   	 + "<lastName>Bianchi</lastName> "
			   	 + "<street>Roten str</street> " + "<city>Sant Gallen</city> "
			   	 + "<zip>9000</zip> " + "<country>CH</country> "
			   	 + "<language>it</language> "
			   	 + "<email>test@mfgroup.ch</email> "
			 	 + "<birthdate>1975-03-06</birthdate> "
			  	 + "<merchantId>2345</merchantId> "
			   	 + "<filialId>3323</filialId> "
			   	 + "<terminalId>4436</terminalId> " + "<amount>1500</amount> "
			   	 + "<currencyCode>CHF</currencyCode> "
			   	 + "<companyName>MF Group</companyName> "
			   	 + "<legalForm>ag</legalForm> "
			   	 + "</cardNumberRequest>";
			String data = "xml=" + URLEncoder.encode(xml, "UTF-8");

			URL url = new URL("https://testgateway.mfgroup.ch");
			URLConnection connection = url.openConnection();
			String authString = "datatransTest:giveki68";
			String encoded = new String(Base64.encodeBase64(authString.getBytes()));
			connection.setDoOutput(true);
			connection.setRequestProperty("Authorization", "Basic " + encoded);

			OutputStream outputStream = connection.getOutputStream();
			final OutputStreamWriter writer = new OutputStreamWriter(outputStream);
			writer.write(data);
			writer.flush();

			final BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			writer.close();
			reader.close();
	}
}
