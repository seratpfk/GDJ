package practice;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("무슨 커피 드릴까요? >>> ");
		String menu = sc.next();
		switch(menu) {
		case "에스프레소":
		case "카푸치노":
		case "카페라떼": System.out.println(menu + "는 3500원 입니다."); break;
		case "아메리카노": System.out.println(menu + "는 2000원 입니다."); break;
		default: System.out.println("없는메뉴"); 
		}
		
		sc.close();

	}

}
