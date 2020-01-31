package com.test.utilities;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BasicUtilities 
{
	public boolean checkBrokenLink(String link) {
		boolean status = false;
		String responseCode = null;
		try {
			HttpURLConnection con = (HttpURLConnection)(new URL(link)).openConnection();
			con.connect();
			responseCode = Integer.toString(con.getResponseCode());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(responseCode.equals("200") || responseCode.equals("201"))
		{
			status = true;
		}
		
		return status;
	}
}
