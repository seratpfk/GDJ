package com.gdu.papago;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import org.json.JSONObject;

public class ApiPapago {

	public static void main(String[] args) {
		
		String clientId = "7xL29rdSpxmE1AqWx3Zs";
		String clientSecret = "T83O5ZjJWu";
		
		try {

			Scanner sc = new Scanner(System.in);
			System.out.println("한국어를 입력하세요. >>> ");
			String kor = sc.nextLine();
			
			// api 요청
			String apiURL = "https://openapi.naver.com/v1/papago/n2mt";  // 파파고 요청 주소
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			con.setRequestMethod("POST");
			con.setRequestProperty("X-naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			
			// 데이터를 파라미터로 받아 옴.
			con.setDoOutput(true);
			String parameters = "source=ko&target=en&text=" + URLEncoder.encode(kor, "UTF-8");
			try (DataOutputStream dos = new DataOutputStream(con.getOutputStream())) {
				dos.write(parameters.getBytes());
				dos.flush();
			}
			
			// 데이터를 읽어들일 Reader
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
			
			// System.out.println(sb.toString());
			// {"message":{"result":{"srcLangType":"ko","tarLangType":"en","translatedText":"The weather right now","engineType":"N2MT","pivot":null,"dict":null,"tarDict":null},"@type":"response","@service":"naverservice.nmt.proxy","@version":"1.0.0"}}
			
			// {}로 시작하면 JSONObject
			// json.jar 파일 추가
			
			// JSONObject로 한줄씩 띄어쓰기
			JSONObject obj = new JSONObject(sb.toString());
			String translatedText = obj.getJSONObject("message").getJSONObject("result").getString("translatedText");
			// System.out.println(translatedText);
			// Weather
			
			// 파일 만들고 그 안에 내용 저장하기
			File dir = new File("C:" + File.separator + "download");  //  File.separator : 경로 구분
			if(dir.exists() == false) {
				dir.mkdirs();
			}
			
			String filename = System.currentTimeMillis() + ".txt";
			File file = new File(dir, filename);
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(kor + " -> " + translatedText);  // 파일을 열면 화요일 -> Tuesday 형식이 생김.
			bw.flush();
			
			bw.close();
			br.close();
			con.disconnect();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
