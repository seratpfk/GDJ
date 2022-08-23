package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ApiMain {
	
	public static void m1() {
		String key = "0%2BKGdm6YrHSXA95CGIey5Sk0Sahzg8aiIbzdSRfUSCSABUGREXTJKtUr3IO%2B48dPKEQEZudz2n78Q%2Ftx5pHIBQ%3D%3D";

		Scanner sc = new Scanner(System.in);
		System.out.print("년도(yyyy) >>> ");
		String searchYear = sc.next();
		
		try {
			key = URLEncoder.encode(key, "UTF-8");
			searchYear = URLEncoder.encode(searchYear, "UTF-8");
		} catch(UnsupportedEncodingException e) {
			throw new RuntimeException("인코딩 실패", e);
		}
		
		String apiURL = "http://apis.data.go.kr/B552061/AccidentDeath" + key + "&searchYear=" + searchYear;
		
		String response = getResponse(apiURL);
		createFile(response);

	}

	public static String getResponse(String apiURL) {
		HttpURLConnection con = getConnection(apiURL);
		try {
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				return readBody(con.getInputStream());
			} else {
				return readBody(con.getErrorStream());
			}
		} catch(IOException e) {
			throw new RuntimeException("API 요청 오류", e);
		}
	}
	
	public static HttpURLConnection getConnection(String apiURL) {
		try {
			URL url = new URL(apiURL);
			return (HttpURLConnection)url.openConnection();
		} catch(MalformedURLException e) {
			throw new RuntimeException("API 주소 오류", e);
		} catch(IOException e) {
			throw new RuntimeException("API 연결 오류", e);
		}
	}
	
	public static String readBody(InputStream in) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			return sb.toString();
		} catch(IOException e) {
			throw new RuntimeException("API 응답 오류", e);
		}
	}
	
	public static void createFile(String response) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("accident.txt"))) {
			bw.write(response);
			bw.flush();
		} catch(IOException e) {
			throw new RuntimeException("파일 생성 오류", e);
		}
	}
	
	public static void m2() {
		
		File file = new File("accident.txt");
		List<Accident> accients = new ArrayList<>();
		
		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			NodeList accidentList = doc.getElementsByTagName("accident");
			
			for(int i = 0; i < accidentList.getLength(); i++) {
				
				Element accident = (Element)accidentList.item(i);
				String occrrncDt = accident.getElementsByTagName("occrrncDt").item(0).getTextContent();
				String occrrncDayCd = accident.getElementsByTagName("occrrncDayCd").item(0).getTextContent();
				//int dthDnvCnt = accident.getElementsByTagName("dthDnvCnt").item(0).getTextContent();
				//int injpsnCnt = accident.getElementsByTagName("injpsnCnt").item(0).getTextContent();
				
				Accident acc = Accident.builder()
						.occrrncDt(occrrncDt)
						.occrrncDayCd(occrrncDayCd)
						//.dthDnvCnt(dthDnvCnt)
						//.injpsnCnt(injpsnCnt)
						.build();
				
				accients.add(acc);
				
			}  
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		for(Accident acc : accients) {
			System.out.println(acc);
		}
	}

	public static void main(String[] args) {
		
		m1();
		m2();
		
		

	}

}
