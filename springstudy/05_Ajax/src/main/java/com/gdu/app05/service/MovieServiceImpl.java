package com.gdu.app05.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MovieServiceImpl implements MovieService {

	@Override
	public String getBoxOffice(String targetDt) {

		// key
		String key = "d6e2ee9feb305c257f6518f63f4eea9a";
		
		// ApiURL
		String apiURL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
		apiURL += "?key=" + key + "&targetDt=" + targetDt;
		
		// API ��û
		URL url = null;
		HttpURLConnection con = null;
		try {
			url = new URL(apiURL); // MalformedURLException
			con = (HttpURLConnection) url.openConnection(); // IOException
			con.setRequestMethod("GET"); // "GET"�� �빮�ڷ� ����
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// API ����
		StringBuilder sb = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()))) { // try-catch-resources���� �ڿ��� close�� ������ �� �ִ�.
			String line = null;
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// con �ݱ�
		con.disconnect();
		System.out.println(sb.toString());
		// ��ȯ (API�κ��� ������ ��� �ؽ�Ʈ ����)
		System.out.println(sb.toString());
		return sb.toString();
	}

}
