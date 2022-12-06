package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Scanner;

import org.json.JSONObject;





public class ApiSearchBook {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("책 제목을 입력해주세요. >>> ");
		String search = sc.next();

		
		String clientId = "7xL29rdSpxmE1AqWx3Zs";
		String clientSecret = "T83O5ZjJWu";
		
		try {
			
			String apiURL = "https://openapi.naver.com/v1/search/book?query=" + search;
				
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			BufferedReader br = null;
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			StringBuilder sb = new StringBuilder();
			String line;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
			con.disconnect();
			
			JSONObject obj = new JSONObject(sb.toString());
			
			File dir = new File("C:/download");  
			if(dir.exists() == false) {
				dir.mkdirs();
			}
			File file = new File(dir, search + ".html");
			PrintWriter out = new PrintWriter(file);
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<title>졸려졸려너무졸려</title>");
			out.println("</head>");
			out.println("<body>");
			
			out.println("</body>");
			out.println("</head>");
			out.close();
			
		} catch(Exception e) {
			
			try {
				
				File dir = new File("C:/download/log");
				if(dir.exists() == false) {
					dir.mkdirs();
				}
				File file = new File(dir, "error_log.txt");
				PrintWriter out = new PrintWriter(file);
				out.println();
				out.close();
			} catch (Exception e2) {
				System.err.println("예외발생시간 : " + new Date());
				System.out.println("예외메시지" + e.getMessage());
				e2.printStackTrace();
			}
			
		}

	}

}
