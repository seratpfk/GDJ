package ex03_number;

public class Ex01 {

	public static void main(String[] args) {

		// 산술 연산
		int a = 7;
		int b = 2;
		int result1 = a + b;  // 더하기
		int result2 = a - b;  // 빼기
		int result3 = a * b;  // 곱하기
		int result4 = a / b;  // 몫
		int result5 = a % b;  // 나머지
		
		System.out.println(result1);  // 9
		System.out.println(result2);  // 5
		System.out.println(result3);  // 14
		System.out.println(result4);  // 3
		System.out.println(result5);  // 1

		// 연습문제
		// a = 7, b = 2
		// a 나누기 b = 3.5를 출력하시오.
		double result6 = (double)a/b;
		System.out.println(result6); 
		
		// 연습문제
		// 25를 몫: 2, 나머지: 5로 만드시오.
		int c = 25;
		int result7 = c / 10;
		int result8 = c % 10;
		System.out.println(result7); 
		System.out.println(result8); 
		
		// 연습
		// 90초를 1분 30초로 나눠보기
		int second = 90;
		int result9 = second / 60;
		int result10 = second % 60;
		System.out.println(result9); 
		System.out.println(result10); 
	}

}
