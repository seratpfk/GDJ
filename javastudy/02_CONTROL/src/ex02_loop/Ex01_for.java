package ex02_loop;

public class Ex01_for {

	public static void main(String[] args) {

		// for문
		// 연속된 숫자를 생성할 때 주로 사용한다.
		// 배열과 함께 자주 사용된다.
		// for(초기문; 조건문; 증감문) {
		//     실행문
		// }
		
		// 1 ~ 10 
		for(int n = 1; n <= 10; n++) {
			System.out.print(n);
		}
		
		System.out.println();
		// 초기문 -> 조건문 -> 실행문 -> 증감문 -> 조건문 -> 실행문 -> 증감문 ...
		
		System.out.println(); // 줄 바꿈
		
		// 연습문제1
		// 10 ~ 1
		
		for(int n = 10; n >= 1; n--) {
			System.out.print(n);
		}
		System.out.println();
		
		// 연습문제2
		// 구구단 7단 출력
		
		for(int n = 1; n <= 9; n++) {
			System.out.println("7X" + n + "=" + (7 * n));
		}
		
		// 연습문제3
		// 1 ~ 100 사이의 모든 3의 배수만 출력하기
		
		for(int n = 1; n <= 100; n++) {    // 1 ~ 100
			if(n % 3 == 0) {               // 1 ~ 100 중, 3의 배수만 출력
				System.out.print(n + " "); // 띄어쓰기(" "). 3 6 9 12 ...
			}
		}
		System.out.println();
		
		int wallet = 0;
		wallet += 1000;
		wallet += 2000;
		wallet += 3000;
		System.out.println(wallet);
	
		// 연습문제4
		// 1 ~ 100 모든 정수 더하기(5050)
		int total = 0; // total 변수를 생성하고
		for(int n = 1; n <= 100; n++) {
			total += n; // 1 ~ 100을 total변수에 모두 더한다.
		}
		System.out.println("전체 합: " + total);
		
		// 연습문제5
		// a ~ b 모든 정수 더하기
		// a과 b 중 누가 큰 지 모르는 상황
		// a을 b보다 항상 작은 값으로 바꾼 뒤 a ~ b 모두 더하기 진행
		// a가 b보다 크다면 a과 b를 교환
		
		// 변수 선언
		int a = 100;
		int b = 1;
		
		// a를 b보다 항상 작은 값으로 바꾸기
		if(a > b) {   // a가 b보다 크다면 a과 b를 교환
			int temp;
			temp = a;
			a = b;
			b = temp;
		}
		
		// a ~ b 모두 더하기
		int sum = 0;
		for(int n = a; n <= b; n++) {
			sum += n;
		}
		System.out.println(sum);
		
		// 연습문제6
		// 평점(1~5)에 따른 별(★) 출력하기
		int point = 4;
		String star = "";
		for(int n = 1; n <= point; n++) {
			star += "★";
		}
		System.out.println(star);

	}

}
