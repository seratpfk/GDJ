package com.gdu.app14.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;
import java.util.regex.Matcher;

import org.springframework.stereotype.Component;

@Component
public class MyFileUtil {

	// 파일명 : UUID(유니버셜 유니크 아이디)값을 사용
	// 경로명 : 현재 날짜를 디렉터리로 생성해서 사용
	
	public String getFilename(String filename) {
		
		// 확장자 예외 처리
		String extension = null;
		if(filename.endsWith("tar.gz")) {
			extension = "tar.gz";
		} else {
			// 파라미터로 전달된 filename의 확장자만 살려서 UUDI.확장자 방식으로 반환  
			/*
			장점
			1. 유니큐
			디렉터리 하나에 같은 이름은 하나만 들어갈 수 있음. 파일이름에 중복을 막기 위해 파일이름 중복을 임의로 막아줌.
			2. 인코딩
			pw.sha512처럼 파일이름을 암화화해서 저장됨. 인코딩이 필요없다.
			 */
			String[] arr = filename.split("\\.");  // 정규식에서 .(마침표) 인식 : \ 또는 [.]  // 자바는 \\를 \로 인식함. .를 모든 문자로 인식x, 마침표로 인식하라
			// String[] arr = filename.split("[.]");  // 이 방법도 마침표로 인식 함
			
			// 배열의 마지막 요소 : 길이 - 1
			// 확장자
			extension = arr[arr.length - 1];
		}
		
		// UUID 확장자
		return UUID.randomUUID().toString().replaceAll("//-", "") + "." + extension;  // .toString().replaceAll("//-", "") : -을 지우겠다. 
	}
	
	// 오늘 경로
	public String getTodayPath() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		String sep = Matcher.quoteReplacement(File.separator);
		return "storage" + sep + year + sep + makeZero(month) + sep + makeZero(day);
		
	}
	
	// 어제 경로
	public String getYesterdayPath() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);  // 1일 전
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		String sep = Matcher.quoteReplacement(File.separator);
		return "storage" + sep + year + sep + month + sep + day;
	}
	
	// 1~9 => 01~09
	public String makeZero(int n) {
		return (n < 10) ? "0" + n : "" + n;
	}
}
