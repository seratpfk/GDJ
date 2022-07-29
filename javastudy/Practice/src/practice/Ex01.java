package practice;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
		
		System.out.println("점수를 입력하세요(0~100) >>> ");
		int score = sc.nextInt();
		
		System.out.println("학년을 입력하세요(1~4) >>> ");
		int floor = sc.nextInt();
		
		if ((floor == 4 && score >= 70) || (floor <= 3  && score >= 60) ) {
			System.out.println("합격!");
		} else {
			System.out.println("불합격!");
		}

		sc.close();
		
	}

}
