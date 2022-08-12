package ex01_network;

import java.net.MalformedURLException;
import java.net.URL;


public class Main {
	
	public static void m1() {
		
		// URL
		// 1. Uniform Resource Locator
		// 2. 정형화된 자원의 경로
		// 3. 웹 주소를 의미
		// 4. 구성
		//    프로토콜://   호스트       /  서버경로  ?파라미터=값&파라미터=값
		//       https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EB%82%A0%EC%94%A8
		//    1) https : secure http, 하이퍼텍스트 전송 프로토콜(통신규약)
		//    2) 호스트 : 서버주소
		//    3) 서버경로 : URL Mapping
		//    4) 파라미터 : 서버로 전송하는 데이터
		
	try {
		// URL 처리를 위한 URL 클래스
		String apiURL = "https://search.naver.com/search.naver?query=날씨";
		URL url = new URL(apiURL);
			
		// URL 확인
		System.out.println("프로토콜 : " + url.getProtocol());
		System.out.println("호스트 : " + url.getHost());
		System.out.println("파라미터 : " + url.getQuery());
		
		} catch(MalformedURLException e) {
			System.out.println("API 주소 오류");
		}
	}

	public static void main(String[] args) {
		
		m1();

	}

}
