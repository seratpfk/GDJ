package ex01_exception;

import java.util.Scanner;

public class Main {
	
	public static void m1() {  // m1이 static이기 때문에 static을 입력해야 한다.
		
		// NullPointerException : null값이 어떤 메소드를 호출할 때 발생
		String[] hobbies = new String[5];
		
		hobbies[1] = "수영";  // 인덱스를 0부터 시작하기 않았기 때문에 오류 발생
		hobbies[2] = "골프";
		hobbies[3] = "영화";
		hobbies[4] = "집콕";
		
		for(int i = 0; i < hobbies.length; i++) {
			if(hobbies[i].equals("수영")) {  // hobbies[0]의 값이 null이기 때문에 오류 발생
				System.out.println("취미가 나와 같군요");
			}
		}
	}

	
	public static void m2() {  
		
		// NullPointerException 회피
		String[] hobbies = new String[5];
		
		hobbies[1] = "수영";  
		hobbies[2] = "골프";
		hobbies[3] = "영화";
		hobbies[4] = "집콕";
		
		for(int i = 0; i < hobbies.length; i++) {
			if(hobbies[i] != null && hobbies[i].equals("수영")) { 
				//if(hobbies[i].equals("수영") && hobbies[i] != null)
				// 순서 바꾸면 오류가 남.
				System.out.println("취미가 나와 같군요");
			}
		}
	}
	
	public static void m3() {
		
		// NumberFormatException : String을 Number타입으로 변경할 때 발생
		
		Scanner sc = new Scanner(System.in);
		System.out.println("이름 입력(필수) >>> ");
		String name = sc.nextLine(); 
		System.out.println("나이 입력(선택) >>> ");
		String strAge = sc.nextLine();  // nextLine();으로 해야 엔터 입력 시 스캐너를 빠져나올 수 있음.
		int age = Integer.parseInt(strAge);  // 입력 없이 Enter만 누르면 strAge는 빈 문자열을 가짐
		
		System.out.println("이름:" + name + ", 나이:" + age + "살");
	}
	
	// NumberFormatException 회피
	
	public static void m4() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("이름 입력(필수) >>> ");
		String name = sc.nextLine(); 
		System.out.println("나이 입력(선택) >>> ");
		String strAge = sc.nextLine();  // nextLine();으로 해야 엔터 입력 시 오류가 안남.
		int age;
		if(strAge.isEmpty()) {
			age = 0;  // 입력 안했을 시 age를 0으로 출력한다.
		} else {
			age = Integer.parseInt(strAge);
		}
		
		System.out.println("이름:" + name + ", 나이:" + age + "살");
	}
	
	public static void main(String[] args) {
		
		m4();

	}

}
