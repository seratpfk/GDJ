package ex03_number;

public class Ex03 {

	public static void main(String[] args) {

		// 대입 연산
		int score = 100; // 등호(=)가 대입 연산자이다.
		System.out.println(score); // 100을 score에 대입

		// 연습
		// int x = 10; int y = 20;
		// x와 y에 저장된 값을 서로 교환하시오.
		int x = 10;
		int y = 20;
		int temp;
		
		temp = x;
		x = y;
		y = temp;
		
		System.out.println(x);
		System.out.println(y);
		
		// 복합 대입 연산자
		// +=, -=, *=, /=, %= 등
		int wallet = 0; // 지갑에 0원이 있다.
		wallet = wallet + 5000; // 지갑에 5000원이 들어왔다.
		wallet += 5000;  // 5000원이 들어있는 지갑 + 5000
		wallet -= 3000;  // 10000원이 들어있는 지갑 - 3000
		System.out.println(wallet);
		
		// 연습.
		// 통장 잔액(balance)에서 이자 5%를 받았음을 나타내자.
		long balance = 10000;
		balance *= 1.05;  // balance를 double로 promotion해서 처리한다.
		System.out.println(balance);
		
		// balance = balance * 1.05;  실패. balance * 1.05 결과는 double이기 때문에 long balance에 저장할 수 없다.		
		// balance = (long)(balance * 1.05);  성공. balance * 1.05 결과를 long으로 casting해서 저장할 수 있다.
		
		// balance = balance + balance * 0.05;  실패. balance + balance * 0.05 결과는 double이기 때문에 long balance에 저장할 수 없다.
		// balance = (long)(balance + balance * 0.05);  성공. balance + balance * 0.05 결과를 long으로 casting해서 저장할 수 있다.
	}

}
