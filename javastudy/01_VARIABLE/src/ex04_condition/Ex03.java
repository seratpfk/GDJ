package ex04_condition;

public class Ex03 {

	public static void main(String[] args) {
		
		// 조건 연산자
		// 조건을 만족하는 경우와 그렇지 않은 경우 모두를 처리하는 연산
		// 형식
		// 조건 ? 만족하는 경우 : 만족하지 않는 경우 
		
		int score = 50;
		String result = (score >= 60) ? "합격" : "불합격";
		System.out.println(result);
		
		// 연습문제1
		// 순위가 1이면 "금메달', 순위가 2이면 "은메달", 순위가 3이면 "동메달"
		// 나머지 순위는 "없음"
		int rank = 4;
		String medal = (rank == 1) ? "금메달" : (rank == 2) ? "은메달" : (rank == 3) ? "동메달" : "없음";
		System.out.println(medal);
				
		// 연습문제2
		// 홀수는 "홀수", 짝수는 "짝수"
		// 힌트
		// 홀수 -2로 나눈 나머지가 1인 수
		// 짝수 -2로 나눈 나머지가 0인 수
		int n = 3;
		String type = (n%2 == 1) ? "홀수" : "짝수";
		System.out.println(type);
		
		// 연습문제3
		// 홀수는 "홀수", 짝수는 "짝수", 3의 배수는 "3의 배수"
		// 힌트
		// 3의 배수 - 3으로 나눈 나머지가 0인 수 (단, 0은 고려하지 않는다.)
		int a = 6;
		String type2 = (a%3 ==0) ? "3의 배수" : (a%2 == 1) ? "홀수" : "짝수";
		System.out.println(type2);
		
		// 연습문제4
		// 주민등록번호 뒷 7자리 중 첫 번째 숫자가 1,3,5이면 "남자", 2,4,6이면 "여자"
		int serial = 1234567;
		String gender = ((serial/1000000) %2 == 1) ? "남자" : "여자";
		System.out.println(gender);

	}

}
